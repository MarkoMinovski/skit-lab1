package com.skit;

import java.util.*;

public class AnagramFinder {
    public static boolean areAnagrams(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        } else if (s1.equals(s2)) {
            // In other words, they are equal before we applied our sorting technique - i.e. they are the same
            // string.
            return false;
        }

        char[] arr1 = s1.toLowerCase().toCharArray();
        char[] arr2 = s2.toLowerCase().toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static List<String> findAnagrams(List<String> list1, List<String> list2) throws NullPointerException {
        if (list1 == null || list2 == null) {
            throw new NullPointerException("One or both inputs is null!");
        }
        List<String> result = new ArrayList<>();
        List<String> combinedList = new ArrayList<>(list1);
        combinedList.addAll(list2);


        for (int i = 0; i < combinedList.size(); i++) {
            String word1 = combinedList.get(i);


            for (int j = i + 1; j < combinedList.size(); j++) {
                String word2 = combinedList.get(j);

                if (areAnagrams(word1, word2)) {
                    if (!result.contains(word1)) {
                        result.add(word1);
                    }

                    if (!result.contains(word2)) {
                        result.add(word2);
                    }

                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("listen", "listen", "hello", "enlist");
        List<String> list2 = Arrays.asList("silent", "world", "tinsel");

        System.out.println(findAnagrams(list1, list2));
    }
}