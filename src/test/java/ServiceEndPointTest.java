import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.*;

import java.util.Properties;

public class ServiceEndPointTest {

    private static Properties props;

    // TODO: 8/12/2015 resource for tests, sample xml kernel-2.2 kernel-3
    // TODO: 8/12/2015 xml, json and text response

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        APIProperties localProperties = new APIProperties();
        props = localProperties.getProp();

        System.out.println("Getting and verifying configuration");
        System.out.println("Testing...");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Done!");
    }

    @Test
    public void getBaseUrl() {
        when().get(props.getProperty("base_url")).then().statusCode(200);
    }

    @Test
    public void getServiceUrl() {
        when().get(props.getProperty("service_url")).then().statusCode(200);
    }

    // TODO: 8/12/2015 status.json works but wrong contentType
    @Test
    public void getServiceStatus() {
        when().get(props.getProperty("service_url") + "status.xml/")
                .then()
                .contentType(ContentType.XML)
                .statusCode(200)
                .body("response.@type", equalTo("success"))
                .body("response.responsecode", equalTo("MT090"))
        ;

        /*when().get(props.getProperty("service_url") + "status.json/")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("response.@type", equalTo("success"))
                .body("response.responsecode", equalTo("MT090"))
        ;*/
    }

    // TODO: 8/12/2015 Update documentation service point .JSON does not work
    @Test
    public void getMetadataTest() {
        given().queryParam("doi", props.getProperty("test_doi1")).
                when().get(props.getProperty("service_url") + "xml.xml")
                .then().contentType(ContentType.XML).statusCode(200)
                .body("resource.identifier", equalTo(props.getProperty("test_doi1")))
        ;
    }

    // TODO: 8/12/2015 Update getMetadataFail for contentType.XML
    @Test
    public void getMetadataFail(){
        /*given().queryParam("doi", props.getProperty("test_doi1_fail")).
                when().get(props.getProperty("service_url") + "xml.xml")
                .then().contentType(ContentType.XML).statusCode(200)
                .body("response.@type", equalTo("failure"))
                .body("response.responsecode", equalTo("MT011"))
        ;*/
    }
    // TODO: 8/12/2015 MINT

    // TODO: 8/12/2015 UPDATE URL
    // TODO: 8/12/2015 UPDATE XML
    // TODO: 8/12/2015 UPDATE URL AND XML

    // TODO: 8/12/2015 DEACTIVATE
    @Test
    public void getDeactivate(){
        Response response =
                given().queryParam("doi", props.getProperty("test_doi2"))
                .when().get(props.getProperty("service_url") + "deactivate.json")
                .then().extract().response();
        System.out.println(response.getBody().asString());
    }
    // TODO: 8/12/2015 ACTIVATE



}
