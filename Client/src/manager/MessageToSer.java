package manager;

import java.io.Serializable;

public class MessageToSer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String message;

    public MessageToSer(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Сервер: " +
                "message='" + message + '\'' +
                '}';
    }
}
