package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
            return x -> {
                boolean result = false;
                int count = 0;
                for (String elements : x){
                    if (elements.charAt(0) >= 65 && elements.charAt(0) <= 90)
                        count++;
                }
                if (count == x.size()){
                    result = true;
                }
                return result;
            };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int size = x.size();

            for (int i = 0; i < size; i++){
                if (x.get(i)%2 == 0){
                    x.add(x.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for (String element : values){
                int countWords = element.split("\\s").length;
                if (element.charAt(0) >= 65
                        && element.charAt(0) <= 90
                        && element.charAt(element.length() - 1) == '.'
                        && countWords > 3){
                    list.add(element);
                }
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String,Integer> map = new HashMap<>();
            for (String element : x){
                map.put(element, element.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>(list1);
            result.addAll(list2);
            return result;
        };
    }
}
