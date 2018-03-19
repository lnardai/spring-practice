package nl.practice.jpa.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import nl.practice.jpa.entity.Jedi;
import nl.practice.jpa.entity.JediRank;

class JediOrderGeneratorTest {

	@TestFactory
	public Stream<DynamicTest> createMultipleJediNameValidationTest() {
		List<Jedi> generatedJedi = JediOrderGenerator.generate();
		return generatedJedi.stream()
				.map(n -> dynamicTest("test with: " + n.getName(),
										() -> assertTrue(JediOrderGenerator.isMemberOfJediOrder(n.getName()))));
	}

	@DisplayName("Grouped assert for an Object")
	@Test
	public void usingTagsAndDisplayNameSoThisIsIrrelevant() {
		Jedi example = new Jedi("Jar Jar");
		example.setRank(JediRank.GRAND_MASTER);
		assertAll("name and rank", ()-> assertEquals("Jar Jar", example.getName()),
											() ->	assertEquals(JediRank.GRAND_MASTER, example.getRank()));
	}

	@Test
	void testOnlyOnDeveloperWorkstation() {
		assumeTrue("DEV".equals(System.getenv("ENV")),
				() -> "Aborting test: not on developer workstation");
		// remainder of test
	}

	@Test
	void testInAllEnvironments() {
		String ref = "ENV";
		assumingThat(ref.equals("ENV"),
				() -> {
					// perform these assertions only on the CI server
					assertEquals(2, 2);
				});

		// perform these assertions in all environments
		assertEquals("a string", "a string");
	}

	@Test
	@Tag("#SMOKE")
	@DisplayName("╯°□°）╯")
	void testWithDisplayNameContainingSpecialCharacters() {
	}

	@Test
	@Tag("#SMOKE")
	@DisplayName("😱")
	void testWithDisplayNameContainingEmoji() {
	}

}