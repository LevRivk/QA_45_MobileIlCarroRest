package ui_mobile;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.LoginScreen;
import screens.SearchScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {
    LoginScreen loginScreen;
    @BeforeMethod
    public void beforeLogin(){
        new SplashScreen(driver);
        new SearchScreen(driver).goToLoginScreen();

    }

    @Test
    public void loginPositiveTests(){
        loginScreen = new LoginScreen(driver);
        loginScreen.login(UserDTO.builder()
                        .username("shendonlevka@gmail.com")
                        .password("Lost4815!")
                .build());
        Assert.assertTrue(new SearchScreen(driver).validateMessageSuccess("Login success"));
    }
    @Test
    public void loginNegativeTests_emailWithSpaces(){
        loginScreen = new LoginScreen(driver);
        loginScreen.login(UserDTO.builder()
                .username(" shendonlevka@gmail.com ")
                .password("Lost4815!")
                .build());
        Assert.assertTrue(new SearchScreen(driver).validateMessageSuccess("Login success"));
    }
    @Test
    public void loginNegativeTests_EmailWOAt(){
        loginScreen = new LoginScreen(driver);
        loginScreen.login(UserDTO.builder()
                .username("shendonlevkagmail.com")
                .password("Lost4815!")
                .build());
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("Login or Password incorrect"));
    }
}
