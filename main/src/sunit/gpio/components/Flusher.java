package sunit.gpio.components;

import java.io.Flushable;

import sunit.gpio.DigitalOutput;
import sunit.gpio.DigitalOutputController;
import sunit.gpio.digital.DigitalFlusher;

public class Flusher implements DigitalOutputController {
	private DigitalOutput[] pins;
	private Flushable flushable;

	public Flusher(Flushable flushable, DigitalOutput[] pins) {
		this.pins = pins;
		this.flushable =flushable;
	}

	@Override
	public DigitalOutput getDigitalOutput(int index) {
		return new DigitalFlusher(pins[index], flushable);
	}
}
