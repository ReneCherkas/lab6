package Commands;

import manager.Message;

import java.io.*;
import java.util.*;

public class ExecuteScript implements Command{
    private ArrayList<String> scripts = new ArrayList<>();
    Set<String> scriptsInProcess = new HashSet<>();
    Scanner scanner;
    String[] arguments;


    @Override
    public String execute(Object arg) throws IOException {
        Receiver receiver = new Receiver();
        try {
            //if (arguments.length == 0) {
             //   throw new NullPointerException();
            //}

            String filePath = "Server\\src\\data\\" + (String) arg ;
            File file = new File(filePath);
            String absolutePath = file.getAbsolutePath();

            if (scriptsInProcess.contains(absolutePath)) {
                Message.setMessage("Данный скрипт уже выполняется. \n Выполнение этого скрипта в данный момент невозможно.");
                return null;
            }

            scriptsInProcess.add(absolutePath);
            Scanner scanner;
            try {
                scanner = new Scanner(file);

                //Message.setMessage("Попытка прочитать команды из файла " + file.getName());
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    //Message.setMessage("Команда " +line);
                    receiver.runCommand(line, arg);
                }
                scriptsInProcess.remove(absolutePath);
            }catch (NullPointerException | FileNotFoundException e){
                Message.setMessage("Введите путь к скрипту");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "Считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
