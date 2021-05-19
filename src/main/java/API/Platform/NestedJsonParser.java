package API.Platform;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class NestedJsonParser {
    public static void main(String[] args) {

        JsonPath jsonPath = new JsonPath(Payload.coursesPriceBody());
        //1. return no of courses
        int noOfCourses = jsonPath.getInt("courses.size()");
        System.out.println("noOfCourses= " + noOfCourses);

        // 2. print purchase amount
        int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println("purchaseAmount= " + purchaseAmount);

        //3. Print Title of the first course
        String titleOfFirstCourse = jsonPath.getString("courses[0].title");
        System.out.println("titleOfFirstCourse= " + titleOfFirstCourse);

        //4. Print All course titles and their respective Prices
        for (int i = 0; i < noOfCourses; i++) {
            System.out.println((jsonPath.get("courses[" + i + "].title")).toString());
            System.out.println((jsonPath.get("courses[" + i + "].price")).toString());
        }
    }
}
