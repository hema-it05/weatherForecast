package weatherimplementation.exception;

public enum ErrorCode {

	DATE_ERROR("WEA_FORE_0000", 500, "Date Unparseable Error"),
	
	API_ERROR("WEA_FORE_0001", 401, "API KEY Error"),
	
	INVALID_INPUT_ERROR("WEA_FORE_0002", 404, "Input is Invalid")
	
	;
	
	
	private final String code;

	/**
	 * httpStatus - HTTP STATUS Code translation of the error code. For example if
	 * we get an error that corresponds to something that cannot be found,
	 * httpStatusCode for such an Error will be 404.
	 */
	private final int httpStatus;

	/**
	 * description - Description of the error. This string will be used to set the
	 * exception message.
	 */
	private final String description;

	ErrorCode(String code, int httpStatus, String description) {
		this.code = code;
		this.httpStatus = httpStatus;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public String getDescription() {
		return description;
	}

}
