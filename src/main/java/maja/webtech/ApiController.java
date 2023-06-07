package maja.webtech;


import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class ApiController {
    private String account_id;
    private String account_key;
    private ApiToken access; //valid for 1 hour
    private DbEntryService dbService;

    public ApiController(DbEntryService service) {
        this.dbService = service;
    }

    public void createToken(){

    }

    public Playlist getPlaylist() {
        try {
            URL url = new URL("https://api.spotify.com/v1/playlists/1gjH7nGpnCDbLbynog7MUq");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setRequestProperty("Authorization", "Bearer " + access.getToken());

            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    con.getInputStream())))
            {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                JSONParser parse = new JSONParser(line);
                JSONObject jobj = (JSONObject)parse.parse();
                String playlistId = (String) jobj.get("id");
                String playlistHref = (String) jobj.get("href");
                String name = (String) jobj.get("name");
                JSONObject trackObject = (JSONObject) jobj.get("tracks");
                Track[] tracks;
                trackObject.forEach(item -> {

                });
                Track[] tracks = (Track) trackObject.get();
            }
        }
    }
}
