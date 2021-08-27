package API.Platform;

import files.Payload;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {


/******* with sending data to payload as variables ***********/
//    @Test
//    public void addBook (){
//        RestAssured.baseURI = "http://216.10.245.166";
//        String getAddBookResponseString = given().header("Content-Type", "application/json")
//                .body(Payload.addBookBody("asdx", "133")) // change the value everytime
//        .when().post("/Library/Addbook.php")
//        .then().assertThat().statusCode(200)
//                .extract().asString();
//
//        JsonPath getAddBookResponseJson = ReusableMethods.rowToJson(getAddBookResponseString);
//        String id = getAddBookResponseJson.get("ID");
//        System.out.println(id);
//    }

    /******* with sending data to payload from data provider ***********/
    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        String getAddBookResponseString = given().header("Content-Type", "application/json")
                .body(Payload.addBookBody(isbn, aisle))
        .when().post("/Library/Addbook.php")
        .then().assertThat().statusCode(200)
                .extract().asString();

        JsonPath getAddBookResponseJson = ReusableMethods.rowToJson(getAddBookResponseString);
        String id = getAddBookResponseJson.get("ID");
        System.out.println(id);
    }

    @DataProvider(name = "BooksData")
    public Object[][] getData() {
        return new Object[][]{{"ojfwty", "1234"}, {"cwetee", "3456"}};
    }
}
