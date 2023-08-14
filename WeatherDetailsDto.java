package weatherimplementation.customdto;


import java.util.List;

public class WeatherDetailsDto {

	private CloudsInfo clouds;
	  
	 private WindInfo wind;
	 
	 private Long visibility;
	 
	 private Double pop;
	      
	 private RainInfo rain;    
	     
	private String dt_txt;
	
	private MainTemp main; 
	
	private List<Weather> weather;

	public CloudsInfo getClouds() {
		return clouds;
	}

	public void setClouds(CloudsInfo clouds) {
		this.clouds = clouds;
	}

	public WindInfo getWind() {
		return wind;
	}

	public void setWind(WindInfo wind) {
		this.wind = wind;
	}

	public Long getVisibility() {
		return visibility;
	}

	public void setVisibility(Long visibility) {
		this.visibility = visibility;
	}

	public Double getPop() {
		return pop;
	}

	public void setPop(Double pop) {
		this.pop = pop;
	}

	public RainInfo getRain() {
		return rain;
	}

	public void setRain(RainInfo rain) {
		this.rain = rain;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

	
	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	/**
	 * @return the main
	 */
	public MainTemp getMain() {
		return main;
	}

	/**
	 * @param main the main to set
	 */
	public void setMain(MainTemp main) {
		this.main = main;
	}
	
	
}


