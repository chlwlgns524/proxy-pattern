package cloudService;

public interface CloudService {

    void upload(String id, File file);

    File download(String id, String fileName);

}
