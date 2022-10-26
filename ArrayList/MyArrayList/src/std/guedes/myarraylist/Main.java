package std.guedes.myarraylist;

import std.guedes.myarraylist.util.MyArrayList;

public class Main {

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Marcelo");
        list.add("Solange");
        list.add("Eduarda");
        list.add("João");
        list.add("Eduarda");
        System.out.println(list);
        System.out.println(list.get(list.size()-1));
        list.set(list.indexOf("Marcelo"), "Marcelo Luna");
        list.set(list.indexOf("Solange"), "Solange Guedes");
        list.set(list.indexOf("Eduarda"), "Maria Eduarda");
        list.set(list.indexOf("João"), "João Guedes");
        list.set(list.lastIndexOf("Eduarda"), "Eduarda Guedes");
        System.out.println(list);
        list.remove("Marcelo Luna");
        list.remove(list.indexOf("Eduarda Guedes"));
        list.add("Zoe Guedes");
        list.add("Sofia Guedes");
        System.out.println(list);
        System.out.println(list.contains("João Guedes"));
    }
    
}