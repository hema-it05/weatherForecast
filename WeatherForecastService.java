package weatherimplementation.service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import weatherimplementation.customdto.WeatherDetailsDto;
import weatherimplementation.customdto.WeatherForeCastDto;
import weatherimplementation.entity.LocationDetails;
import weatherimplementation.entity.WeatherDetails;
import weatherimplementation.exception.ErrorCode;
import weatherimplementation.exception.WeatherForecastException;
import weatherimplementation.repository.LocationDetailsRepository;
import weatherimplementation.repository.WeatherDetailsRepository;

@Service
public class WeatherForecastService {

	public static final String weatherurl = "https://api.openweathermap.org/data/2.5/weather?q=";
	public static final String apiKey = "f9df00277954659caf43917878519bb8";
	public static final String urlForWeeklyForecast = "https://api.openweathermap.org/data/2.5/forecast?q=";
	// for the below url my api key is invalid
	public static final String dateRangeForecastUrl = "https://history.openweathermap.org/data/2.5/history/city?q=";

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	LocationDetailsRepository locationDetailsRepository;

	@Autowired
	WeatherDetailsRepository weatherDetailsRepository;

	public WeatherForeCastDto getWeatherForecastForCurrentDay(String city_name) {
		String weather = weatherurl + city_name + "&appid=" + apiKey;
		WeatherForeCastDto weatherData = restTemplate.getForObject(weather.toString(), WeatherForeCastDto.class);
		return weatherData;
	}

	public List<WeatherDetails> getWeatherForecastForAWeek(String city_name)
			throws ParseException, WeatherForecastException {
		LocationDetails loc = locationDetailsRepository.findByCityName(city_name);
		List<WeatherDetails> weatherDataList = new ArrayList<WeatherDetails>();
		String url = urlForWeeklyForecast + city_name + "&cnt=40&appid=" + apiKey;
		WeatherForeCastDto weatherData = null;
		try {
			if (loc != null) {
				List<WeatherDetails> data1 = getResponse();
				List<Date> existingDates = data1.stream().map(x -> x.getDateOfWeather()).sorted()
						.collect(Collectors.toList());
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date fromDate = formatter.parse(formatter.format(new java.util.Date()));
				Date toDate = getToDate(fromDate);
				List<Date> neededDates = listOfDates(fromDate, toDate);
				if (existingDates.containsAll(neededDates)) {
					return data1;
				} else {
					Date lastexistingDate = existingDates.get(existingDates.size() - 1);
					Calendar c = Calendar.getInstance();
					c.setTime(lastexistingDate);
					c.add(Calendar.DATE, 1);
					Date newFromDate = c.getTime();
					Date newToDate = getToDate(newFromDate);
					System.out.println("False");
					/*
					 * here we need to call another openweather API to find the range of date that
					 * is needed but for my api key that was not working so left it as such here..
					 * If that is working then my logic here is to call the openweather api for that
					 * range and set the details as in the else part
					 */

					String rangeUrl = dateRangeForecastUrl + city_name + "&type=hour&start=" + newFromDate + "&end="
							+ newToDate + "&units=imperial&appid=" + apiKey;
					weatherData = restTemplate.getForObject(rangeUrl.toString(), WeatherForeCastDto.class);
					if (weatherData.getCod().equals("401"))
						throw new WeatherForecastException(ErrorCode.API_ERROR, weatherData.getMessage());
					else
						return data1;
				}

			} else {
				weatherData = restTemplate.getForObject(url.toString(), WeatherForeCastDto.class);
				LocationDetails locationDetails = new LocationDetails();
				locationDetails.setCityName(city_name);
				locationDetails.setCountryName(weatherData.getCity().getCountry());
				locationDetails.setLatitude(weatherData.getCity().getCoord().getLat());
				locationDetails.setLongitude(weatherData.getCity().getCoord().getLon());
				locationDetailsRepository.save(locationDetails);
				Map<String, Integer> data = new HashMap<String, Integer>();

				for (WeatherDetailsDto details : weatherData.getList()) {
					if (!data.containsKey(details.getDt_txt().substring(0, 10)))
						data.put(details.getDt_txt().substring(0, 10), weatherData.getList().indexOf(details));
				}
				for (Map.Entry<String, Integer> entry : data.entrySet()) {
					WeatherDetails weatherDetails = new WeatherDetails();
					weatherDetails.setDateOfWeather(new SimpleDateFormat("yyyy-MM-dd").parse(entry.getKey()));
					WeatherDetailsDto details = weatherData.getList().get(entry.getValue());
					weatherDetails.setMaxTemp(details.getMain().getTemp_max());
					weatherDetails.setMinTemp(details.getMain().getTemp_min());
					weatherDetails.setWeatherDescription(details.getWeather().get(0).getDescription());
					weatherDetails.setPressure(details.getMain().getPressure());
					weatherDetails.setHumidity(details.getMain().getHumidity());
					weatherDetails.setNormalTemp(details.getMain().getTemp());
					weatherDetails.setLocation(locationDetails);
					weatherDataList.add(weatherDetails);
				}
				weatherDetailsRepository.saveAll(weatherDataList);
				return getResponse();
			}
		} catch (HttpClientErrorException e) {
			System.out.println(e.getResponseBodyAsString());
			WeatherForecastException we = new WeatherForecastException(ErrorCode.INVALID_INPUT_ERROR,
					e.getResponseBodyAsString());
			WeatherDetails weatherDetails = new WeatherDetails();
			weatherDetails.setWeatherDescription(we.getDescription());
			weatherDataList.add(weatherDetails);
			return weatherDataList;
		}
	}

	List<WeatherDetails> getResponse() throws WeatherForecastException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date fromDate = null;
		Date toDate = null;
		try {
			fromDate = formatter.parse(formatter.format(new java.util.Date()));
			toDate = getToDate(fromDate);
		} catch (ParseException e) {
			throw new WeatherForecastException(ErrorCode.DATE_ERROR, "Date Not Able to Parse");
			// e.printStackTrace();
		}
		return weatherDetailsRepository.findByDateOfWeatherBetween(fromDate, toDate);
	}

	public Date getToDate(Date fromDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(fromDate);
		c.add(Calendar.DATE, 5);
		Date toDate = c.getTime();
		return toDate;
	}

	public List<Date> listOfDates(Date fromDate, Date toDate) {
		List<Date> dates = new ArrayList<>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(fromDate);
		while (calendar.getTime().before(toDate)) {
			Date result = calendar.getTime();
			dates.add(result);
			calendar.add(Calendar.DATE, 1);
		}
		return dates;
	}

}
