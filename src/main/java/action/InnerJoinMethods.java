package action;

import entities.Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class InnerJoinMethods {
    private static final String OUTSTR = "%d. %d  %s %s\n";

    public static void joinForArrayList(ArrayList<Data> arrayList1, ArrayList<Data> arrayList2, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            int countStr = 1;
            for (Data data1 : arrayList1) {
                for (Data data2 : arrayList2) {
                    if (data1.getNumber() == data2.getNumber()) {
                        writer.write(String.format(OUTSTR, countStr++, data1.getNumber(), data1.getValue(), data2.getValue()));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Возникла ошибка записи  в " + path);
        }
    }


    public static void joinForLinkedList(LinkedList<Data> linked1, LinkedList<Data> linked2, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            ListIterator<Data> listIterator1 = linked1.listIterator();
            ListIterator<Data> listIterator2 = linked2.listIterator();
            int count = 1, countStr = 1;
            while (listIterator1.hasNext()) {
                Data data1 = listIterator1.next();
                while (listIterator2.hasNext()) {
                    Data data2 = listIterator2.next();
                    if (data1.getNumber() < data2.getNumber()) {
                        walkBack(listIterator2, count);
                        count = 1;
                        break;
                    } else if (data1.getNumber() == data2.getNumber()) {
                        writer.write(String.format(OUTSTR, countStr++, data1.getNumber(), data1.getValue(), data2.getValue()));
                        count += 1;
                        if (!listIterator2.hasNext()) {
                            walkBack(listIterator2, count);
                            count = 1;
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Возникла ошибка записи  в " + path);
        }
    }

    private static void walkBack(ListIterator<Data> iterator, int count) {
        for (int i = 0; i < count; i++) {
            iterator.previous();
        }
    }


    public static void joinForHashMap(Map<Long, List<String>> hashMap1, Map<Long, List<String>> hashMap2, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            AtomicInteger countStr = new AtomicInteger(1);
            for (Long number : hashMap1.keySet()) {
                List<String> list1 = hashMap1.get(number);
                if (hashMap2.containsKey(number)) {
                    for (String str : list1) {
                        hashMap2.get(number).forEach(s -> {
                            try {
                                writer.write(countStr.getAndIncrement() + ". " + number + " " + str + " " + s + "\n");
                            } catch (IOException e) {
                                System.out.println("Возникла ошибка записи  в " + path);
                            }
                        });
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Возникла ошибка записи  в " + path);
        }
    }


}
