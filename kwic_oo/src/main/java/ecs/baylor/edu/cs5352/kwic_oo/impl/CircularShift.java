package ecs.baylor.edu.cs5352.kwic_oo.impl;

import java.util.ArrayList;
import java.util.List;

import ecs.baylor.edu.cs5352.kwic_oo.interfaces.ICharacterShift;

/**
 * Runs a circular shift on the provided Lines, generating a new set of Lines in
 * the process.
 * 
 * @author Micah
 * @author Michael
 *
 */
public class CircularShift implements ICharacterShift {
	@Override
	public Lines shiftInput(Lines lines) {
		var shiftedLines = lines.getLines().parallelStream().map(this::createLines).reduce((l, acc) -> {
			if (acc == null)
				return l;
			acc.addAll(l);
			return acc;
		});

		if (shiftedLines.isPresent()) {
			return new Lines(shiftedLines.get());
		} else {
			return new Lines(new ArrayList<>());
		}
	}

	private List<String> createLines(String line) {
		StringBuilder bldr = new StringBuilder();
		String[] permutations = line.split(" ");
		List<String> output = new ArrayList<>();
		final int length = permutations.length;

		for (int start = 0; start < length; start++) {
			for (int i = 0; i < length; i++) {
				if (i != 0)
					bldr.append(" ");
				bldr.append(permutations[(start + i) % length]);
			}
			output.add(bldr.toString());
			bldr.setLength(0);
		}

		return output;
	}
}
