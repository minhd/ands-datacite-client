import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            APIProperties properties = new APIProperties();
            System.out.println(properties.getProperty("base_url"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}