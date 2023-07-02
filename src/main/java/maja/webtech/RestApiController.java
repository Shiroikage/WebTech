package maja.webtech;

import maja.webtech.entities.Playlist;
import maja.webtech.entities.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    @Autowired
    DbEntryService service;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/playlist")
    public String[] getPlaylistTracks(@RequestBody String playlistId) {
        ApiController controller = new ApiController(service);
        Playlist playlist = controller.getPlaylist(playlistId);
        String[] trackIds = new String[playlist.getTracks().length];
        int counter = 0;
        for(Track track : playlist.getTracks()) {
            trackIds[counter] = track.getId();
            counter++;
        }
        return trackIds;
    }
}
