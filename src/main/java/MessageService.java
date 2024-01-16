import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Value("${out}")
    private String message;

    public MessageService(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}