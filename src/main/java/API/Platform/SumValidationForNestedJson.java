package API.Platform;

import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidationForNestedJson {

    @Test
    public void sumOfCourses (){

        JsonPath jsonPath = new JsonPath(Payload.coursesPriceBody());
        int noOfCourses = jsonPath.getInt("courses.size()");

        int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");

        int sum = 0;
        int multiplyCoursePrice;

        for (int i = 0; i < noOfCourses; i++){
            multiplyCoursePrice = Math.multiplyExact((jsonPath.getInt("courses["+i+"].price")),
                    (jsonPath.getInt("courses["+i+"].copies")));
            sum += multiplyCoursePrice;
        }
        Assert.assertEquals(sum, purchaseAmount);
    }
}
