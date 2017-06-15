package sagachuri.parentalcontrol.api.movie;

public interface MovieService {

	String getParentalControlLevel(String movieId) 
		throws TitleNotFoundException, TechnicalFailureException;

}