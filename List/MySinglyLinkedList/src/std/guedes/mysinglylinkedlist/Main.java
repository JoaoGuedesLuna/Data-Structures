package std.guedes.mysinglylinkedlist;

import std.guedes.mysinglylinkedlist.util.MySinglyLinkedList;

/**
 * @author João Guedes.
 */
public class Main {

    public static void main(String[] args) {
        MySinglyLinkedList<String> list = new MySinglyLinkedList<>();
        System.out.println("Lista : " + list);
        System.out.println("Tamanho da lista : " + list.size());
        System.out.println("Lista está vazia? " + list.isEmpty());
        System.out.println("Adicionando elementos a lista...");
        list.add("Marcelo");
        list.add("Solange");
        list.add("Eduarda");
        list.add("João");
        System.out.println("Lista : " + list);
        System.out.println("Tamanho da lista : " + list.size());
        System.out.println("Lista está vazia? " + list.isEmpty());
        System.out.println("Último elemento da lista : " + list.get(list.size()-1));
        System.out.println("Alterando elementos da lista...");
        list.set(list.indexOf("Marcelo"), "Marcelo Luna");
        list.set(list.indexOf("Solange"), "Solange Guedes");
        list.set(list.indexOf("Eduarda"), "Maria Eduarda");
        list.set(list.indexOf("João"), "João Guedes");
        System.out.println("Lista : " + list);
        System.out.println("Tamanho da lista : " + list.size());
        System.out.println("Lista está vazia? " + list.isEmpty());
        System.out.println("Removendo elementos da lista...");
        list.remove("Marcelo Luna");
        list.remove(list.indexOf("Maria Eduarda"));
        System.out.println("Lista : " + list);
        System.out.println("Tamanho da lista : " + list.size());
        System.out.println("Lista está vazia? " + list.isEmpty());
        System.out.println("Adicionando elementos a lista...");
        list.add("Zoe Guedes");
        list.add("Sofia Guedes");
        System.out.println("Lista : " + list);
        System.out.println("Tamanho da lista : " + list.size());
        System.out.println("Lista está vazia? " + list.isEmpty());
        System.out.println("Lista contém \"João Guedes\"? " + list.contains("João Guedes"));
        System.out.println("Limpando a lista...");
        list.clear();
        System.out.println("Lista : " + list);
        System.out.println("Tamanho da lista : " + list.size());
        System.out.println("Lista está vazia? " + list.isEmpty());
    }

}