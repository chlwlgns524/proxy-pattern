package cloudService;

public class CloudProxy implements CloudService {

    private AuthDb auth = new AuthDb();
    private CloudService db;

    private String id;
    private boolean isLoggedIn;


    public CloudProxy(CloudService db) {
        this.db = db;
    }

    public void login(String id, String password) {
        if (auth.isValidInfo(id, password)) {
            this.id = id;
            isLoggedIn = true;
            System.out.println("성공적으로 로그인 되었습니다.");
        }
        else
            System.out.println("로그인에 실패하였습니다.");
    }

    public void logout() {
        isLoggedIn = false;
        System.out.println(id + "의 서비스가 종료되었습니다.");
    }

    @Override
    public void upload(String id, File file) {
        if (isLoggedIn)
            db.upload(id, file);
        else
            throw new RuntimeException("먼저 로그인을 해주세요.");
    }

    @Override
    public File download(String id, String fileName) {
        if (isLoggedIn)
            return db.download(id, fileName);
        else
            throw new RuntimeException("먼저 로그인을 해주세요.");
    }

}
