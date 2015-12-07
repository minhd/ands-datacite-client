import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class RestTest {

    @Test
    public void getDemo() {
        when()
            .get("https://demo.ands.org.au/")
            .then()
            .statusCode(200);
        System.out.println("Hello from Demo");
    }

    @Test
    public void getDev() {
        when()
            .get("https://devl.ands.org.au/minh")
            .then()
            .statusCode(200);
    }

    @Test
    public void getProd() {
        when()
            .get("https://researchdata.ands.org.au/")
            .then()
            .statusCode(200);
    }
    @Test
    public void getTest() {
        when()
                .get("https://test.ands.org.au/")
                .then()
                .statusCode(200);
    }
}
