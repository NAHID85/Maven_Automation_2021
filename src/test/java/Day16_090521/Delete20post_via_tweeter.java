package Day16_090521;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Delete20post_via_tweeter {

    String consumerKey = "bX4wOwzdPuFAAoyHgVJbM4piL";
    String consumerSecret = "geferssxU6ltTKWrceCxflxyYOmxmdPXgWJbHejGqO6aecZ1Fb";
    String accessToken = "1433950168739729408-JXJxoFX9DbEu1lVOKfuXIce4rgifi8";
    String tokenSecret = "0ZOqWlXlMcHYV3SiPMMM98HxsFf23VrcmBDE5Ezwk49DU";
    //String id = "";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.twitter.com/1.1/statuses/";
    }//end of set up

    //create 20 twitter post through rest api
    @Test
    public void deleteRecentTwentyTweets() throws InterruptedException {

        for (int i = 1; i <= 20; i++) {
            Response response =
                    given()
                            .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret)
                            //get the time line
                            .when().get("user_timeline.json")
                            .then().extract().response();


            if (response.statusCode() == 200) {
                System.out.println("Status code is 200 as expected");
            } else {
                System.out.println("Actual status code is " + response.statusCode());
            }

            //verify the id and the text after posting
            String resp = response.asString();
            JsonPath json = new JsonPath(resp);
            //id
            String id = json.getString("id[0]");
            //System.out.println("MY id is " + id);

            Response response2 =
                    given()
                            .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                            queryParam("id", id)
                            .when().post("destroy.json")
                            .then().extract().response();
            if (response2.statusCode() == 200) {
                System.out.println("Successfully deleted id " + id);
            } else {
                System.out.println("Actual status code is " + response2.statusCode());
            }
        }//end of for loop
    }//end of test method
}//end of java class
