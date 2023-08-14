package weatherimplementation.customdto;

public class MainTemp {

	private Double temp;

	private Double feels_like;

	private Double temp_min;

	private Double temp_max;

	private Long pressure;

	private Long sea_level;

	private Long grnd_level;

	private Long humidity;

	private Long temp_kf;

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Double getFeels_like() {
		return feels_like;
	}

	public void setFeels_like(Double feels_like) {
		this.feels_like = feels_like;
	}

	public Double getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}

	public Double getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}

	public Long getPressure() {
		return pressure;
	}

	public void setPressure(Long pressure) {
		this.pressure = pressure;
	}

	public Long getSea_level() {
		return sea_level;
	}

	public void setSea_level(Long sea_level) {
		this.sea_level = sea_level;
	}

	public Long getGrnd_level() {
		return grnd_level;
	}

	public void setGrnd_level(Long grnd_level) {
		this.grnd_level = grnd_level;
	}

	public Long getHumidity() {
		return humidity;
	}

	public void setHumidity(Long humidity) {
		this.humidity = humidity;
	}

	public Long getTemp_kf() {
		return temp_kf;
	}

	public void setTemp_kf(Long temp_kf) {
		this.temp_kf = temp_kf;
	}

}
