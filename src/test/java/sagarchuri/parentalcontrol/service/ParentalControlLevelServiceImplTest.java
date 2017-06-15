package sagarchuri.parentalcontrol.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import sagachuri.parentalcontrol.api.movie.MovieService;
import sagachuri.parentalcontrol.api.movie.TechnicalFailureException;
import sagachuri.parentalcontrol.api.movie.TitleNotFoundException;
import sagachuri.parentalcontrol.data.CallbackMessage;
import sagachuri.parentalcontrol.service.ParentalControlService;
import sagachuri.parentalcontrol.service.ParentalControlServiceImpl;
import sagachuri.parentalcontrol.service.VerifyControlLevelService;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;


@RunWith(MockitoJUnitRunner.class)
public class ParentalControlLevelServiceImplTest {
	
	@Mock
	private MovieService movieService;
	
	@Mock
	private VerifyControlLevelService verifyControlLevelService;
	
	@Mock
	private CallbackMessage callbackMessage;
	
	
	private ParentalControlService parentalControlService;
	
	@Test
	public void isMovieAllowedToWatchOk() throws Exception{
		parentalControlService = new ParentalControlServiceImpl(movieService,verifyControlLevelService);
		
		//expectations
		when(movieService.getParentalControlLevel("ABC")).thenReturn("15");
		when(verifyControlLevelService.isControlLevelOK("15", "15")).thenReturn(Boolean.TRUE);
		
		final boolean output = parentalControlService.isMovieAllowedToWatch("15", "ABC", callbackMessage);
		
		assert(output == true);
		verifyZeroInteractions(callbackMessage);
		verify(verifyControlLevelService,times(1)).isControlLevelOK("15","15");
	}
	
	@Test
	public void isMovieAllowedToWatchFail() throws Exception{
		parentalControlService = new ParentalControlServiceImpl(movieService,verifyControlLevelService);
		
		//expectations
		when(movieService.getParentalControlLevel("XYZ")).thenReturn("PG");
		when(verifyControlLevelService.isControlLevelOK("U", "PG")).thenReturn(Boolean.FALSE);
		
		final boolean output = parentalControlService.isMovieAllowedToWatch("U", "XYZ", callbackMessage);
		
		assert(output == false);
		verifyZeroInteractions(callbackMessage);
		verify(verifyControlLevelService,times(1)).isControlLevelOK("U","PG");
	}
	
	@Test
	public void isMovieAllowedToWatchInvalidMovie() throws Exception{
		parentalControlService = new ParentalControlServiceImpl(movieService,verifyControlLevelService);
		
		//expectations
		when(movieService.getParentalControlLevel("XYZ")).thenThrow(new TitleNotFoundException(CallbackMessage.TITLE_NOT_FOUND_EXCEPTION_MESSAGE));
		when(verifyControlLevelService.isControlLevelOK("U", "PG")).thenReturn(Boolean.TRUE);
		
		final boolean output = parentalControlService.isMovieAllowedToWatch("INVALID", "XYZ", callbackMessage);
		
		assert(output == false);
		verify(callbackMessage).setMessage(eq(CallbackMessage.TITLE_NOT_FOUND_EXCEPTION_MESSAGE));
		verifyZeroInteractions(verifyControlLevelService);
	}
	
	@Test
	public void isMovieAllowedToWatchTechFailure() throws Exception{
		parentalControlService = new ParentalControlServiceImpl(movieService,verifyControlLevelService);
		
		//expectations
		when(movieService.getParentalControlLevel("PQ")).thenThrow(new TechnicalFailureException(CallbackMessage.TECHNICAL_FAILURE_EXCEPTION_MESSAGE));
		when(verifyControlLevelService.isControlLevelOK("15", "12")).thenReturn(Boolean.TRUE);
		
		final boolean output = parentalControlService.isMovieAllowedToWatch("15", "PQ", callbackMessage);
		
		assert(output == false);
		verify(callbackMessage).setMessage(eq(CallbackMessage.TECHNICAL_FAILURE_EXCEPTION_MESSAGE));
		verifyZeroInteractions(verifyControlLevelService);
	}
	
	@Test
	public void isMovieAllowedToWatchNullMovieService() throws Exception{
		
		parentalControlService = new ParentalControlServiceImpl(null,verifyControlLevelService);
		
		//expectations
		when(movieService.getParentalControlLevel("PQ")).thenReturn("12");
		when(verifyControlLevelService.isControlLevelOK("15", "12")).thenReturn(Boolean.TRUE);
		
		final boolean output = parentalControlService.isMovieAllowedToWatch("15", "PQ", callbackMessage);
		
		assert(output == false);
		verify(callbackMessage).setMessage(eq(CallbackMessage.MOVIE_SERVICE_NOT_INITIALISED));
		verifyZeroInteractions(verifyControlLevelService);
	}
	
	@Test
	public void isMovieAllowedToWatchNullParentalLevelService() throws Exception{
		
		parentalControlService = new ParentalControlServiceImpl(movieService,null);
		
		//expectations
		when(movieService.getParentalControlLevel("PQ")).thenReturn("12");
		when(verifyControlLevelService.isControlLevelOK("15", "12")).thenReturn(Boolean.TRUE);
		
		final boolean output = parentalControlService.isMovieAllowedToWatch("15", "PQ", callbackMessage);
		
		assert(output == false);
		verify(callbackMessage).setMessage(eq(CallbackMessage.PARENTAL_CONTROL_SERVICE_NOT_INITIALISED));
		verifyZeroInteractions(verifyControlLevelService);
	}
	
	@Test
	public void isMovieAllowedToWatchNullCallback() throws Exception{
		
		parentalControlService = new ParentalControlServiceImpl(movieService,verifyControlLevelService);
		
		//expectations
		when(movieService.getParentalControlLevel("PQ")).thenReturn("12");
		when(verifyControlLevelService.isControlLevelOK("15", "12")).thenReturn(Boolean.TRUE);
		
		final boolean output = parentalControlService.isMovieAllowedToWatch("15", "PQ", null);
		
		assert(output == true);
		verifyZeroInteractions(callbackMessage);
		verify(verifyControlLevelService,times(1)).isControlLevelOK("15","12");
	}
	
	@Test
	public void isMovieAllowedToWatchSameLevel() throws Exception{
		
		parentalControlService = new ParentalControlServiceImpl(movieService,verifyControlLevelService);
		
		//expectations
		when(movieService.getParentalControlLevel("ST")).thenReturn("18");
		when(verifyControlLevelService.isControlLevelOK("18", "18")).thenReturn(Boolean.TRUE);
		
		final boolean output = parentalControlService.isMovieAllowedToWatch("18", "ST", callbackMessage);
		
		assert(output == true);
		verifyZeroInteractions(callbackMessage);
		verify(verifyControlLevelService,times(1)).isControlLevelOK("18","18");
	}

}
