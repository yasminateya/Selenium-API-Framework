package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONDataReader {

    public UserCredentials[] jsonReader() throws IOException, ParseException {

        String filePath = System.getProperty("user.dir") + "/src/test/java/data/UserData.json";
        FileReader file = new FileReader(filePath);
        JSONParser jsonParser = new JSONParser(); //object for parse all json file
        Object obj = jsonParser.parse(file);//parse the whole json object

        JSONObject inValidValuesObject = (JSONObject) obj;
        JSONArray inValidValuesArray = (JSONArray) inValidValuesObject.get("inValidValues"); // I need to access array

        UserCredentials[] userCredentials = new UserCredentials[inValidValuesArray.size()];

//        String[] arr = new String[inValidValuesArray.size()];

        //loop for each object in this array and get the value from each object
        for (int i = 0; i < inValidValuesArray.size(); i++)
        {
            JSONObject user = (JSONObject) inValidValuesArray.get(i);
            String mail = (String) user.get("mail");
            System.out.println(mail);

            String password = (String) user.get("password");
            System.out.println(password);

//            arr[i] = mail + ", " + password;
            userCredentials[i] = new UserCredentials(mail, password);
        }
        return userCredentials;
    }
}
