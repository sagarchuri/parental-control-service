package sagachuri.parentalcontrol.client;

import sagachuri.parentalcontrol.api.movie.MovieService;
import sagachuri.parentalcontrol.api.movie.TechnicalFailureException;
import sagachuri.parentalcontrol.api.movie.TitleNotFoundException;
import sagachuri.parentalcontrol.data.CallbackMessage;

/**
 * Fake implementation of Movie service for testing purpose
 * @author SAGAR
 *
 */
public class MovieServiceImpl implements MovieService{

	public String getParentalControlLevel(final String movieId) throws TitleNotFoundException, TechnicalFailureException {
		switch(movieId){
		case "AB" : return "U";
		case "CD" : return "PG";
		case "XY" : return "15";
		case "PQ" : return "18";
		case "hello" :  throw new TechnicalFailureException(CallbackMessage.TECHNICAL_FAILURE_EXCEPTION_MESSAGE);
		default : throw new TitleNotFoundException(CallbackMessage.TITLE_NOT_FOUND_EXCEPTION_MESSAGE);
		}
	}

}
