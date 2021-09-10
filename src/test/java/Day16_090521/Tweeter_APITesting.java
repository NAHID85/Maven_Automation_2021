package Day16_090521;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Tweeter_APITesting {

    String consumerKey = "bX4wOwzdPuFAAoyHgVJbM4piL";
    String consumerSecret = "geferssxU6ltTKWrceCxflxyYOmxmdPXgWJbHejGqO6aecZ1Fb";
    String accessToken = "1433950168739729408-JXJxoFX9DbEu1lVOKfuXIce4rgifi8";
    String tokenSecret = "0ZOqWlXlMcHYV3SiPMMM98HxsFf23VrcmBDE5Ezwk49DU";
    String id = "";

    @BeforeClass
    public void setup(){
        RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
    }//end of set up

    @Test
    public void postAStatus(){
        Response response =
                given().
                        auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                       // queryParam("status", "My first post through api automation")
                        queryParam("My second post through api automation")
                        .when().post("update.json")
                        .then().extract().response();

        if(response.statusCode() == 200){
            System.out.println("Status code is 200 as expected");
        } else {
            System.out.println("Actual status code is " + response.statusCode());
        }

        //verify the id and the text after posting
        String resp = response.asString();
        JsonPath json = new JsonPath(resp);
        //id
         id = json.getString("id");
        //text
        String actualText = json.getString("text");
        System.out.println("My id is " + id + " and text is " + actualText);
    }//end of post a status method

    @Test(dependsOnMethods = "postAStatus")
    public void deleteRecentPost(){
        Response response =
                given()
                        .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                        queryParam("id",id)
                        .when().post("destroy.json")
                        .then().extract().response();
        if(response.statusCode() == 200){
            System.out.println("Successfully deleted");
        } else {
            System.out.println("Actual status code is " + response.statusCode());
        }
    }//end of delete recent post

}//end of java class
