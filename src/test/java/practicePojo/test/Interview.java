package practicePojo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practicePojo.pojo.Data;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Interview {
    @BeforeClass
    public void setup(){
        baseURI = "https://reqres.in/api";
    }

    @Test
    public void test(){
        String urlExtension = "/single_user";
        String[] expectedNames = {"cerulean", "fuchsia rose", "true red", "aqua sky", "tigerlily", "blue turquoise"};

        List<Data> extractedDatas = given()
                .pathParam("urlExtension", urlExtension)
                .when()
                .get("{urlExtension}")
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("data", Data.class)
                ;

        System.out.println(extractedDatas);

        for (int i = 0; i < expectedNames.length; i++) {
            Assert.assertEquals(extractedDatas.get(i).getName(), expectedNames[i]);
        }


    }
}
