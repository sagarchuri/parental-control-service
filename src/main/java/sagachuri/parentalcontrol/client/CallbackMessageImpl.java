package sagachuri.parentalcontrol.client;

import sagachuri.parentalcontrol.data.CallbackMessage;

public class CallbackMessageImpl implements CallbackMessage{
	
	private String message;

	public void setMessage(String message) {
		this.message = message;
		
	}
	
	public String getMessage(){
		return message;
	}

}
