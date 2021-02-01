package ecs.baylor.edu.cs5352.kwic_oo.interfaces;

import ecs.baylor.edu.cs5352.kwic_oo.impl.Lines;

/**
 * Creates a Lines object based off of input from an unknown source
 * 
 * @author Micah
 * @author Michael
 *
 */
public interface IInput {
	public Lines readInput();
}
