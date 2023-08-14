package weatherimplementation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weatherimplementation.customdto.WeatherForeCastDto;
import weatherimplementation.entity.WeatherDetails;
import weatherimplementation.service.WeatherForecastService;

@RestController
@RequestMapping("/api")
public class WeatherForecastResource {

	@Autowired
	WeatherForecastService weatherForecastService;

	@GetMapping("/getWeather/{city_name}")
	public WeatherForeCastDto getWeatherForecastForToday(@PathVariable String city_name) {
		return weatherForecastService.getWeatherForecastForCurrentDay(city_name);
	}
	
	@GetMapping("/getWeatherForecast/{city_name}")
	public List<WeatherDetails> getWeatherForecastForAWeek(@PathVariable String city_name) throws Exception {
		return weatherForecastService.getWeatherForecastForAWeek(city_name);
	}

}
