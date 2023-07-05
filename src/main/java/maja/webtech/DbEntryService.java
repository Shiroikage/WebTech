package maja.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DbEntryService {

    @Autowired
    DbEntryRepository repo;

    public DbEntry save(DbEntry dbEntry) {
        return repo.save(dbEntry);
    }

    public DbEntry get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<DbEntry> getAll() {
        Iterable<DbEntry> iterator = repo.findAll();
        List<DbEntry> dbEntries = new ArrayList<DbEntry>();
        for (DbEntry dbEntry : iterator)  dbEntries.add(dbEntry);
        return dbEntries;
    }

    public DbEntry getEntryByTrackId(String trackId) {
        List<DbEntry> dbEntries = getAll();
        for (DbEntry dbEntry : dbEntries) {
            if(trackId.equals(dbEntry.getTrack_id())) {
                return dbEntry;
            }
        }
        return null;
    }

    public void delete(DbEntry dbEntry) {
        repo.delete(dbEntry);
    }
}