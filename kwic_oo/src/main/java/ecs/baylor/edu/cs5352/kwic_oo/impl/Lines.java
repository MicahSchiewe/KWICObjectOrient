package ecs.baylor.edu.cs5352.kwic_oo.impl;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Primary data representation for the KWIC object-oriented solution
 * 
 * @author Micah
 * @author Michael
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lines {
	private List<String> lines;
}
