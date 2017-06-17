package sagachuri.parentalcontrol.service;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sagachuri.parentalcontrol.data.ParentalControlLevel;

public class VerifyControlLevelServiceImpl implements VerifyControlLevelService{

	private static final String CLASSNAME = "sagarchuri.parentalcontrol.data.ParentalControlLevel.VerifyControlLevelServiceImpl";
	private static final Logger logger = LogManager.getLogger(CLASSNAME);
    
	/*
	 * (non-Javadoc)
	 * @see sagachuri.parentalcontrol.service.VerifyControlLevelService#isControlLevelOK(java.lang.String, java.lang.String)
	 */
	public Boolean isControlLevelOK(final String preferredLevel, final String movieLevel) {
		logger.info("isControlLevelOK is called with preferredLevel {} movieLevel",preferredLevel,movieLevel);
		ParentalControlLevel preferred  = getParentalControlLevel(preferredLevel);
		ParentalControlLevel movie  = getParentalControlLevel(movieLevel);
		if(preferred ==null) {
			logger.log(Level.WARN,"Invalid preferred parental control level. returning false");
			return false;
		}
		if(movie ==null) {
			logger.log(Level.WARN,"Invalid movie parental control level. returning false");
			return false;
		}
		logger.info("preferred parental control age is {} and movie age restriction is {}",preferred.getAge(),movie.getAge());
		if(preferred.getAge() >= movie.getAge()){
			return true;
		}
		return false;
	}
	
	/**
	 * Returns Parental control level enum for the given level 
	 * @param level
	 * @return
	 */
	private ParentalControlLevel getParentalControlLevel(String level) {
		if(level == null) return null;
		else{
			for(ParentalControlLevel p :ParentalControlLevel.values()) {
				if(p.getLevel().equals(level)) return p;
			}
			return null;
		}
	}

}
