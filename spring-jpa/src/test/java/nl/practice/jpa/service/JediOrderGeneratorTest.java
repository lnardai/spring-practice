package nl.practice.jpa.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import nl.practice.jpa.entity.Jedi;

class JediOrderGeneratorTest {

	@TestFactory
	public Stream<DynamicTest> createMultipleJediNameValidationTest() {
		List<Jedi> generatedJedis = JediOrderGenerator.generate();
//		generatedJedis.add(new Jedi("Laci"));
		return generatedJedis.stream()
				.map(n -> dynamicTest("test with: " + n.getName(), () -> assertTrue(JediOrderGenerator.isMemberOfJediOrder(n.getName()))));
	}
}