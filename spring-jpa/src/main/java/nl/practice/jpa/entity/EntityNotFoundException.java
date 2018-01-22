package nl.practice.jpa.entity;

public class EntityNotFoundException extends RuntimeException {

	public EntityNotFoundException(String message){
		super(message);
	}

}
