package action;

import entities.Data;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InnerJoinMethods {
    public static void joinForArrayList(List<Data> arrayList1, List<Data> arrayList2, String path) {
        int count = 0;
        for (Data data1 : arrayList1) {
            long number1 = data1.getNumber();
            for (Data data2 : arrayList2) {
                if (number1 == data2.getNumber()) {
                    count++;
                    WriteFile.write(count + ". " + number1 + " "
                            + data1.getValue() + " " + data2.getValue(), path);
                }
            }
        }
    }

    public static void joinForLinkedList(List<Data> linked1, List<Data> linked2, String path) {
        int count = 0;
        List<Data> linkedList1;
        List<Data> linkedList2;
        if (linked1.size() > linked2.size()) {
            linkedList1 = linked1;
            linkedList2 = linked2;
        } else {
            linkedList1 = linked2;
            linkedList2 = linked1;
        }
        int[] startIndex = findStartIndex(linkedList1, linkedList2);
        List<Data> list1 = linkedList1.subList(startIndex[0], linkedList1.size());
        List<Data> list2 = linkedList2.subList(startIndex[1], linkedList2.size());
        int step = 0;
        int countStr = 1;
        for (Data data : list1) {
            int j = count;
            long number1 = data.getNumber();
            for (; j < list2.size(); j++) {
                int res = Long.compare(list2.get(j).getNumber(), number1);
                if (res > 0) {
                    break;
                } else if (res < 0) {
                    count++;
                } else {
                    WriteFile.write(countStr + ". " + number1 + " " + data.getValue() + " " + list2.get(j).getValue(), path);
                    countStr++;
                    step++;
                    count++;
                }
            }
            count -= step;
            step = 0;
        }

    }

    public static void joinForHashMap(Map<Long, List<String>> hashMap1, Map<Long, List<String>> hashMap2, String path) {
        AtomicInteger countStr = new AtomicInteger(1);
        for (Long number : hashMap1.keySet()) {
            List<String> list1 = hashMap1.get(number);
            if ( hashMap2.containsKey(number)) {
                for (String str : list1) {
                    hashMap2.get(number).forEach(s -> WriteFile.write(countStr.getAndIncrement() + ". " + number + " " + str + " " + s, path));
                }
            }
        }
    }

    private static int[] findStartIndex(List<Data> linkedList1, List<Data> linkedList2) {
        int index2 = -1, index1 = -1;
        try {
            while (index2 < 0) {
                index1++;
                index2 = Collections.binarySearch(linkedList2, linkedList1.get(index1));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Совпадений не найдено");
            System.exit(1);
        }
        while (index2 > 0 && linkedList2.get(index2 - 1).equals(linkedList2.get(index2))) {
            if (index2 == 1 && linkedList2.get(0).equals(linkedList2.get(index2))) {
                index2--;
                break;
            }
            index2--;
        }
        return new int[]{index1, index2};

    }

}
