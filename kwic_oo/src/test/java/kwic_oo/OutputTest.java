package kwic_oo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ecs.baylor.edu.cs5352.kwic_oo.impl.Input;
import ecs.baylor.edu.cs5352.kwic_oo.impl.Lines;
import ecs.baylor.edu.cs5352.kwic_oo.impl.Output;

public class OutputTest {
	private static final PrintStream out = System.out;

	@AfterEach
	public void teardown() {
		System.setOut(out);
	}

	@ParameterizedTest
	@MethodSource("provider")
	void test(List<String> output) {
		StringBuilder bldr = new StringBuilder();
		for (String s : output)
			bldr.append(s).append(System.lineSeparator());
		byte[] oracle = bldr.toString().getBytes();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));

		// Run test
		Output o = new Output();
		o.output(new Lines(output));
		assertArrayEquals(baos.toByteArray(), oracle);
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
