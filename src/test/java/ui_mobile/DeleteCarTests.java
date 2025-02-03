package ui_mobile;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MyCarsScreen;
import screens.SearchScreen;
import screens.SplashScreen;

public class DeleteCarTests extends AppiumConfig {
    SearchScreen searchScreen;
    LoginScreen loginScreen;
    MyCarsScreen myCarsScreen;

    @BeforeMethod
    public void beforeLogin(){
        new SplashScreen(driver);
        searchScreen = new SearchScreen(driver);
        searchScreen.goToLoginScreen();
        loginScreen = new LoginScreen(driver);
        loginScreen.login(UserDTO.builder()
                .username("shendonlevka@gmail.com")
                .password("Lost4815!")
                .build());
        searchScreen.goToMyCarsScreen();

    }
    @Test
    public void deleteFirstCarPositiveTest(){
        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.deleteFirstCar();
    }
}
