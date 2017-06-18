package sagarchuri.parentalcontrol.data;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import sagachuri.parentalcontrol.data.ParentalControlLevel;

public class ParentalControlLevelTest {
	
	@Test
	public void getLevelTest(){
		assertTrue(ParentalControlLevel.FIFTEEN.getLevel().equals("15"));
		assertTrue(ParentalControlLevel.PG.getLevel().equals("PG"));
		assertTrue(ParentalControlLevel.U.getLevel().equals("U"));
		assertTrue(ParentalControlLevel.TWELVE.getLevel().equals("12"));
		assertTrue(ParentalControlLevel.EIGHTEEN.getLevel().equals("18"));
	}
	
	@Test
	public void getAgeTest(){
		assertTrue(ParentalControlLevel.FIFTEEN.getAge().equals(15));
		assertTrue(ParentalControlLevel.PG.getAge().equals(10));
		assertTrue(ParentalControlLevel.U.getAge().equals(0));
		assertTrue(ParentalControlLevel.TWELVE.getAge().equals(12));
		assertTrue(ParentalControlLevel.EIGHTEEN.getAge().equals(18));
	}
	
}
