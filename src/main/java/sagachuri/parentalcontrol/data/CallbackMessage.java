package sagachuri.parentalcontrol.data;

/**
 * Callback message provides additional information to the client
 * 
 */
public interface CallbackMessage {
	
	String PARENTAL_CONTROL_SERVICE_NOT_INITIALISED = "Parental Control level service not initialised";
	
	String MOVIE_SERVICE_NOT_INITIALISED = "Movie service not initialised";
	
	String TITLE_NOT_FOUND_EXCEPTION_MESSAGE = "Sorry, could not find title you are looking for";
	
	String TECHNICAL_FAILURE_EXCEPTION_MESSAGE = "Sorry, technical failure";

	void setMessage(String message);
	
}