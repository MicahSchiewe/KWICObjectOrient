package ecs.baylor.edu.cs5352.kwic_oo.impl;

import ecs.baylor.edu.cs5352.kwic_oo.interfaces.IOutput;

/**
 * Outputs Lines to standard out
 * 
 * @author Micah
 * @author Michael
 */
public class Output implements IOutput {
	@Override
	public void output(Lines lines) {
		for (String s : lines.getLines()) {
			System.out.println(s);
		}
	}
}
