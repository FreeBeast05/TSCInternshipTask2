package correctnessinputpath;


import entities.Paths;

import java.io.File;
import java.io.IOException;

public class ValidParameter {
    private Paths paths;
    public void validInputParameter(String[] args) {
        if (args.length == 5) {
            paths = new Paths(args[0], args[1], args[2], args[3], args[4]);
            File file1 = new File(paths.getFileOutputForArray()),
                    file2 = new File(paths.getFileOutputForLinked()),
                    file3 = new File(paths.getFileOutputForMap());

            if (file1.exists() && file2.exists() && file3.exists()) {
                boolean fd1 = file1.delete(), fd2 = file2.delete(), fd3 = file3.delete();
                try {
                    boolean fc1 = file1.createNewFile(), fc2 = file2.createNewFile(), fc3 = file3.createNewFile();
                } catch (IOException e) {
                    System.out.println("Возникла ошибка ввода/вывода");
                }
            }
        } else {
            System.out.println("Пути входных и выходных файлов указаны неверно");
        }
    }

    public Paths getPaths() {
        return paths;
    }
}


