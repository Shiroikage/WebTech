package maja.webtech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DbEntryController {

    @Autowired
    DbEntryService service;

    Logger logger = LoggerFactory.getLogger(DbEntryController.class);

    @PostMapping("/entries")
    public DbEntry createThing(@RequestBody DbEntry dbEntry) {
        return service.save(dbEntry);
    }

    @GetMapping("/entries/{id}")
    public DbEntry getEntry(@PathVariable String id) {
        logger.info("GET request on route DbEntry with {}", id);
        Long dbEntryId = Long.parseLong(id);
        return service.get(dbEntryId);
    }

    @GetMapping("/entries")
    public List<DbEntry> getAllEntries() {
        return service.getAll();
    }

}
