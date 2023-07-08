package maja.webtech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;


@SpringBootTest
public class DbEntryTest {

    @MockBean
    DbEntryRepository repo;

    @Autowired
    DbEntryService service;

    @Test
    @DisplayName("liking a song")
    void testAddLike() {
        DbEntry dbEntry = new DbEntry();
        int likes = dbEntry.getLikes();

        dbEntry.addLike();

        assertEquals(dbEntry.getLikes(), likes+1);
    }

    @Test
    @DisplayName("disliking a song")
    void testAddDislike() {
        DbEntry dbEntry = new DbEntry();
        int dislikes = dbEntry.getDislikes();

        dbEntry.addDislike();

        assertEquals(dbEntry.getDislikes(), dislikes+1);
    }

    @Test
    @DisplayName("Should find a DbEntry name by trackId")
    void testFindDbEntryByTrackId() {
        var entry1 = new DbEntry();
        entry1.setTrack_id("43OMUa5jouGCZEz9k9vooo");
        entry1.setName("Push Up - Original Mix");
        var entry2 = new DbEntry();
        entry2.setTrack_id("6eiEPJ16dOxe0hME3NWxfP");
        entry2.setName("Kronos - Original Mix");
        doReturn(List.of(entry1, entry2)).when(repo).findAll();

        String actualName = service.getEntryByTrackId("6eiEPJ16dOxe0hME3NWxfP").getName();
        assertEquals(entry2.getName(), actualName);
    }
}
