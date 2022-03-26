package Tests;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.testng.annotations.BeforeSuite;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class UserDataJsonParser {

    UserInfoGetSet user = new UserInfoGetSet();

    @BeforeSuite
    public void jsonParser() {

        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("src/test/java/Tests/UserInformation.json"));
            JSONObject jo = (JSONObject) obj;
            JSONArray customerInfo = (JSONArray) jo.get("UserInfo");
            Object document = Configuration.defaultConfiguration().jsonProvider().parse(String.valueOf((customerInfo)));

            //email
            List <String> a = JsonPath.read(document, "$..email");
            String email = a.get(0);
            user.setEmail(email);

            //password
            List <String> b = JsonPath.read(document, "$..password");
            String password = b.get(0);
            user.setPassword(password);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}