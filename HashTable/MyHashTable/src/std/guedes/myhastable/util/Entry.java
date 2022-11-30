package std.guedes.myhastable.util;

import java.util.Objects;

/**
 * Essa Classe é um tipo de registro que estará na tabela hash.
 *
 * @param <K> Tipo de dado da chave.
 *
 * @param <V> Tipo de dado do valor.
 *
 * @author João Guedes.
 */
public class Entry<K, V> {

    private K key;
    private V value;
    private Entry<K, V> next;

    /**
     * Essa Classe é um tipo de registro que estará na tabela hash.
     *
     * @param key Chave.
     *
     * @param value Valor.
     *
     * @param next Próximo elemento.
     *
     * @author João Guedes.
     */
    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    /**
     * Essa Classe é um tipo de registro que estará na tabela hash.
     *
     * @param key Chave.
     *
     * @param value Valor.
     *
     * @author João Guedes.
     */
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;

    }

    /**
     * Essa Classe é um tipo de registro que estará na tabela hash.
     *
     * @author João Guedes.
     */
    public Entry() {
        this.key = null;
        this.value = null;
        this.next = null;

    }

    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entry<K, V> getNext() {
        return this.next;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Entry<?, ?> entry = (Entry<?, ?>) o;
        return  Objects.equals(this.key, entry.key) &&
                Objects.equals(this.value, entry.value) &&
                Objects.equals(this.next, entry.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key, this.value, this.next);
    }

    @Override
    public String toString() {
        return "Entry {" +
                "key = " + this.key +
                ", value = " + this.value +
                ", next = " + this.next +
                '}';
    }

}