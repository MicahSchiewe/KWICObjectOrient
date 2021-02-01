package ecs.baylor.edu.cs5352.kwic_oo.interfaces;

import ecs.baylor.edu.cs5352.kwic_oo.impl.Lines;

/**
 * Creates a Lines encompassing the circular shift of the provided Lines
 * 
 * @author Micah
 * @author Michael
 *
 */
public interface ICharacterShift {
	public Lines shiftInput(Lines lines);
}
