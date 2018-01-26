package nl.practice.jpa.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nl.practice.jpa.repositories.SithRepository;

class SimpleSithServiceTest {

	private SithRepository repositoryMock = mock(SithRepository.class);
	private SimpleSithService service = new SimpleSithService(repositoryMock);

	@ParameterizedTest
	@ValueSource(strings = { "Darth Malak", "Darth Vader" })
	void shouldContain(String name) {
		assertTrue(service.isNameContainsDarth(name));
	}
}