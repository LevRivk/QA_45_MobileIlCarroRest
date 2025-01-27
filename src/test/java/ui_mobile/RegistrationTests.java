package ui_mobile;

import config.AppiumConfig;
import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;

import java.util.Random;

import static java.sql.DriverManager.getDriver;
import static helper.RandomUtils.*;
public class RegistrationTests extends AppiumConfig {
RegistrationScreen registrationScreen;

private String userNameRegUser = "o3srt1y8st@mail.com";

    @BeforeMethod
    public void beforeTests(){
        new SplashScreen(driver);
        new SearchScreen(driver).goToRegistrationScreen();
    }

    @Test
    public void registrationPositiveTest(){
        UserDTO user = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(10))
                .username(generateEmail(10))
                .password("Qwerty123!")
                .build();
        System.out.println(("---> "+user.getUsername()));

   RegistrationScreen registrationScreen =  new RegistrationScreen(driver);
   registrationScreen.typeRegistrationForm(user);
  Assert.assertTrue( new SearchScreen(driver).validateMessageSuccess("Registration success!"));

    }

    @Test
    public void registrationNegativeTest_dublicateUser(){
        UserDTO user = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(10))
                .username(userNameRegUser)
                .password("Qwerty123!")
                .build();
        System.out.println(("---> "+ user.getUsername()));

        RegistrationScreen registrationScreen =  new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(user);
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("User already exists"));

    }
}

