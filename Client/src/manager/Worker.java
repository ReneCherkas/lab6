package manager;

import clientCommands.*;

import java.io.IOException;


public class Worker {
    public byte[] work(String command) throws IOException {
        Receiver receiver = new Receiver();
        receiver.regist();
        receiver.regist(new Exit(), new Info(), new Show(), new Add(), new RemoveById(), new Clear(), new RemoveHead(), new Help(),
                new Head(), new ExecuteScript(), new CountLessThanLocation(), new RemoveFirst());
        receiver.runCommand(command + " a");
        CommandToSer commandAndArg = new CommandToSer(CommandAndArg.getCommand(), CommandAndArg.getArg());
        if (CommandAndArg.getCommand().equals("")){return null;}
        return Serializator.serialization(commandAndArg);
    }
}
