package Test;

import org.testng.annotations.Test;

import Framework.AirCond;
import Framework.EqualAirCond;
import Framework.InitialDriverConfiguration;
import Framework.MainPage;

public class TestRozetka extends InitialDriverConfiguration {

	@Test
	public void goToMainPage() {

		MainPage mp = new MainPage(getDriver());
		mp.getMainPage().pickTown().selectMenuAirCond();
	}

	@Test(dependsOnMethods = "goToMainPage")
	public void selectAirCond() {
		AirCond ar = new AirCond(getDriver());
		ar.selectFirstTwoAirCond().equalTwoAirCond();
	}

	@Test(dependsOnMethods = "selectAirCond")
	public void equalAirCond() {
		EqualAirCond eac = new EqualAirCond(getDriver());
		eac.clickOnButtonComp().printEqualAirCond();
	}

}