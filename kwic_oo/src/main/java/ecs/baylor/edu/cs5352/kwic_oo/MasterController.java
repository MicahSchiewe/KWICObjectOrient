package ecs.baylor.edu.cs5352.kwic_oo;

import ecs.baylor.edu.cs5352.kwic_oo.impl.Alphabetizer;
import ecs.baylor.edu.cs5352.kwic_oo.impl.CircularShift;
import ecs.baylor.edu.cs5352.kwic_oo.impl.Input;
import ecs.baylor.edu.cs5352.kwic_oo.impl.Lines;
import ecs.baylor.edu.cs5352.kwic_oo.impl.Output;
import ecs.baylor.edu.cs5352.kwic_oo.interfaces.IAlphabetize;
import ecs.baylor.edu.cs5352.kwic_oo.interfaces.ICharacterShift;
import ecs.baylor.edu.cs5352.kwic_oo.interfaces.IInput;
import ecs.baylor.edu.cs5352.kwic_oo.interfaces.IOutput;
import lombok.AllArgsConstructor;

/**
 * Runs the object-oriented KWIC algorithm.
 * 
 * @author Micah
 * @author Michael
 *
 */
@AllArgsConstructor
public class MasterController {
	private IInput in;
	private ICharacterShift cs;
	private IAlphabetize a;
	private IOutput out;

	public void kwic() {
		Lines lines = in.readInput();
		lines = cs.shiftInput(lines);
		a.alphabetize(lines);
		out.output(lines);
	}

	public static void main(String[] args) {
		new MasterController(new Input(), new CircularShift(), new Alphabetizer(), new Output()).kwic();
	}
}
