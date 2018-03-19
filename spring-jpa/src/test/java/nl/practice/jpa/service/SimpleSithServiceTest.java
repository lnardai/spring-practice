package nl.practice.jpa.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import nl.practice.jpa.entity.Sith;
import nl.practice.jpa.entity.SithRank;
import nl.practice.jpa.repositories.SithRepository;

class SimpleSithServiceTest {

	private SithRepository repositoryMock = mock(SithRepository.class);
	private SimpleSithService service = new SimpleSithService(repositoryMock);

	@ParameterizedTest
	@ValueSource(strings = { "Darth Malak", "Darth Vader" })
	void shouldContain(String name) {
		assertTrue(service.isNameContainsDarth(name));
	}

	@ParameterizedTest
	@ValueSource(longs = {1,2,3})
	void findAllJedi(long id) {
		when(repositoryMock.findOne(id)).thenReturn(new Sith("Darth Awesome"));
		assertEquals("Darth Awesome", service.getExactSith(id).getName());
	}

	@ParameterizedTest
	@ValueSource(strings = {"LORD", "ACOLYTE"})
	void testWithImplicitArgumentConversion(SithRank rank) {
		Sith exampleSith = new Sith("Darth Maul", rank);
		assertEquals(rank, exampleSith.getRank());
	}

	@ParameterizedTest
	@MethodSource("stringProvider")
	void testWithSimpleMethodSource(String argument) {
		assertNotNull(argument);
	}

	static Stream<String> stringProvider() {
		return Stream.of("foo", "bar");
	}
}