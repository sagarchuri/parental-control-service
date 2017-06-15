package sagachuri.parentalcontrol.client;

import java.util.Scanner;

import sagachuri.parentalcontrol.data.ParentalControlLevel;
import sagachuri.parentalcontrol.service.ParentalControlService;
import sagachuri.parentalcontrol.service.ParentalControlServiceImpl;
import sagachuri.parentalcontrol.service.VerifyControlLevelServiceImpl;

public class Main {
	
	private static Scanner scanner;

	public static void main(String[] args){
		
		System.out.println("****Welcome to the Parent control Service****");
		System.out.print("Parental control levels are : ");
		for(ParentalControlLevel p :ParentalControlLevel.values()) {
			System.out.print(p.getLevel()+ " ");
		}
		System.out.println();
		System.out.println("Available movies are : AB CD XY PQ");
		System.out.println("********************************************\n");
		//Using test services 
		ParentalControlService parentalControlService =
				new ParentalControlServiceImpl(new MovieServiceImpl(), new VerifyControlLevelServiceImpl());
		
		System.out.println("Please enter your parental control preference");
		scanner = new Scanner(System.in);
		final String pfLevel = scanner.next();
		System.out.println("Thank you. Please enter your movie id");
		final String movie = scanner.next();
		
		boolean result = parentalControlService.isMovieAllowedToWatch(pfLevel, movie, new CallbackMessageImpl());
		
		System.out.println(result? "You are allowed to watch this movie. ":
			"Sorry, You are not allowed to watch this movie.");
		
	}

}
