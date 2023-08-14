package weatherimplementation.entity;

import java.util.Date;
import java.time.Instant;
import java.time.ZoneOffset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "weatherdetails")
public class WeatherDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long weatherId;
	
	@Column(name="normaltemp")
	private Double normalTemp;
	
	@Column(name="mintemp")
	private Double minTemp;
	
	@Column(name="maxtemp")
	private Double maxTemp;
	
	@Column(name = "created_date" , updatable = false)
	@JsonIgnore
	private Instant createdDate = Instant.now().atOffset(ZoneOffset.UTC).toInstant();
	
	@Column(name="sunrisetime")
	private Instant sunriseTime;
	
	@Column(name="sunsettime")
	private Instant sunsetTime;
	
	@Column(name="weatherdescription")
	private String weatherDescription;
	
	@ManyToOne
	@JoinColumn(name = "locationid")
	private LocationDetails location;
	
	@Column(name="dt_txt")
	private Date dateOfWeather;
	
	@Column(name="pressure")
	private Long pressure;
	
	@Column(name="humidity")
	private Long humidity;
	
	

	public Long getWeatherId() {
		return weatherId;
	}

	public void setWeatherId(Long weatherId) {
		this.weatherId = weatherId;
	}

	public Double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(Double minTemp) {
		this.minTemp = minTemp;
	}

	public Double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(Double maxTemp) {
		this.maxTemp = maxTemp;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public Instant getSunriseTime() {
		return sunriseTime;
	}

	public void setSunriseTime(Instant sunriseTime) {
		this.sunriseTime = sunriseTime;
	}

	public Instant getSunsetTime() {
		return sunsetTime;
	}

	public void setSunsetTime(Instant sunsetTime) {
		this.sunsetTime = sunsetTime;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public LocationDetails getLocation() {
		return location;
	}

	public void setLocation(LocationDetails location) {
		this.location = location;
	}

	public Double getNormalTemp() {
		return normalTemp;
	}

	public void setNormalTemp(Double normalTemp) {
		this.normalTemp = normalTemp;
	}

	public Date getDateOfWeather() {
		return dateOfWeather;
	}

	public void setDateOfWeather(Date dateOfWeather) {
		this.dateOfWeather = dateOfWeather;
	}

	public Long getPressure() {
		return pressure;
	}

	public void setPressure(Long pressure) {
		this.pressure = pressure;
	}

	public Long getHumidity() {
		return humidity;
	}

	public void setHumidity(Long humidity) {
		this.humidity = humidity;
	}
}
