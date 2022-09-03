package manager;

public class Message {
    private static String message;
    private static String name;

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        Message.message = message;
    }

    public static void setMessage(String s, String name) { Message.message = s; Message.name = name;}
}
