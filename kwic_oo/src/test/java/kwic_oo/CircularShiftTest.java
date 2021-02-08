package kwic_oo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ecs.baylor.edu.cs5352.kwic_oo.impl.CircularShift;
import ecs.baylor.edu.cs5352.kwic_oo.impl.Lines;

class CircularShiftTest {

	@ParameterizedTest
	@MethodSource("circularShiftProvider")
	void test(List<String> lines, List<String> results) {
		CircularShift cs = new CircularShift();
		Lines l = cs.shiftInput(new Lines(lines));
		l.getLines().sort(null);
		results.sort(null);
		assertEquals(l.getLines(), results);
	}

	public static Stream<Arguments> circularShiftProvider() {
		return Stream.of(Arguments.of(asList(""), asList("")), Arguments.of(asList(), asList()),
				Arguments.of(asList("Hello world!", "This is a test", "mahboi"),
						asList("Hello world!", "world! Hello", "This is a test", "is a test This", "a test This is",
								"test This is a", "mahboi")),
				Arguments.of(asList("a", "b", "c"), asList("a", "b", "c")));
	}

	private static List<String> asList(String... strings) {
		List<String> list = new ArrayList<>();
		for (String s : strings)
			list.add(s);
		return list;
	}
}
