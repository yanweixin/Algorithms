import java.util.UUID;

public class KeyGenerator {

    public String uniqueKey() {
        String uuid = UUID.randomUUID().toString();
        String replaceUuid = uuid.replaceAll("-", "");
//        String uuid16 = replaceUuid.substring(0, 16);
        String uuid16 = replaceUuid.substring(16);
        return uuid16;
    }
}
