package maja.webtech;

import maja.webtech.entities.Playlist;
import maja.webtech.entities.Track;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApiControllerTest {


    ApiController controller = new ApiController();

    @Test
    @DisplayName("Creates a Playlist from Json and checks for the first tracks id of playlist")
    void firstTest() throws Exception {
        String jsonResponse = "{\n" +
                "  \"id\": \"1gjH7nGpnCDbLbynog7MUq\",\n" +
                "  \"name\": \"WebTech\",\n" +
                "  \"href\": \"https://api.spotify.com/v1/playlists/1gjH7nGpnCDbLbynog7MUq\",\n" +
                "  \"owner\": {\n" +
                "    \"display_name\": \"Janik Finkler\",\n" +
                "    \"id\": \"cyberfink1\"\n" +
                "  },\n" +
                "  \"tracks\": {\n" +
                "    \"items\": [\n" +
                "      {\n" +
                "        \"track\": {\n" +
                "          \"id\": \"43OMUa5jouGCZEz9k9vooo\",\n" +
                "          \"name\": \"Push Up - Original Mix\",\n" +
                "          \"uri\": \"spotify:track:43OMUa5jouGCZEz9k9vooo\",\n" +
                "          \"href\": \"https://api.spotify.com/v1/tracks/43OMUa5jouGCZEz9k9vooo\",\n" +
                "          \"duration_ms\": 240059,\n" +
                "          \"artists\": [\n" +
                "              {\n" +
                "                \"name\": \"Creeds\",\n" +
                "                \"uri\": \"spotify:artist:2gW0M5fn2r7Lo4Hn1r8HZ5\"\n" +
                "              }\n" +
                "          ],\n" +
                "          \"album\": {\n" +
                "            \"name\": \"Push Up (Original Mix)\",\n" +
                "            \"images\": [\n" +
                "               {\n" +
                "                   \"url\": \"https://i.scdn.co/image/ab67616d0000b27348dc64582941bd0b4c87f81f\"\n" +
                "               }\n" +
                "            ]\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"added_at\": \"2023-06-28T14:50:21Z\",\n" +
                "        \"track\": {\n" +
                "          \"id\": \"6eiEPJ16dOxe0hME3NWxfP\",\n" +
                "          \"name\": \"Kronos - Original Mix\",\n" +
                "          \"uri\": \"spotify:track:6eiEPJ16dOxe0hME3NWxfP\",\n" +
                "          \"href\": \"https://api.spotify.com/v1/tracks/6eiEPJ16dOxe0hME3NWxfP\",\n" +
                "          \"duration_ms\": 287291,\n" +
                "          \"artists\": [\n" +
                "              {\n" +
                "                \"name\": \"HI-LO\",\n" +
                "                \"uri\": \"spotify:artist:0ETJQforv5OXgDgidQv9qd\"\n" +
                "              }\n" +
                "          ],\n" +
                "          \"album\": {\n" +
                "            \"name\": \"Kronos\",\n" +
                "            \"images\": [\n" +
                "               {\n" +
                "                   \"url\": \"https://i.scdn.co/image/ab67616d0000b273ea25ad8e5a1c1adf6329320d\"\n" +
                "               }\n" +
                "            ]\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "       \"added_at\": \"2023-06-28T14:52:14Z\",\n" +
                "       \"track\": {\n" +
                "           \"id\": \"6pDFS313jjuoDKq4DeUvOH\",\n" +
                "           \"name\": \"Orderly Chaos - Original Mix\",\n" +
                "           \"uri\": \"spotify:track:6pDFS313jjuoDKq4DeUvOH\",\n" +
                "           \"href\": \"https://api.spotify.com/v1/tracks/6pDFS313jjuoDKq4DeUvOH\",\n" +
                "           \"duration_ms\": 377306,\n" +
                "           \"artists\": [\n" +
                "               {\n" +
                "               \"name\": \"Alignment\",\n" +
                "               \"uri\": \"spotify:artist:4eFbq5PZgW7YbtA65PP4wS\"\n" +
                "               }\n" +
                "           ],\n" +
                "           \"album\": {\n" +
                "             \"name\": \"Orderly Chaos\",\n" +
                "             \"images\": [\n" +
                "               {\n" +
                "                   \"url\": \"https://i.scdn.co/image/ab67616d0000b2735c7cb2a85dd6c93cc21271a9\"\n" +
                "               }\n" +
                "             ]\n" +
                "           }\n" +
                "          }\n" +
                "        }\n" +
                "    ]\n" +
                "  }\n" +
                "}\n";

        Playlist myPlaylist = controller.createPlaylistFromJson(jsonResponse);
        Track testTrack = myPlaylist.getTracks()[0];
        String testTrackId = testTrack.getId();

        String expectedTrackId = "43OMUa5jouGCZEz9k9vooo";
        assertEquals(expectedTrackId, testTrackId);
    }

//    @Test
//    @DisplayName("remove track")
//    void removeTrackTest() {
//        String trackUri = "spotify:track:6pDFS313jjuoDKq4DeUvOH";
//        String response = "abc";
//        ApiController controller = new ApiController();
//
//
//        assertEquals(response, controller.removeTrack(playlistId, trackUri));
//    }

}