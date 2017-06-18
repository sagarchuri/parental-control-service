package sagarchuri.parentalcontrol.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sagachuri.parentalcontrol.service.VerifyControlLevelService;
import sagachuri.parentalcontrol.service.VerifyControlLevelServiceImpl;

public class VerifyControlLevelServiceImplTest {
	
	private VerifyControlLevelService verifyControlLevelService;
	
	@Before
    public void setUp() {
		verifyControlLevelService = new VerifyControlLevelServiceImpl();
    }
	
	@After
	public void tearDown(){
		verifyControlLevelService = null;
	}

	@Test
	public void isControlLevelOKFailTest(){
		assertFalse(verifyControlLevelService.isControlLevelOK("PG", "15"));
	}
	
	@Test
	public void isControlLevelOKPassTest(){
		assertTrue(verifyControlLevelService.isControlLevelOK("15", "PG"));
	}
	
	@Test
	public void isControlLevelOKEqualTest(){
		assertTrue(verifyControlLevelService.isControlLevelOK("15", "15"));
	}
	
	@Test
	public void isControlLevelOKInvalidTest(){
		assertFalse(verifyControlLevelService.isControlLevelOK("U", "he"));
	}
	
	@Test
	public void isControlLevelOKUPGTest(){
		assertFalse(verifyControlLevelService.isControlLevelOK("U", "PG"));
	}
	
	@Test
	public void isControlLevelOKEighteenUTest(){
		assertTrue(verifyControlLevelService.isControlLevelOK("18", "U"));
	}
	
	@Test
	public void isControlLevelOKNullTest(){
		assertFalse(verifyControlLevelService.isControlLevelOK(null,null));
	}
	
}
