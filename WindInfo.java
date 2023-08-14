package weatherimplementation.customdto;

public class WindInfo {

	private Double speed;
	
	private Long deg;
	
	private Double gust;

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Long getDeg() {
		return deg;
	}

	public void setDeg(Long deg) {
		this.deg = deg;
	}

	public Double getGust() {
		return gust;
	}

	public void setGust(Double gust) {
		this.gust = gust;
	}
}
