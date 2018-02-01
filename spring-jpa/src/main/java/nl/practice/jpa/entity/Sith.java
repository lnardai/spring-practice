package nl.practice.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sith {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String name;
	private SithRank rank;

	public Sith(){
	}

	public Sith(String name) {
		this.name = name;
	}

	public Sith(String name, SithRank rank) {
		this.name = name;
		this.rank = rank;
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

	public SithRank getRank() {
		return rank;
	}

	public void setRank(SithRank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Sith{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
