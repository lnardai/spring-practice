package nl.practice.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jedi {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String name;
	private JediRank rank;

	public Jedi(){
	}

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

	public boolean isNameMatches(String name){
		return this.name.equals(name);
	}

	public void setRank(JediRank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Jedi{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
