package maja.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}