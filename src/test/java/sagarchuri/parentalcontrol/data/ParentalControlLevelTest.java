package sagarchuri.parentalcontrol.data;

import org.junit.Test;

import sagachuri.parentalcontrol.data.ParentalControlLevel;

public class ParentalControlLevelTest {
	
	@Test
	public void getLevelTest(){
		assert(ParentalControlLevel.FIFTEEN.getLevel().equals("15"));
		assert(ParentalControlLevel.PG.getLevel().equals("PG"));
		assert(ParentalControlLevel.U.getLevel().equals("U"));
		assert(ParentalControlLevel.TWELVE.getLevel().equals("12"));
		assert(ParentalControlLevel.EIGHTEEN.getLevel().equals("18"));
	}
	
	@Test
	public void getAgeTest(){
		assert(ParentalControlLevel.FIFTEEN.getAge().equals(15));
		assert(ParentalControlLevel.PG.getAge().equals(10));
		assert(ParentalControlLevel.U.getAge().equals(0));
		assert(ParentalControlLevel.TWELVE.getAge().equals(12));
		assert(ParentalControlLevel.EIGHTEEN.getAge().equals(18));
	}
	
}
