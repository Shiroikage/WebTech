package maja.webtech;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiController {
    private String account_id;
    private String account_key;
    private ApiToken access; //valid for 1 hour

    public void getPlaylist(){
        try {

            URL url = new URL("https://accounts.spotify.com/api/token");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            String postData = "grant_type=client_credentials&client_id=f89b7d2b67bd48dca089c0ba88b385e9&client_secret=627542429fe44eea8fc699422eb70139";
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            try (DataOutputStream dos = new DataOutputStream(con.getOutputStream())) {
                dos.writeBytes(postData);
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    con.getInputStream())))
            {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                JSONParser parse = new JSONParser(line);
                JSONObject jobj = (JSONObject)parse.parse();
                String token = (String) jobj.get("access_token");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
