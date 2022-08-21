import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class getAllGrocery {

    Response response;

    String mainURL = "https://grocerystore.io/store/allGrocery";

    @Test(priority = 0)
    public void checkAllGrocery() {
        response = given()
                .get(mainURL);

        response.then()
                .statusCode(200)
                .log()
                .all();

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }
}
