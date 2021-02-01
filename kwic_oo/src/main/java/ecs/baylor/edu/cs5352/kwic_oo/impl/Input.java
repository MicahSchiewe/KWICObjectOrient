package ecs.baylor.edu.cs5352.kwic_oo.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

import ecs.baylor.edu.cs5352.kwic_oo.interfaces.IInput;

/**
 * Reads Lines from standard in
 * 
 * @author Micah
 * @author Michael
 *
 */
public class Input implements IInput {
	public Lines readInput() {
		Lines lines = new Lines(new ArrayList<>());
		try (var br = new BufferedReader(new InputStreamReader(System.in))) {
			lines.setLines(br.lines().collect(Collectors.toList()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lines;
	}
}
