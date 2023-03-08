package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s : x) {
                if (s.matches("[A-Z].*")) {
                    continue;
                }
                return false;
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> temp = new ArrayList<>();
            for (Integer i : x) {
                if (i % 2 == 0) {
                    temp.add(i);
                }
            }
            x.addAll(temp);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            values.removeIf(x -> (!x.matches("[A-Z].*")));
            values.removeIf(x -> (!x.endsWith(".")));
            values.removeIf(x -> (x.split(" ").length <= 3));
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> result = new HashMap<>();
            for (String s : x) {
                result.put(s,s.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x,y) ->{
            List<Integer> result = new ArrayList<>();
            result.addAll(x);
            result.addAll(y);
          return result;
        };
    }
}
