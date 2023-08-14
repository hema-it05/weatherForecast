package weatherimplementation.customdto;

import java.time.Instant;

public class City {

	private Long id;

	private String name;

	private String country;

	private Long population;

	private Long timeZone;

	private Coordinates coord;
	
	private Instant sunrise;

	private Instant sunset;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Instant getSunrise() {
		return sunrise;
	}

	public void setSunrise(Instant sunrise) {
		this.sunrise = sunrise;
	}

	public Instant getSunset() {
		return sunset;
	}

	public void setSunset(Instant sunset) {
		this.sunset = sunset;
	}

	public Long getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(Long timeZone) {
		this.timeZone = timeZone;
	}
}
