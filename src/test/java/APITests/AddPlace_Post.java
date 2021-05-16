package APITests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddPlace_Post { // sec 5,
    //post : is used to send data to a server to create/update a resource.

    // given: for all input details
    // when: for submitting api + resource link + HTTP method
    // then : for assertions

    @Test(enabled = false)
    public void testResponseCode_Header() { //1. assert on status code & response header

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123")   // log all for all (request)input details
                .header("Content-Type", "application/json")
                .body(Payload.addPlaceBody())
                .when().post("/maps/api/place/add/json")
                .then().log().all()                               // log all response details
                .assertThat()
                .statusCode(200)
                .header("Content-Type", "application/json;charset=UTF-8");
    }

    //Add - update place and get this place to validate the new address is present
    // but before that we need to save the added place in a variable

    @Test
    public void testPlaceVariable() { //

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123")   // log all for all (request)input
                // details
                .header("Content-Type", "application/json")
                .body(Payload.addPlaceBody())
                .when().post("/maps/api/place/add/json")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().asString(); //save this extract all json body in variable and then get place_id

        JsonPath jsonResponse = new JsonPath(response);//jsonpath class takes string and convert it to json (for parsing json)
        String placeIdAfterPost = jsonResponse.getString("place_id");
        System.out.println("place_id after Post =" + placeIdAfterPost);
//    }

        //Add - update place and get this place to validate the new address is present

//    @Test
//    public void testUpdatePlace(){
//        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String Expected_newAddressAfterPut = "Mokttam2"; // add static value on body and validate that it will return
        // in get

        given().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"place_id\": \"" + placeIdAfterPost + "\",\n" +
                        "  \"address\": \"" + Expected_newAddressAfterPut + "\" ,\n" + //change address only
                        "  \"key\": \"qaclick123\"\n" +
                        "\n" +
                        "}\n")
                .when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200)
                .body("msg", equalTo("Address successfully updated")); // this is not enough to validate validate the new address is present

        //get this place to validate the new address is present
        // get method doesn't have header or body because it will retrieve resources with the query params in url
        String getPlaceResponse = given().queryParam("key", "qaclick123")
                .queryParam("place_id", placeIdAfterPost)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all()
                .extract().response().asString();
        JsonPath getPlaceJson = ReusableMethods.rowToJson(getPlaceResponse);

        String Actual_newAddressAfterPut = getPlaceJson.getString("address");
        System.out.println(Actual_newAddressAfterPut);
        Assert.assertEquals(Actual_newAddressAfterPut, Expected_newAddressAfterPut);
    }

}
