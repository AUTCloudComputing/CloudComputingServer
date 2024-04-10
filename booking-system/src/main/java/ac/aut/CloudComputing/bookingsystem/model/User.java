package ac.aut.CloudComputing.bookingsystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Objects;

@Document(collection = "users")
public class User implements Persistable<String> {

    @Id
    private String id;

    private String username;
    private String email;
    private String password;
    private String profileImageS3Key; // Reference to the user's profile image stored in S3

    // Constructors, getters, and setters

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }

    // Equals and hashCode methods for comparing objects based on ID

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

