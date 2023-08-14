package weatherimplementation.exception;

public class WeatherForecastException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final ErrorCode errorCode;

	private final String description;
	
	public WeatherForecastException(ErrorCode errorCode) {
		super(errorCode.getDescription());
		this.description = errorCode.getDescription();
		this.errorCode = errorCode;
	}

	/**
	 * Constructor to create an TvsCloudPlatformException to show the message given
	 * but not the description in the ErrorCode enum.
	 * 
	 * @param errorCode Error code enum
	 * @param message   message that needs to be shown
	 */
	public WeatherForecastException(ErrorCode errorCode, String message) {
		super(message);
		this.description = message;
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public String getDescription() {
		return description;
	}
}
