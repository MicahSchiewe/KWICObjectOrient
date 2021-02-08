package kwic_oo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ecs.baylor.edu.cs5352.kwic_oo.impl.Input;
import ecs.baylor.edu.cs5352.kwic_oo.impl.Lines;

public class InputTest {
	private static final InputStream in = System.in;

	@AfterEach
	public void teardown() {
		System.setIn(in);
	}

	@ParameterizedTest
	@MethodSource("provider")
	void test(List<String> input) {
		// "Mock" standard in (no Mockito, I know... this seemed safer, since I don't
		// know which methods on the stream were being used to mock return values)
		StringBuilder bldr = new StringBuilder();
		for (int i = 0; i < input.size(); i++) {
			if (i > 0)
				bldr.append("\n");
			bldr.append(input.get(i));
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(bldr.toString().getBytes());
		System.setIn(bais);

		// Run test
		Input i = new Input();
		Lines l = i.readInput();
		assertEquals(l.getLines(), input);
	}

	public static Stream<Arguments> provider() {
		return Stream.of(Arguments.of(asList()), Arguments.of(asList("Hello world!", "This is a test", "mahboi")),
				Arguments.of(asList("a", "b", "c")));
	}

	private static List<String> asList(String... strings) {
		List<String> list = new ArrayList<>();
		for (String s : strings)
			list.add(s);
		return list;
	}
}
