package maja.webtech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserEntryController {

    @Autowired
    UserEntryService serviceTwo;

    Logger logger = LoggerFactory.getLogger(UserEntryController.class);

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user")
    public UserEntry createThing(@RequestBody UserEntry userEntry) {
        return serviceTwo.save(userEntry);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user/{id}")
    public UserEntry getEntry(@PathVariable String id) {
        logger.info("GET request on route UserEntry with {}", id);
        Long userEntryId = Long.parseLong(id);
        return serviceTwo.get(userEntryId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/user")
    public List<UserEntry> getAllEntries() {
        return serviceTwo.getAll();
    }
}
