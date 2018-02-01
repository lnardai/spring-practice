package nl.practice.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nl.practice.jpa.entity.Jedi;

public class JediOrderGenerator {

	private static List<Jedi> order = new ArrayList<>();
	private static Random rand = new Random();

	static {
		order.add(new Jedi("Qui-Gon Jinn"));
		order.add(new Jedi("Obi-Wan Kenobi"));
		order.add(new Jedi("Anakin Skywalker"));
		order.add(new Jedi("Quinlan Vos"));
		order.add(new Jedi("Yoda"));
		order.add(new Jedi("Mace Windu"));
		order.add(new Jedi("Shaak Ti"));
	}

	public static List<Jedi> generate(){
		return IntStream.range(0,10).mapToObj(i -> order.get(generateRandom())).collect(Collectors.toList());
	}

	public static boolean isMemberOfJediOrder(String name){
		return order.stream().filter(jedi -> jedi.isNameMatches(name)).findAny().isPresent();
	}

	private static int generateRandom(){
		return ThreadLocalRandom.current().nextInt(0, order.size());
	}
}
