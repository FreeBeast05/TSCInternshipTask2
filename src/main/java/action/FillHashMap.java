package action;

import entities.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FillHashMap {
    public static Map<Long, List<String>> fillMap(List<Data> linkedList) {
        Map<Long, List<String>> hashMap = new HashMap<>();
        linkedList.forEach(s -> hashMap.putIfAbsent(s.getNumber(), new ArrayList<>()));
        linkedList.forEach(s -> hashMap.get(s.getNumber()).add(s.getValue()));
        return hashMap;
    }
}
