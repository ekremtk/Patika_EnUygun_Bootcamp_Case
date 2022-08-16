import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class petPostDelete {

    Response response;
    JSONObject jsonObject;
    Map<String, Object> map = new HashMap<String, Object>();

    Long postedPetId;

    @Test(priority = 0)
    public void postTheNewPet() {

        this.map.put("petId", 35);
        this.map.put("name", "PetForTest");
        this.map.put("status", "available");

        response = given()
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .body(jsonObject.toJSONString(map))
                .when()
                .post("https://petstore.swagger.io/v2/pet");

        response
                .then()
                .log()
                .all()
                .statusCode(200)
                .assertThat()
                .extract()
                .path("id");

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        this.postedPetId = response.path("id");
        System.out.println("Test Res1: " + this.postedPetId);
    }

    @Test(priority = 1)
    public void deleteThePostedPet(){
        System.out.println("singleDeleteTest Res1: " + this.postedPetId);

        response = given()
                .accept(ContentType.JSON)
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .delete("https://petstore.swagger.io/v2/pet/" + this.postedPetId);


        assertEquals(HttpStatus.SC_OK,response.getStatusCode());
        System.out.println(response.getStatusCode());
        System.out.println(HttpStatus.SC_NOT_FOUND);
    }


}
