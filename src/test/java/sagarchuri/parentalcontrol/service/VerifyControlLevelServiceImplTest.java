package sagarchuri.parentalcontrol.service;

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
		assert(verifyControlLevelService.isControlLevelOK("PG", "15") == false);
	}
	
	@Test
	public void isControlLevelOKPassTest(){
		assert(verifyControlLevelService.isControlLevelOK("15", "PG") == true);
	}
	
	@Test
	public void isControlLevelOKEqualTest(){
		assert(verifyControlLevelService.isControlLevelOK("15", "15") == true);
	}
	
	@Test
	public void isControlLevelOKInvalidTest(){
		assert(verifyControlLevelService.isControlLevelOK("U", "he") == false);
	}
	
	@Test
	public void isControlLevelOKUPGTest(){
		assert(verifyControlLevelService.isControlLevelOK("U", "PG") == false);
	}
	
	@Test
	public void isControlLevelOKEighteenUTest(){
		assert(verifyControlLevelService.isControlLevelOK("18", "U") == true);
	}
	
	@Test
	public void isControlLevelOKNullTest(){
		assert(verifyControlLevelService.isControlLevelOK(null,null) == false);
	}
	
}
