package api_rest;

import config.CarController;
import dto.CarDTO;
import helper.BaseApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.RandomUtils.generatePhone;

public class ApiDeleteCarTests extends CarController implements BaseApi {
    @Test
    public void deleteCarPositiveTest(){
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
                .about("best of the best car volvo")
                .build();
        login();
        Response response = addUserCars(car,tokenDto.getAccessToken());
        if (response.getStatusCode() == 200){
           Response response1 =  deleteCar(car.getSerialNumber());
            System.out.println("=======================" + response1.getStatusCode());
           Assert.assertEquals(response1.getStatusCode(),200);
    }else
        Assert.fail("failed test");
    }
}
