package sagachuri.parentalcontrol.service;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sagachuri.parentalcontrol.api.movie.MovieService;
import sagachuri.parentalcontrol.api.movie.TechnicalFailureException;
import sagachuri.parentalcontrol.api.movie.TitleNotFoundException;
import sagachuri.parentalcontrol.data.CallbackMessage;

public class ParentalControlServiceImpl implements ParentalControlService{
	
	private final MovieService movieService; 
	private final VerifyControlLevelService controlLevelService;
	
	private static final String CLASSNAME = "sagarchuri.parentalcontrol.service.ParentalControlServiceImpl";
	private static final Logger logger = LogManager.getLogger(CLASSNAME);
    
	
	public ParentalControlServiceImpl(MovieService movieService, VerifyControlLevelService controlLevelService){
		this.movieService = movieService;
		this.controlLevelService = controlLevelService;
	}

	public Boolean isMovieAllowedToWatch(final String pControlLevel, final String movieId,final CallbackMessage callback) {
		String callbackMessage = "";
		try{
			logger.info("isMovieAllowedToWatch is called with parentcontrol {} movieId {} callback {}"
					,pControlLevel,movieId,callback);
			//check if the service is available 
			if(movieService == null) {
				logger.log(Level.WARN,"movieService is null. returning false");
				callbackMessage = CallbackMessage.MOVIE_SERVICE_NOT_INITIALISED;
			}
			else if(controlLevelService == null) {
				logger.log(Level.WARN,"controlLevelService is null. returning false");
				callbackMessage = CallbackMessage.PARENTAL_CONTROL_SERVICE_NOT_INITIALISED;
			}
			else{
				String movieParentalLevel = movieService.getParentalControlLevel(movieId);
				return controlLevelService.isControlLevelOK(pControlLevel, movieParentalLevel);
			}
		}catch(TitleNotFoundException | TechnicalFailureException  e){
			callbackMessage = e.getMessage();
			logger.log(Level.WARN,
					"Exception thrown while invoking MovieService.getParentalControlLevel :" +e.getMessage());
		}
		if(callback != null){
			callback.setMessage(callbackMessage);
		}
		return false;
	}

}
