package nl.practice.jpa.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Council {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private Set<Jedi> members;

    public Set<Jedi> getMembers() {
        return members;
    }

    public void setMembers(Set<Jedi> members) {
        this.members = members;
    }

    public void addOne(Jedi jedi){
        if (members == null) {
            members = new HashSet<>();
        }
        members.add(jedi);
    }
}
