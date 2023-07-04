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
            String currentId = track.getId();
            try {
                service.get(Long.parseLong(currentId));
            } catch (Exception ignored) {
                DbEntry dbEntry = new DbEntry(currentId,track.getName());
                dbEntry.setAlbum(track.getAlbum());
                dbEntry.setArtists(track.getArtists());
                dbEntry.setSong_href(track.getTrackHref());
                dbEntry.setDuration_ms(track.getDuration());
                service.save(dbEntry);
            }
            trackIds[counter] = currentId;
            counter++;
        }
        return trackIds;
    }
}
