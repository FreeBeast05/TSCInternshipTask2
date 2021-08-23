package entities;

public class Paths {
    private String fileInput1;
    private String fileInput2;
    private String fileOutputForArray;
    private String fileOutputForLinked;
    private String fileOutputForMap;

    public Paths(String fileInput1, String fileInput2, String fileOutputForArray, String fileOutputForLinked, String fileOutputForMap) {
        this.fileInput1 = fileInput1;
        this.fileInput2 = fileInput2;
        this.fileOutputForArray = fileOutputForArray;
        this.fileOutputForLinked = fileOutputForLinked;
        this.fileOutputForMap = fileOutputForMap;
    }

    public String getFileInput1() {
        return fileInput1;
    }

    public void setFileInput1(String fileInput1) {
        this.fileInput1 = fileInput1;
    }

    public String getFileInput2() {
        return fileInput2;
    }

    public void setFileInput2(String fileInput2) {
        this.fileInput2 = fileInput2;
    }

    public String getFileOutputForArray() {
        return fileOutputForArray;
    }

    public void setFileOutputForArray(String fileOutputForArray) {
        this.fileOutputForArray = fileOutputForArray;
    }

    public String getFileOutputForLinked() {
        return fileOutputForLinked;
    }

    public void setFileOutputForLinked(String fileOutputForLinked) {
        this.fileOutputForLinked = fileOutputForLinked;
    }

    public String getFileOutputForMap() {
        return fileOutputForMap;
    }

    public void setFileOutputForMap(String fileOutputForMap) {
        this.fileOutputForMap = fileOutputForMap;
    }
}
