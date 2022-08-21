import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class addGroceryItem {

    Response response;
    JSONObject jsonObject;
    Map<String, Object> map = new HashMap<String, Object>();

    String addedItem;

    @Test(priority = 0)
    public void postTheNewPet() {

        String mainURL = "https://grocerystore.io/store/allGrocery";

        this.map.put("id", 4);
        this.map.put("name", "string");
        this.map.put("price", 12.3);
        this.map.put("stock", 3);

        response = given()
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .body(jsonObject.toJSONString(map))
                .when()
                .post(mainURL + "/");

        response
                .then()
                .log()
                .all()
                .statusCode(200)
                .assertThat()
                .extract()
                .path("name");

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        this.addedItem = response.path("name");
        System.out.println("Test Res1: " + this.addedItem);
    }

}
