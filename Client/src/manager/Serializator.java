package manager;

import java.io.*;

public class Serializator implements Serializable {

    private static final long serialVersionUID = 1L;

    public static byte[] serialization(Object command) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(command);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static Object deserialization(byte[] array) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(array);
        ObjectInput in = new ObjectInputStream(bis);
        return  in.readObject();
    }
}
