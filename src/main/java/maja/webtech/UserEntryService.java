package maja.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserEntryService {
    @Autowired
    UserEntryRepository repoTwo;

    public UserEntry save(UserEntry userEntry) {
        return repoTwo.save(userEntry);
    }

    public UserEntry get(Long id) {
        return repoTwo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<UserEntry> getAll() {
        Iterable<UserEntry> iterator = repoTwo.findAll();
        List<UserEntry> userEntries = new ArrayList<UserEntry>();
        for (UserEntry userEntry : iterator)  userEntries.add(userEntry);
        return userEntries;
    }
}
