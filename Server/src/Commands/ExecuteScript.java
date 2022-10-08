package Commands;

import Mess.Mess;
import manager.Message;

import java.io.*;
import java.util.*;

public class ExecuteScript implements Command{
    private ArrayList<String> scripts = new ArrayList<>();
    Set<String> scriptsInProcess = new HashSet<>();

    @Override
    public String execute(Object arg) throws IOException {
        Receiver receiver = new Receiver();
        try {

            String filePath = "Server\\src\\data\\" +arg ;
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

//                List com = null;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    receiver.runCommand(line, arg);
//                    com = new ArrayList();
//                    com.add(line);
//                    Mess.info(com);
                }

//               for (int i =  0; i<com.size();i++ ){
//                   receiver.runCommand(String.valueOf(com.get(i)), arg);
//               }
//                for (Object i : com) {
//                    receiver.runCommand(String.valueOf(i), arg);
//                }

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
    }}







//        try (Scanner s = new Scanner(file).useDelimiter("\\n")) {
////            while(s.hasNext()) {
////                String line = s.next();
////                mass = line.split("\\s");
////            }

//            System.out.println(Arrays.toString(mass));
//            for (String i : mass){
//                Receiver receiver = new Receiver();
//                receiver.runCommand(i, arg);}

        //FileInputStream fileIn = new FileInputStream(file);
        //InputStreamReader isr = new InputStreamReader(fileIn);
        //int charCode;
        //StringBuilder data = new StringBuilder();
        //while ((charCode = isr.read()) != -1) { // Read each character.
        //    data.append((char) charCode);
        ///}
        //isr.close();

        ///Receiver receiver = new Receiver();
        ///String str = file.toString();
        //String[] mass = str.split("\\s");
        //System.out.println(Arrays.toString(mass));
        //for (String i : mass){

            //System.out.println(i + " a");
        //    receiver.runCommand(i, arg);
        //}
