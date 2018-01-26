package nl.practice.jpa.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import nl.practice.jpa.entity.EntityNotFoundException;
import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.repositories.JediRepository;

class SimpleJediServiceTest {

	private JediRepository repositoryMock = mock(JediRepository.class);
	private SimpleJediService service;
	private Jedi exampleJedi = new Jedi("Qui-Gon Jinn");
	private long quiGonId = 1l;

	@BeforeEach
	public void configure(){
		exampleJedi.setId(quiGonId);
		service = new SimpleJediService(repositoryMock);
	}

	@Test
	@RepeatedTest(10)
	@DisplayName("get Jedi with Optional value successful")
	void getExactJedi() {
		when(repositoryMock.findById(quiGonId)).thenReturn(Optional.of(exampleJedi));
		Jedi jedi = service.getExactJedi(quiGonId);
		assertAll("multi assert",
				() -> assertEquals("Qui-Gon Jinn", jedi.getName()),
				() -> assertEquals(1, jedi.getId())
		);
	}

	@Test
	@DisplayName("get Jedi which is non existent")
	void getImaginaryJedi() {
		when(repositoryMock.findById(777l)).thenReturn(Optional.empty());
		EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
				() -> service.getExactJedi(777l).getName());
		assertEquals("JediId:777", exception.getMessage());
	}

}