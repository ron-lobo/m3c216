package com.m3.c216.intro;

import com.m3.c216.vehicle.Engine;

import java.util.*;

public class CollectionsIntro {

    private Engine e1 = new Engine("v8", 2400);
    private Engine e2 = new Engine("s6", 2000);
    private Engine e3 = new Engine("v12", 3000);


    public static void main(String[] args) {
        CollectionsIntro ci = new CollectionsIntro();
        ci.arrays();
        ci.lists();
        ci.sets();
        ci.maps();
    }

    public void maps() {
        System.out.println("\nMaps");

        Map<String, Engine> myMap = new HashMap<>();
        showMap(myMap);

        myMap.put("Dumbledore", e3);
        myMap.put("Snape", e1);
        myMap.put("Prof Lupin", e2);
        showMap(myMap);

        myMap.put("Minerva", e1);
        myMap.put("Prof Lupin", e1);
        showMap(myMap);

        myMap.remove("Snape", e3);
        myMap.remove("Minerva");
        showMap(myMap);
    }

    private void showMap(Map<String, Engine> map) {
        System.out.println("map size: " + map.size());
        for (String owner : map.keySet()) {
            Engine e = map.get(owner);
            System.out.printf("  owner=%s, engine=%s%n", owner, e);
        }
    }

    public void sets() {
        System.out.println("\nSets");

        Set<String> stringSet = new HashSet<>();
        stringSet.add("abc");
        stringSet.add("abc");
        stringSet.add("xyz");
        stringSet.add("ijk");
        stringSet.add("abc");
        stringSet.remove("ijk");
        stringSet.remove("abc");
        for (String s : stringSet) {
            System.out.println(s);
        }

        Set<Engine> engines = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            engines.add(e1);
            engines.add(e2);
            engines.add(e3);
        }
        System.out.println("num engines: " + engines.size());
        for (Engine e : engines) {
            System.out.println(e);
        }
    }

    public void lists() {
        System.out.println("\nLists");

//        LinkedList<String> strings = new LinkedList<String>();  // don't do this
        List<String> strings1 = new ArrayList<>();
        List<String> strings2 = new LinkedList<>();

        listHelper("ArrayList", strings1);
        listHelper("LinkedList", strings2);


        List<Integer> values = new ArrayList<>();
        values.add(123);
        values.add(999);
    }

    // LinkedList -> [<- "123", ->] [<- "x" ->] [<- "456", ->null]
    // ArrayList [ref1,ref2,ref3,...]16
    //           [                   ref17,                   ]32

    private void listHelper(String title, List<String> stringList) {
        System.out.println(title);
        System.out.println("size=" + stringList.size());
        stringList.add("123");
        stringList.add("456");
        stringList.add("789");
        stringList.add("123");
        stringList.add(2, "xyz");
        System.out.println("size=" + stringList.size());
        stringList.remove(stringList.size() - 2);
        stringList.remove("123");
        System.out.println("size=" + stringList.size());
        System.out.println("enhanced for loop");
        for (String str : stringList) {
            System.out.println("  " + str);
        }

        if (stringList instanceof ArrayList) ((ArrayList<String>) stringList).trimToSize();
    }

    public void arrays() {
        System.out.println("\nArrays");
        int[] numbers1 = new int[]{1, 2, 3, 99, 102};
        int numbers2[] = new int[4];

        String[] strings1 = new String[]{"c216", "c229"};

        System.out.println("length of numbers1: " + numbers1.length);
        System.out.println("length of strings1: " + strings1.length);

        System.out.println("for loop with counter");
        for (int i = 0; i < strings1.length; i++) {
            System.out.println("  string " + i + " = " + strings1[i]);
        }

//        strings1 = null;
//        strings1[100] = "C-216";
        strings1 = new String[5];

        System.out.println("'enhanced' for loop");
        for (String str : strings1) {
            System.out.println("  " + str);
        }
    }
}
