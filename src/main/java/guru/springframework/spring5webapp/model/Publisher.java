package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pubName;


    public Publisher(String pubName) {
        this.pubName = pubName;
    }

    public Long getId() {
        return id;
    }

    public String getPubName() {
        return pubName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }


}
