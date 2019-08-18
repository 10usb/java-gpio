package sunit.gpio.digital;

import sunit.gpio.DigitalInput;

/**
 * This class observes a digital input pin and triggers a call when it has
 * changed
 * 
 * @author 10usb
 */
public class DigitalObserver implements Runnable, AutoCloseable {
	private DigitalInput input;
	private Object lock = new Object();
	private Thread thread;
	private boolean running;
	private DigitalChange handler;
	private boolean currentValue;
	
	/**
	 * Constructs an observer
	 * 
	 * @param input   The input pin to observe
	 * @param handler The handler to pass on the changed value
	 */
	public DigitalObserver(DigitalInput input, DigitalChange handler) {
		this.input = input;
		this.handler = handler;
	}
	
	/**
	 * To start the monitoring
	 */
	public void start() {
		synchronized (lock) {
			running = true;
			thread = new Thread(this, this.getClass().getName());
			thread.start();
		}
	}
	
	@Override
	public void run() {
		while (running) {
			boolean newValue = input.get();
			if (newValue != currentValue) {
				currentValue = newValue;
				handler.onChange(newValue);
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
			}
			
		}
		
		synchronized (lock) {
			thread.notify();
		}
	}
	
	/**
	 * To stop the monitoring
	 */
	@Override
	public void close() throws Exception {
		synchronized (lock) {
			running = false;
			thread.wait();
		}
	}
}
