# Observer
The Observer pattern defines a one-to-many relationship in which dependents register to an `Observer` object, which notifies the dependents when there is a state change.  
  
An Observer pattern allows many different parts of a program to be updated by a single state change. An Observer pattern consists of two parts:

- **Observer:** 
    * **update()** : This function is called whenever the Subject's state changes. If data will be passed on `Subject.notify()`, then `Observer.update()` will need to have the same parameter types. In Java, the implementation of an Observer is called a `Listener`.
      
- **Subject**:
    * **Array\<Observer> observers**: An array of Observer objects currently registered to the Subject state changes.
    * **register(Observer obs):** Registers a new Observer to calls from the Subject.
    * **remove(Observer obs):** Removes the given Observer from the Subject, if it exists.
    * **notify():** Notifies the registered observers of a state change. Depending on the implementation, notify could take some data as parameters to pass along to the registered `Observer` objects.  
        
          
In the implementation I've written, there are two concrete Observer classes; `ConsoleObserver` takes the String from `notify(String data)` and prints it to the console, and `TextAreaListener` takes the data and passes it to a `JTextArea` object.


