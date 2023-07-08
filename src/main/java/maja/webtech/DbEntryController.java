package maja.webtech;

import com.fasterxml.jackson.core.JsonProcessingException;
import maja.webtech.entities.Playlist;
import maja.webtech.entities.Track;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DbEntryController {

    @Autowired
    DbEntryService service;

    ApiController controller = new ApiController();

    Logger logger = LoggerFactory.getLogger(DbEntryController.class);

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/entries")
    public DbEntry createThing(@RequestBody DbEntry dbEntry) {
        return service.save(dbEntry);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/entries/{id}")
    public DbEntry getEntry(@PathVariable String id) {
        logger.info("GET request on route DbEntry with {}", id);
        Long dbEntryId = Long.parseLong(id);
        return service.get(dbEntryId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/entries")
    public List<DbEntry> getAllEntries() {
        return service.getAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/entries/{id}")
    public void deleteTrack(@PathVariable Long id) {
        DbEntry dbEntry = service.get(id);
        service.delete(dbEntry);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/playlist/{playlistId}")
    public String[] getPlaylistTracks(@PathVariable String playlistId) throws JsonProcessingException {
        List<DbEntry> dbEntries = service.getAll();
        List<String> dbEntryIds = new ArrayList<>();
        for(DbEntry entry : dbEntries) {
            dbEntryIds.add(entry.getTrack_id());
        }
        String jsonString = controller.getPlaylist(playlistId);
        Playlist playlist = controller.createPlaylistFromJson(jsonString);
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
    @PutMapping("/entries/{trackId}/{voting}")
    public DbEntry voteTrack(@PathVariable String trackId,@PathVariable Integer voting) {
        DbEntry dbEntry = service.getEntryByTrackId(trackId);
        if(voting == 1) {
            dbEntry.addLike();
        } else if (voting == 2) {
            dbEntry.addDislike();
        }
        return service.save(dbEntry);
    }
}
