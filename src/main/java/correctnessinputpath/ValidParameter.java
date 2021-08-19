package correctnessinputpath;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ValidParameter {
    public static String[] validInputParameter(String[] args) {
        String fileInput1 = null;
        String fileInput2 = null;
        String fileOutputForArray = null;
        String fileOutputForLinked = null;
        String fileOutputForMap = null;

        if (args.length == 5) {
            fileInput1 = args[0];
            fileInput2 = args[1];
            fileOutputForArray = args[2];
            fileOutputForLinked = args[3];
            fileOutputForMap = args[4];
            File file1 = new File(fileOutputForArray), file2 = new File(fileOutputForLinked), file3 = new File(fileOutputForMap);

            if (file1.exists() && file2.exists() && file3.exists()) {
                System.out.println("Файлы с таким именем уже существуют, хотите их перезаписать? y/n");
                Scanner in = new Scanner(System.in);
                String num = in.nextLine();
                if (num.equalsIgnoreCase("y")) {
                    boolean fd1 = file1.delete(), fd2 = file2.delete(), fd3 = file3.delete();
                } else {
                    System.out.println("Обновление данных не произведено");
                    System.exit(1);
            }
                try {
                    boolean fc1 = file1.createNewFile(), fc2 = file2.createNewFile(), fc3 = file3.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        } else {
            System.out.println("Пути входных и выходных файлов указаны не верно");
            System.exit(-1);
        }
        return new String[]{fileInput1, fileInput2, fileOutputForArray, fileOutputForLinked, fileOutputForMap};
    }
}

