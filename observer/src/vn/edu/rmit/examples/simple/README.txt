In Java it is probably not worth implementing the observer pattern as defined in the GoF.

Java already has an observer interface (java.util.Observer), and it is trivial to use this
with Swing to build an MVC application where the Model is the Subject and the View is the Observer

This code is provided as a reference rather than as a useful example of a real-world observer pattern implementation.