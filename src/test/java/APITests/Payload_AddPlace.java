package APITests;

public class Payload_AddPlace {

    public static String addPlaceBody(){
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String updatePlaceBody(){
        return "{\n" +
                "  \"place_id\": \"b854ed04e3bc2cc6ea869d53bd709924\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"key\": \"qaclick123\"\n" +
                "\n" +
                "}\n";
    }
}
