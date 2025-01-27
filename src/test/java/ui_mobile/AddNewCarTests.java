package ui_mobile;

import config.AppiumConfig;
import dto.CarDTO;
import dto.UserDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.*;

import static helper.RandomUtils.*;

public class AddNewCarTests extends AppiumConfig {
    SearchScreen searchScreen;
    LoginScreen loginScreen;

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
    public void addNewCarPositiveTet(){
        CarDTO car = CarDTO.builder()
                .serialNumber("num-"+generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("Hi")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("best of the best")
                .build();
        new MyCarsScreen(driver).goToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(car);

    }
}
