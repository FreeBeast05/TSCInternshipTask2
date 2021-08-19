package action;

import entities.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadInputFile {

    public static List<Data> fillArrayList(String path) {
        List<Data> arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] lineSplit = line.split(",");
                    if (lineSplit.length == 2) {
                        long number = Long.parseLong(lineSplit[0]);
                        String value = lineSplit[1];
                        arrayList.add(new Data(number, value));
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введен не числовой формат входного ключа");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Кодировка файла не известна");
        } catch (IOException e) {
            System.out.println("Возникла ошибка ввода");
        }
        return arrayList;

    }


}
