package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

    //we get in string and convert it to json and parsing it
    public static JsonPath rowToJson (String getApiResponseString){
        JsonPath getApiResponseJson = new JsonPath(getApiResponseString);
        return getApiResponseJson;
    }
}
