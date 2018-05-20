package nl.practice.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Jedi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private JediRank rank;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "jedi")
    private JediDetails details;

    public Jedi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JediRank getRank() {
        return rank;
    }

    public boolean isNameMatches(String name) {
        return this.name.equals(name);
    }

    public void setRank(JediRank rank) {
        this.rank = rank;
    }

    public JediDetails getDetails() {
        return details;
    }

    public void setDetails(JediDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Jedi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
