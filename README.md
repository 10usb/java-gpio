# Java GPIO
This library was build as I needed access to GPIO pins. The only (real) supported access to it on the target device was through a modified version of WiringPi. Thus this adapter needed to be build. This also gave me the opportunity to design an abstract interface around the GPIO pins that is easy to use, and doesn't force you to do stuff you don't like (as most libraries do).

## Concepts
- There should be a generic interface (*Driver*) that is as low as posible to the (virtual) hardware. For when you don't want to use all the abstract mumbo jumbo.
- Interfaces for input or output that can be passed on to other complex code. For example an *LCD driver*, without that driver needing to know if those pins are real of virtual.
- Generalized hardware components with assistance of flow control pins. Allowing to create virtual pins that can be passed on for exampke to an *LCD driver*, that is not aware it actually controls a *shift register* for setting its pins.