package API.Platform;

import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

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

//        5. Print no of copies sold by RPA Course
//        System.out.println(jsonPath.get("courses[2].copies").toString()); //if json fixed

        for (int i = 0; i < noOfCourses; i++) {
            String courseTitle = jsonPath.get("courses[" + i + "].title");
            if (courseTitle.equalsIgnoreCase("RPA")){
                System.out.println((jsonPath.get("courses[" + i + "].copies")).toString());
                break;
            }

        }

        int sum = 0;
        int multiply;
        for (int i = 0; i < noOfCourses; i++){
            multiply = Math.multiplyExact((jsonPath.getInt("courses["+i+"].price")),
                    (jsonPath.getInt("courses["+i+"].copies")));
            sum += multiply;
        }
        Assert.assertEquals(sum, purchaseAmount);
    }
}
