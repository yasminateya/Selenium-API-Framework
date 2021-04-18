//package API.Platform;
//
//import io.restassured.http.ContentType;
//import io.restassured.http.Header;
//import io.restassured.http.Headers;
//import org.json.JSONObject;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class API_Base {
//
//    //Request initiation (APIPath-Header-body)
//    //(Header-Content type)
//    private static final ContentType jsonFormat = ContentType.JSON; //use getter method only no need to set itfromoutside
//
//    public ContentType getJsonFormat() { return jsonFormat;}
//
//    //(Header)
//    private final List<Header> list = new LinkedList<>();
//    private Headers mainHeader;
//    public Headers getHeader() { return mainHeader; }
//    public void setMainHeader(Headers mainHeader) {this.mainHeader = mainHeader;}
//    public void setHeader() {
//        if (mainHeader != null)
//            this.list.clear();//Connection
//
//        this.list.add(APIConfig.header_Authorization);
//        this.list.add(APIConfig.header_Device);
//        this.list.add(APIConfig.header_Ver);
//        this.list.add(APIConfig.header_HMAC);
//        this.list.add(APIConfig.header_Content_Type);
//        setMainHeader(new Headers(list));  // update it with the new headers
//    }
//
//
//    //(Body)
//    JSONObject body = new JSONObject(); // use getter and setter
//
//    public String getBody(){ return body.toString();}
//    public void setBody(JSONObject body) { this.body = body; }
//
//    //(Path)
//    private String APIPath = "";  //use the getter and setter methods to get and set the values for this private var
//
//    public String getAPIPath() { return APIPath; }
//    public void setAPIPath (String APIPath) { this.APIPath = APIPath; }
//
//
//}
