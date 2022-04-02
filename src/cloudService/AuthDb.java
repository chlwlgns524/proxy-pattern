package cloudService;

import java.util.HashMap;
import java.util.Map;

public final class AuthDb {

    private static Map<String, String> info = new HashMap<>();

    public AuthDb() {
        registerInfo("test1", "test1");
        registerInfo("test2", "test2");
    }

    public void registerInfo(String id, String pwd) {
        info.put(id, pwd);
    }

    public boolean isValidInfo(String id, String pwd) {
        return pwd.equals(info.get(id));
    }

}
