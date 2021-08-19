package action;

import correctnessinputpath.ValidParameter;
import entities.Data;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] paths = ValidParameter.validInputParameter(args);

        List<Data> arrayList1 = ReadInputFile.fillArrayList(paths[0]);
        List<Data> arrayList2 = ReadInputFile.fillArrayList(paths[1]);

        List<Data> linkedList1 = new LinkedList<>(arrayList1);
        List<Data> linkedList2 = new LinkedList<>(arrayList2);
        Collections.sort(linkedList1);
        Collections.sort(linkedList2);

        Map<Long, List<String>> hashMap1 = FillHashMap.fillMap(linkedList1);
        Map<Long, List<String>> hashMap2 = FillHashMap.fillMap(linkedList2);

        long startTime = System.currentTimeMillis();
        InnerJoinMethods.joinForArrayList(arrayList1, arrayList2, paths[2]);
        long diffTime = System.currentTimeMillis() - startTime;
        System.out.println("Время работа с ArrayList: "+ diffTime);

        long startTime2 = System.currentTimeMillis();
        InnerJoinMethods.joinForLinkedList(linkedList1, linkedList2,paths[3]);
        long diffTime2 = System.currentTimeMillis() - startTime2;
        System.out.println("Время работа с LinkedList: " + diffTime2);

        long startTime3 = System.currentTimeMillis();
        InnerJoinMethods.joinForHashMap(hashMap1, hashMap2, paths[4]);
        long diffTime3 = System.currentTimeMillis() - startTime3;
        System.out.println("Время работа с HashMap: " + diffTime3);








    }
}
