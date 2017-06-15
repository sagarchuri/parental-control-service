package sagachuri.parentalcontrol.api.movie;

public class TechnicalFailureException extends Exception{

	private static final long serialVersionUID = -8272398275920821202L;

	public TechnicalFailureException(String message){
		super(message);
	}
}
