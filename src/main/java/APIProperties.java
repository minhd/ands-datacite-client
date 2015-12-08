import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class APIProperties {

    private Properties prop;

    public APIProperties() throws IOException {
        prop = new Properties();
        InputStream inputStream = APIProperties.class.getClassLoader().getResourceAsStream("config.properties");
        prop.load(inputStream);
    }

    public Properties getProp(){
        return prop;
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}
