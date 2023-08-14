package weatherimplementation.customdto;

public class Temperature {

	private Double day;
	
	private Double temp_min;
	
	private Double temp_max; 
	
	private Double night;
	
	private Double eve;
	
	private Double morn;
	
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

	public Double getDay() {
		return day;
	}

	public void setDay(Double day) {
		this.day = day;
	}

	public Double getNight() {
		return night;
	}

	public void setNight(Double night) {
		this.night = night;
	}

	public Double getEve() {
		return eve;
	}

	public void setEve(Double eve) {
		this.eve = eve;
	}

	public Double getMorn() {
		return morn;
	}

	public void setMorn(Double morn) {
		this.morn = morn;
	}

	
	
	
}
