package APITests;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

    //we get in string and convert it to json and parsing it
    public static JsonPath rowToJson (String getPlaceResponse){
        JsonPath getPlaceJson = new JsonPath(getPlaceResponse);
        return getPlaceJson;
    }
}
