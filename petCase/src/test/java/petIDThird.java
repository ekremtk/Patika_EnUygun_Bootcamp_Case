import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class petIDThird {
    @Test
    public void thirdPetCheck() {
        ArrayList<Long> petID = given()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .extract()
                .path("id");

        System.out.println(petID);
        System.out.println("3rd Pet's ID: " + petID.get(2));

        Long petID3 = petID.get(2);
        System.out.println("3rd Pet's ID: " + petID3);


        given()
                .get("https://petstore.swagger.io/v2/pet/" + petID3)
                .then()
                .statusCode(200)
                .log().all()
                .body("status", equalTo("available"));
    }
}
