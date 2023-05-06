package com.epam.mjc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            boolean result = true;
            for (String e : x) {
                char str = e.charAt(0);
                if (!Character.isUpperCase(str)) {
                    result = false;
                }
            }
            return result;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int length = x.size();
            for (int i = 0; i < length; i++) {
                if (x.get(i) % 2 == 0) {
                    x.add(x.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            for (String e : values) {
                char e_char = e.charAt(0);
                char e_last_char = e.charAt(e.length() - 1);
                String[] e_split = e.split(" ");
                if (Character.isUpperCase(e_char) && e_last_char == '.' && e_split.length > 3) {
                    result.add(e);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new LinkedHashMap<>();
            for (String e : x) {
                map.put(e, e.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
            return list;
        };
    }
}
