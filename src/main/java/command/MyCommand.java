package command;

import java.util.List;

/**
 * Implementation of the Command Pattern with lamdbas
 * @See MyCommandTest for usage
 *
 * The Command design pattern encapsulates commands (method calls) in objects
 * allowing us to issue requests without knowing the requested operation or the
 * requesting object. Command design pattern provides the options to queue commands,
 * undo/redo actions and other manipulations.
 */

public class MyCommand {

    public static void log(String message) {
        System.out.println("Logging: " + message);
    }

    public static void save(String message) {
        System.out.println("Saving: " + message);
    }

    public static void send(String message) {
        System.out.println("Sending: " + message);
    }

    public static void execute(List<Runnable> tasks ) {
        tasks.forEach( Runnable::run );
    }

}
