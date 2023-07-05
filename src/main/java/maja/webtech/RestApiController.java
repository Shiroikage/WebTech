package maja.webtech;

import maja.webtech.entities.Playlist;
import maja.webtech.entities.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestApiController {

    @Autowired
    DbEntryService service;

    ApiController controller = new ApiController(service);

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/playlist/{playlistId}")
    public String[] getPlaylistTracks(@PathVariable String playlistId) {
        List<DbEntry> dbEntries = service.getAll();
        List<String> dbEntryIds = new ArrayList<>();
        for(DbEntry entry : dbEntries) {
            dbEntryIds.add(entry.getTrack_id());
        }
        Playlist playlist = controller.getPlaylist(playlistId);
        String[] trackIds = new String[playlist.getTracks().length];
        int counter = 0;
        for(Track track : playlist.getTracks()) {
            String currentId = track.getId();
            if(!dbEntryIds.contains(currentId)) {
                DbEntry dbEntry = track.createDbEntryFromTrack();
                service.save(dbEntry);
            }
            trackIds[counter] = currentId;
            counter++;
        }
        return trackIds;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/like")
    public DbEntry likeTrack(@RequestBody String trackId) {
        DbEntry dbEntry = service.getEntryByTrackId(trackId);
        dbEntry.addLike();
        return service.save(dbEntry);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/dislike")
    public DbEntry dislikeTrack(@RequestBody String trackId) {
        DbEntry dbEntry = service.getEntryByTrackId(trackId);
        dbEntry.addDislike();
        return service.save(dbEntry);
    }
}
