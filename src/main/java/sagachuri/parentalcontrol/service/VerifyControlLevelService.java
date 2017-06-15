package sagachuri.parentalcontrol.service;

public interface VerifyControlLevelService {

	/**
	 * Verifies if the parental control level is OK
	 * Returns true if movieLevel is within preferred limit, false otherwise
	 * @param preferredLevel
	 * @param movieLevel
	 * @return Boolean
	 */
	Boolean isControlLevelOK(String preferredLevel, String movieLevel);
}
