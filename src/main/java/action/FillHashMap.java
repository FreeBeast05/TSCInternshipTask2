package action;

import entities.Data;

import java.util.*;

public class FillHashMap {
    public static Map<Long, List<String>> fillMap(List<Data> linkedList) {
        Map<Long, List<String>> hashMap = new HashMap<>(1);
        for (Data data : linkedList) {
            if (!hashMap.containsKey(data.getNumber())) {
                hashMap.put(data.getNumber(), new ArrayList<>());
            }
            hashMap.get(data.getNumber()).add(data.getValue());
        }
        return hashMap;
    }
}
