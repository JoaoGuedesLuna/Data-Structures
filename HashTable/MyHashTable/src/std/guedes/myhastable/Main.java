package std.guedes.myhastable;

import std.guedes.myhastable.util.MyHashTable;

public class Main {

    public static void main(String[] args) {
        MyHashTable<String, String> hashTable = new MyHashTable<>(10);

        System.out.println("Tabela Hash está vazia? " + hashTable.isEmpty());
        System.out.println("Tamanho da Tabela Hash: " + hashTable.size());
        System.out.println("Adicionando elementos...");
        hashTable.put("A0001", "Marcelo");
        hashTable.put("A0002", "Solange");
        System.out.println("Tabela Hash: " + hashTable);

        System.out.println("Tabela Hash está vazia? " + hashTable.isEmpty());
        System.out.println("Tamanho da Tabela Hash: " + hashTable.size());
        System.out.println("Tabela Hash contém chave \"A0001\": " + hashTable.containsKey("A0001"));
        System.out.println("Tabela Hash contém chave \"A0003\": " + hashTable.containsKey("A0003"));
        System.out.println("Elemento de chave \"A0004\": " + hashTable.get("A0004"));
        System.out.println("Adicionando elemento de chave \"A0004\"...");
        hashTable.put("A0004", "João");
        System.out.println("Elemento de chave \"A0004\": " + hashTable.get("A0004"));
        System.out.println("Tabela Hash: " + hashTable);
        System.out.println("Tabela Hash contém o valor \"João\": " + hashTable.containsValue("João"));
        System.out.println("Tabela Hash contém o valor \"Marcelo\": " + hashTable.containsValue("Marcelo"));

        System.out.println("Removendo elemento de chave \"A0005\": " + hashTable.remove("A0005"));
        System.out.println("Tabela Hash: " + hashTable);
        System.out.println("Removendo elemento de chave \"A0001\": " + hashTable.remove("A0001"));
        System.out.println("Tabela Hash contém o valor \"Marcelo\": " + hashTable.containsValue("Marcelo"));
        System.out.println("Tabela Hash: " + hashTable);

        System.out.println("Elemento de chave \"A0008\" foi substituido? " + hashTable.replace("A0008", "Eduarda"));
        System.out.println("Tabela Hash: " + hashTable);
        System.out.println("Elemento de chave \"A0004\" foi substituido: " + hashTable.replace("A0004", "João Guedes"));
        System.out.println("Tabela Hash: " + hashTable);

        System.out.println("Tabela Hash está vazia? " + hashTable.isEmpty());
        System.out.println("Tamanho da Tabela Hash: " + hashTable.size());
        System.out.println("Tabela Hash: " + hashTable);
        System.out.println("Limpando Tabela Hash...");
        hashTable.clear();
        System.out.println("Tabela Hash está vazia? " + hashTable.isEmpty());
        System.out.println("Tamanho da Tabela Hash: " + hashTable.size());
        System.out.println("Tabela Hash: " + hashTable);
    }

}