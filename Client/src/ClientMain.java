import manager.*;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args)  {
        try(
                Socket socket = new Socket("127.0.0.1", 56789);
                OutputStream out = socket.getOutputStream();
                DataOutputStream writer = new DataOutputStream(out);

                InputStream in = socket.getInputStream();
                DataInputStream reader = new DataInputStream(in);
        ){
            Message.info("Подключились к серверу");
            Scanner sc = new Scanner(System.in);
            Worker worker = new Worker();


            while (true){
                CommandAndArg.setCommand("");
                CommandAndArg.setArg(null);
                try {
                    String command = sc.nextLine();



                byte[] request = worker.work(command);
                if (request != null) {
                    writer.writeInt(request.length);
                    writer.write(request);
                    writer.flush();

                    if (command.split(" ")[0].equals("exit")) {
                        writer.close();
                        reader.close();
                        System.exit(0);
                    }

                    int len = reader.readInt();
                    byte[] data = new byte[len];
                    if (len > 0) {
                        reader.readFully(data);
                    }

                    MessageToSer messageToSer = (MessageToSer) Serializator.deserialization(data);
                    Message.info(messageToSer.toString());
                }else {
                    Message.error("Ошибка");
                }}catch (NoSuchElementException e){
                    Message.error("Закрыт поток ввода");
                    System.exit(0);
                }
            }
        } catch (IOException | ClassNotFoundException e){
            Message.error(e.getMessage());
        }
    }
}
