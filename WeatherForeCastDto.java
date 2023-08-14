package weatherimplementation.customdto;

import java.util.List;

public class WeatherForeCastDto {

	private String cod; // Internal parameter

	private String message; // message

	private Integer cnt; // Number Of Days

	private List<WeatherDetailsDto> list;

	private City city;

	
	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	
	/**
	 * @return the list
	 */
	public List<WeatherDetailsDto> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<WeatherDetailsDto> list) {
		this.list = list;
	}


}
