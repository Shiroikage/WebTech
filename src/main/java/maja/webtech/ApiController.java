package maja.webtech;


import maja.webtech.entities.Playlist;
import maja.webtech.entities.Track;
import maja.webtech.entities.User;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    private String account_id;
    private String account_key;
    private DbEntryService dbService;
    private User user = new User(System.getenv("CLIENT_ID"), System.getenv("CLIENT_SECRET"));

    public ApiController(DbEntryService service) {
        this.dbService = service;
    }

    public Playlist getPlaylist(String playlistId) {
        playlistId="1gjH7nGpnCDbLbynog7MUq"; //temp for testing
        try {
            URL url = new URL("https://api.spotify.com/v1/playlists/"+playlistId);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setRequestProperty("Authorization", "Bearer " + user.getToken());
            //stuff below prob. needs some rework
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    con.getInputStream())))
            {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                JSONParser parse = new JSONParser(line);
                JSONObject jobj = (JSONObject)parse.parse();
                String myPlaylistId = (String) jobj.get("id");
                String playlistHref = (String) jobj.get("href");
                String name = (String) jobj.get("name");
                JSONObject trackObject = (JSONObject) jobj.get("tracks");
                List<Track> tracks = new ArrayList<>();
//                trackObject.forEach(item -> {
//                    tracks.add()
//                });
//                Track[] tracks = (Track) trackObject.get();
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
