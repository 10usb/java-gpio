package sunit.gpio.digital;

/**
 * An event handler for a digital pin change
 * @author 10usb
 */
public interface DigitalChange {
	/**
	 * Called by the observer when changed
	 * @param value The new value of the pin
	 */
	void onChange(boolean value);
}
