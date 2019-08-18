package sunit.gpio.components;

import sunit.gpio.DigitalController;
import sunit.gpio.DigitalInput;
import sunit.gpio.DigitalOutput;
import sunit.gpio.digital.DigitalInverter;

public class Inverter implements DigitalController {
	private DigitalController controller;

	public Inverter(DigitalController controller) {
		this.controller = controller;
	}
	@Override
	public DigitalOutput getDigitalOutput(int index) {
		return new DigitalInverter(controller.getDigitalOutput(index));
	}
	
	@Override
	public DigitalInput getDigitalInput(int index) {
		return new DigitalInverter(controller.getDigitalInput(index));
	}
}
