import sun.misc.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;

public class APIProperties {

    private Properties prop;

    public APIProperties() throws IOException {
        prop = new Properties();
        InputStream inputStream = APIProperties.class.getClassLoader().getResourceAsStream("config.properties");
        prop.load(inputStream);
    }

    public static String getFileContent(String fileName) {
        String content = new Scanner(APIProperties.class.getResourceAsStream(fileName), "UTF-8").useDelimiter("\\A").next();
        return content;
    }

    public Properties getProp(){
        return prop;
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}
