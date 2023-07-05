package maja.webtech;

import maja.webtech.entities.Playlist;
import maja.webtech.entities.Track;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApiControllerTest {

    @Autowired
    DbEntryService service;
    @Test
    @DisplayName("Checks for the first tracks id of playlist")
    void firstTest() {
        String playlistId = "1gjH7nGpnCDbLbynog7MUq";
        String firstTrackId = "43OMUa5jouGCZEz9k9vooo";
        ApiController controller = new ApiController(service);

        Playlist myPlaylist = controller.getPlaylist(playlistId);
        Track testFirstTrack = myPlaylist.getTracks()[0];
        String testTrackId = testFirstTrack.getId();

        assertEquals(firstTrackId, testTrackId);
    }

    @Test
    @DisplayName("remove track")
    void removeTrackTest() {
        String playlistId = "1gjH7nGpnCDbLbynog7MUq";
        String trackUri = "spotify:track:6pDFS313jjuoDKq4DeUvOH";
        String response = "abc";
        ApiController controller = new ApiController(service);


        assertEquals(response, controller.removeTrack(playlistId, trackUri));
    }

}