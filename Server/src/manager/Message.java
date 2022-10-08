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
}
