import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class petStatus {

    String mainURL = "https://petstore.swagger.io/v2/pet/findByStatus?status=";

    @Test(priority = 0)
    public void availablePetsCheck() {
        given()
                .get(mainURL + statusType.available)
                .then()
                .statusCode(200)
                .log().all()
                .body("status[0]", equalTo("available"));

    }

    @Test(priority = 1, enabled = false)
    public void pendingPetsCheck() {
        given()
                .get(mainURL + statusType.pending)
                .then()
                .statusCode(200)
                .log().all()
                .body("status[0]", equalTo("pending"));

    }

    @Test(priority = 2, enabled = false)
    public void soldPetsCheck() {
        given()
                .get(mainURL + statusType.sold)
                .then()
                .statusCode(200)
                .log().all()
                .body("status[0]", equalTo("sold"));

    }
}
