import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getGroceryByName {

    String mainURL = "https://grocerystore.io/store/allGrocery";

    @Test
    public void checkGroceryByName() {
        ArrayList<String> groceryName = given()
                .get(mainURL)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .extract()
                .path("name");

        System.out.println(groceryName);
        System.out.println("3rd Pet's ID: " + groceryName.get(1));



        given()
                .get(mainURL + "/" + groceryName.get(1))
                .then()
                .statusCode(200)
                .log().all()
                .body("name", equalTo("apple"));
    }
}
