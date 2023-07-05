package maja.webtech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DbEntryTest {

    @Autowired
    DbEntryService service;

    @Test
    @DisplayName("liking a song")
    void addLikeTest() {
        DbEntry dbEntry = service.getEntryByTrackId("43OMUa5jouGCZEz9k9vooo");
        int likes = dbEntry.getLikes();

        dbEntry.addLike();

        assertEquals(dbEntry.getLikes(), likes+1);
    }

    @Test
    @DisplayName("disliking a song")
    void addDislikeTest() {
        DbEntry dbEntry = service.getEntryByTrackId("43OMUa5jouGCZEz9k9vooo");
        int dislikes = dbEntry.getDislikes();

        dbEntry.addDislike();

        assertEquals(dbEntry.getDislikes(), dislikes+1);
    }
}
