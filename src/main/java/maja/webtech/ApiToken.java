package maja.webtech;

import java.time.LocalDateTime;
import java.util.Date;

public class ApiToken {
    private String token;
    private LocalDateTime expDateTime;

    public ApiToken(String token) {
        this.token = token;
        this.expDateTime = LocalDateTime.now().plusHours(1);
    }
}
