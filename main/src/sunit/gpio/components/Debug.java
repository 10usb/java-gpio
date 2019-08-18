package sunit.gpio.components;

import java.util.HashMap;

import sunit.gpio.DigitalOutput;
import sunit.gpio.DigitalOutputController;
import sunit.gpio.digital.PrintDigitalOutput;

public class Debug implements DigitalOutputController {
	private HashMap<Integer, String> labels;
	
	public Debug() {
		labels = new HashMap<>();
	}
	
	public void setLabel(int index, String label) {
		labels.put(index, label);
	}
	
	@Override
	public DigitalOutput getDigitalOutput(int index) {
		if (labels.containsKey(index)) {
			return new PrintDigitalOutput(labels.get(index));
		}
		
		return new PrintDigitalOutput(Integer.toString(index));
	}
}
