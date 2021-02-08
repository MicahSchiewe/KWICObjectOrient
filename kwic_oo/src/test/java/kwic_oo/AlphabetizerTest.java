package kwic_oo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ecs.baylor.edu.cs5352.kwic_oo.impl.Alphabetizer;
import ecs.baylor.edu.cs5352.kwic_oo.impl.Lines;

class AlphabetizerTest {

	@ParameterizedTest
	@MethodSource("alphabetizerTestProvider")
	void test(List<String> lines, List<String> results) {
		Alphabetizer a = new Alphabetizer();
		Lines l = new Lines(lines);
		a.alphabetize(l);
		assertEquals(l.getLines(), results);
	}

	public static Stream<Arguments> alphabetizerTestProvider() {
		return Stream.of(Arguments.of(asList("b", "a", "c"), List.of("a", "b", "c")),
				Arguments.of(asList(), List.of()),
				Arguments.of(asList("ab", "aa"), List.of("aa", "ab")),
				Arguments.of(asList("a", "b", "c"), List.of("a", "b", "c")));
	}

	private static List<String> asList(String...strings) {
		List<String> list = new ArrayList<>();
		for (String s : strings)
			list.add(s);
		return list;
	}
}
