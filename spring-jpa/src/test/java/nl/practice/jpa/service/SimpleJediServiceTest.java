package nl.practice.jpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.repositories.JediRepository;

class SimpleJediServiceTest {

	private JediRepository repositoryMock = mock(JediRepository.class);
	private SimpleJediService service;
	private Jedi exampleJedi = new Jedi("Qui-Gon Jinn");

	@BeforeEach
	public void configure(){
		service = new SimpleJediService(repositoryMock);
	}

	@Test
	@DisplayName("get Jedi with Optional value successful")
	void getExactJedi() {

		when(repositoryMock.findById(anyLong())).thenReturn(Optional.of(exampleJedi));
		assertEquals("Qui-Gon Jinn", service.getExactJedi(11l).getName());

	}
}