package ecs.baylor.edu.cs5352.kwic_oo.impl;

import ecs.baylor.edu.cs5352.kwic_oo.interfaces.IAlphabetize;

/**
 * Alphabetize the Lines in-place
 * 
 * @author Micah
 * @author Michael
 *
 */
public class Alphabetizer implements IAlphabetize {
	@Override
	public void alphabetize(Lines lines) {
		lines.getLines().sort(String::compareTo);
	}
}
