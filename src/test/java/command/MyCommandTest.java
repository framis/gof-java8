package command;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyCommandTest {

    @Test
    public void ExecuteSimpleCommands() {
        List<Runnable> tasks = new ArrayList<>();
        tasks.add(() -> MyCommand.log("Hi"));
        tasks.add(() -> MyCommand.save("Cheers"));
        tasks.add(() -> MyCommand.send("Bye"));

        MyCommand.execute(tasks);
    }
}
