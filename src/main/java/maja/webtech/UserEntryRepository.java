package maja.webtech;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntryRepository extends CrudRepository<UserEntry, Long> {
}
