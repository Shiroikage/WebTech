package maja.webtech;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import maja.webtech.entities.Playlist;
import maja.webtech.entities.Track;
import maja.webtech.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserEntryService userService;
    private UserEntryController userController;

    @Autowired
    public ApiController(DbEntryService service) {
        this.dbService = service;
    }

    public Playlist getPlaylist(String playlistId) {
//        playlistId="1gjH7nGpnCDbLbynog7MUq"; //temp for testing
        try {
            URL url = new URL("https://api.spotify.com/v1/playlists/"+playlistId);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setRequestProperty("Authorization", "Bearer " + user.getToken().getToken());
            //stuff below prob. needs some rework
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    con.getInputStream()))) {
                String line;
                StringBuffer test = new StringBuffer();
                while ((line = br.readLine()) != null) {
                    test.append(line);
                    test.append("\n");
                }
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                JsonNode jsonNode = objectMapper.readTree(String.valueOf(test));
                String myPlaylistId = jsonNode.get("id").asText();
                String name = jsonNode.get("name").asText();
                String playlistHref = jsonNode.get("href").asText();
                JsonNode jsonTracks = jsonNode.get("tracks");
                JsonNode items = jsonTracks.get("items");
                List<Track> tracksList = new ArrayList<>();
                items.forEach(item -> {
                    tracksList.add(new Track(item.get("track").get("id").asText()));
                });

                Track[] tracksArray = tracksList.toArray(new Track[tracksList.size()]);
                Playlist playlist = new Playlist(myPlaylistId, name);
                playlist.setTracks(tracksArray);
                playlist.setPlaylistHref(playlistHref);
                return playlist;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void test() {

    }
}
