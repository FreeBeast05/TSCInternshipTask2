package action;

import correctnessinputpath.ValidParameter;
import entities.Data;
import entities.Paths;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ValidParameter validParameter = new ValidParameter();
        validParameter.validInputParameter(args);
        Paths paths = validParameter.getPaths();

        ArrayList<Data> arrayList1 = ReadInputFile.fillArrayList(paths.getFileInput1());
        ArrayList<Data> arrayList2 = ReadInputFile.fillArrayList(paths.getFileInput2());
        long startTime = System.currentTimeMillis();
        InnerJoinMethods.joinForArrayList(arrayList1, arrayList2, paths.getFileOutputForArray());
        long diffTime = System.currentTimeMillis() - startTime;
        System.out.println("Время работы с ArrayList: " + diffTime);

        LinkedList<Data> linkedList1 = new LinkedList<>(arrayList1);
        LinkedList<Data> linkedList2 = new LinkedList<>(arrayList2);
        Collections.sort(linkedList1);
        Collections.sort(linkedList2);
        long startTime2 = System.currentTimeMillis();
        InnerJoinMethods.joinForLinkedList(linkedList1, linkedList2, paths.getFileOutputForLinked());
        long diffTime2 = System.currentTimeMillis() - startTime2;
        System.out.println("Время работы с LinkedList: " + diffTime2);

        Map<Long, List<String>> hashMap1 = FillHashMap.fillMap(linkedList1);
        Map<Long, List<String>> hashMap2 = FillHashMap.fillMap(linkedList2);
        long startTime3 = System.currentTimeMillis();
        InnerJoinMethods.joinForHashMap(hashMap1, hashMap2, paths.getFileOutputForMap());
        long diffTime3 = System.currentTimeMillis() - startTime3;
        System.out.println("Время работы с HashMap: " + diffTime3);


    }
}
