package org.keysort.core;

public class Main {
    public static void main(String[] args) {
        KList<Integer> list = new KArrayList<>();

        list.add(2);
        list.add(3);
        list.add(4);

        for(Integer i : list) {
            System.out.println(i);
        }
    }
}