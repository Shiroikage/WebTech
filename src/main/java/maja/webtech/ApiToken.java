package maja.webtech;

import org.apache.tomcat.util.json.JSONParser;
import org.json.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

public class ApiToken {
    private String token;
    private LocalDateTime expDateTime;

    public ApiToken(String clientId, String clientSecret) {
        try {

            URL url = new URL("https://accounts.spotify.com/api/token");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            String postData = "grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret; //TODO: Check for automatic ID and SECRET from Spotify API
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
                this.token = (String) jobj.get("access_token");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.expDateTime = LocalDateTime.now().plusHours(1);
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getExpDateTime() {
        return expDateTime;
    }
}
