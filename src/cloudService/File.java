package cloudService;

import java.time.LocalDate;

public class File {

    private static Integer sequence = 1;

    private int id;
    private String fileName;
    private LocalDate created;

    public File(String fileName) {
        this.fileName = fileName;
        id = sequence++;
        created = LocalDate.now();
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof File))
            return false;

        return id == ((File) obj).id && fileName.equals(((File) obj).fileName);
    }

    public static Integer getSequence() {
        return sequence;
    }

    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public LocalDate getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", created=" + created +
                '}';
    }

}
