package maja.webtech;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class UserEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientId;
    private String clientSecret;

    public UserEntry() {
    }

    public UserEntry(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntry userEntry = (UserEntry) o;
        return Objects.equals(id, userEntry.id) && Objects.equals(clientId, userEntry.clientId) && Objects.equals(clientSecret, userEntry.clientSecret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, clientSecret);
    }

    @Override
    public String toString() {
        return "UserEntry{" +
                "id=" + id +
                ", clientId='" + clientId + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                '}';
    }
}
