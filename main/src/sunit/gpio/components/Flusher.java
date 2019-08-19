package sunit.gpio.components;

import java.io.Flushable;

import sunit.gpio.DigitalOutput;
import sunit.gpio.DigitalOutputController;
import sunit.gpio.digital.DigitalFlusher;

public class Flusher implements DigitalOutputController {
	private DigitalOutput pin;
	private Flushable flushable;

	public Flusher(DigitalOutput pin, Flushable flushable) {
		this.pin = pin;
		this.flushable =flushable;
	}

	@Override
	public DigitalOutput getDigitalOutput(int index) {
		return new DigitalFlusher(pin, flushable);
	}
}
