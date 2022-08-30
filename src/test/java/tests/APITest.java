package tests;

import io.restassured.RestAssured;
import model.response.CategoryDetails;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;


/**
 * Test the response for 'https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false'
 */
public class APITest {

    CategoryDetails response;

    @BeforeClass
    public void recordResponse(){
        response = RestAssured
                .given()
                .with()
                .baseUri("https://api.tmsandbox.co.nz")
                .basePath("v1/Categories")
                .queryParams(Map.of("catalogue",false))
                .get("6327/Details.json")
                .body()
                .as(CategoryDetails.class);
    }

    @Test
    public void testName(){
        Assert.assertEquals(response.getName(), "Carbon credits", "Name should be 'Carbon credits'");
    }

    @Test
    public void testCanRelist(){
        Assert.assertTrue(response.getCanRelist(), "CanRelist should be true!");
    }

    @Test
    public void testGalleyPromotionDescription() {
        Assert.assertTrue(response.getPromotions().stream().filter(e -> e.getName().equals("Gallery"))
                .findFirst().get().getDescription().contains("Good position in category"),
                "Description of the Promotion with Name 'Gallery' should contain 'Good position in category'");
    }
}
