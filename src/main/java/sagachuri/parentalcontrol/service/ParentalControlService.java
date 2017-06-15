package sagachuri.parentalcontrol.service;

import sagachuri.parentalcontrol.data.CallbackMessage;

public interface ParentalControlService {
	/**
	 * 
	 * @param parentControlLevel
	 * @param movieId
	 * @param callback
	 * @return
	 */
	Boolean isMovieAllowedToWatch(String parentControlLevel, String movieId, CallbackMessage callback);

}
