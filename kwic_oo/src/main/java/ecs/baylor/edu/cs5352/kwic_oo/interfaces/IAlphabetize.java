package ecs.baylor.edu.cs5352.kwic_oo.interfaces;

import ecs.baylor.edu.cs5352.kwic_oo.impl.Lines;

/**
 * In-place alphabetizer for a set of Lines.
 * 
 * @author Micah
 * @author Michael
 */
public interface IAlphabetize {
	public void alphabetize(Lines shift);
}
