package com.m3.c216.intro;

import com.m3.c216.vehicle.Car;
import com.m3.c216.vehicle.Engine;
import org.apache.commons.collections4.list.TreeList;

import java.util.*;

public class CollectionsIntro {

    private Engine e1 = new Engine("S", 8, 2400);
    private Engine e2 = new Engine("s", 6, 2000);
    private Engine e3 = new Engine("v", 12, 3000);
    private Engine e4 = new Engine("s", 6, 2200);
    private Engine e5 = new Engine("s", 4, 1600);
    private Engine e6 = new Engine("s", 6, 1600);

    private final List<String> CONSTLIST = List.of("123", "xyz");
    private Map<Engine, Car> engine2CarMap = new HashMap<>();


    public static void main(String[] args) {
        CollectionsIntro ci = new CollectionsIntro();
        ci.arrays();
        ci.lists();
        ci.sets();
        ci.maps();
        ci.maps2();
        // queue
        ci.collections();
        ci.hashMapAndHashCode();
    }

    private void hashMapAndHashCode() {
        System.out.println("\nhashMapAndHashCode");
        populateE2CMap();

        // construct engine from DB/user input
        Engine myEngine = new Engine("V", 12, 4200);

        Car c1 = engine2CarMap.get(myEngine);
        System.out.println("car for myEngine = " + c1);
    }

    private void populateE2CMap() {
        Engine e4200 = new Engine("V", 12, 4200);
        Car car1 = new Car("Ford", "Escort", "blue", 2, e4200);
        Car car2 = new Car("VW", "Golf", "black", 4, e2);
        engine2CarMap.put(e4200, car1);
        engine2CarMap.put(e2, car2);
    }

    public void collections() {
        System.out.println("\nCollections class");

//        List<Integer> values = List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3);

        List<Integer> values = new ArrayList<>();
        values.addAll(List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3));
        System.out.println(values);
        Collections.sort(values);
        System.out.println(values);

        List<Engine> engines = new ArrayList<>(List.of(e1, e2, e3, e4));
        engines.add(e5);
        engines.add(e6);

        System.out.println("engines: " + engines);
        Collections.sort(engines);
        System.out.println("engines sorted order:" + engines);
        Collections.reverse(engines);
        System.out.println("engines reverse order: " + engines);
        Collections.shuffle(engines);
        System.out.println("engines random order: " + engines);

        MyEngineComparator myEC = new MyEngineComparator();
        // Collections.sort(engines, myEC);
        engines.sort(myEC);
        System.out.println("engines myEC order: " + engines);
    }

    public void maps() {
        System.out.println("\nMaps");

        Map<String, Set<Engine>> user2EnginesMap = new HashMap<>();
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

    private void maps2() {
        System.out.println("\nMaps2");
        Map<Integer, Double> myMap = new HashMap<>();
        Random r = new Random();
        int numItems = 1_000_000, numRetrieve = 10;

        long s0 = System.nanoTime();
        for (int i = 0; i < numItems; i++) {
            myMap.put(i, r.nextDouble());
        }
        long s1 = System.nanoTime();
        showTime("map populated", s0, s1, numItems);

        s0 = System.nanoTime();
        for (int i = 0; i < numRetrieve; i++) {
            int key = r.nextInt(numItems - 1);
            myMap.get(key);
            //System.out.printf(" key=%d value=%f%n", key, myMap.get(key));
        }
        s1 = System.nanoTime();
        showTime("map retrieval", s0, s1, numRetrieve);
    }

    public static void showTime(String txt, long s, long e, int num) {
        System.out.printf("%s: avg = %d nanos%n", txt, (e - s) / num);
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
        List<String> strings3 = new TreeList<>();

        listHelper("ArrayList", strings1);
        listHelper("LinkedList", strings2);
        listHelper("TreeList", strings3);

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
