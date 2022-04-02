package cloudService;

import java.util.*;

public class CloudDb implements CloudService {

    private static final Map<String, List<File>> db = new HashMap<>();

    @Override
    public void upload(String id, File file) {
        List<File> list = db.getOrDefault(id, new ArrayList<File>());

        list.add(file);

        db.put(id, list);
    }

    @Override
    public File download(String id, String fileName) {
        List<File> list = db.get(id);

        Optional<File> foundFile = list.stream()
                .filter(f -> f.getFileName().equals(fileName))
                .findAny();

        if (foundFile.isPresent())
            return foundFile.get();
        else
            throw new RuntimeException("해당 파일이 존재하지 않습니다.");
    }

}
