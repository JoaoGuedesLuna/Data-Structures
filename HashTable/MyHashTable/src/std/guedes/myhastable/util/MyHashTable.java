package std.guedes.myhastable.util;

/**
 * Uma tabela de dispersão (também conhecida por tabela de espalhamento ou tabela hash) é uma estrutura de dados especial,
 * que associa chaves de pesquisa a valores, através de uma função. Seu objetivo é, a partir de uma chave simples,
 * fazer a busca rápida e obter o valor desejado.
 *
 * @param <K> Tipo de dado da chave.
 *
 * @param <V> Tipo de dado do valor.
 *
 * @author João Guedes.
 */
public class MyHashTable<K, V> {

    /**
     * Array interno da tabela hash.
     */
    private Entry<K, V>[] arrayHash;
    /**
     * Tamanho literal do array interno da tabela hash.
     */
    private final int CAPACITY;
    /**
     * Tamanho da tabela hash. Leva em consideração as posições ocupadas e não o tamanho literal do estrutura.
     */
    private int size;

    /**
     * Uma tabela de dispersão (também conhecida por tabela de espalhamento ou tabela hash) é uma estrutura de dados especial,
     * que associa chaves de pesquisa a valores, através de uma função. Seu objetivo é, a partir de uma chave simples,
     * fazer a busca rápida e obter o valor desejado.
     *
     * @param initialCapacity Tamanho literal do array interno da tabela hash.
     *
     * @author João Guedes.
     */
    public MyHashTable(int initialCapacity) {
        this.CAPACITY = initialCapacity;
        this.arrayHash = new Entry[this.CAPACITY];
        this.size = 0;
    }

    /**
     * Uma tabela de dispersão (também conhecida por tabela de espalhamento ou tabela hash) é uma estrutura de dados especial,
     * que associa chaves de pesquisa a valores, através de uma função. Seu objetivo é, a partir de uma chave simples,
     * fazer a busca rápida e obter o valor desejado.
     *
     * @author João Guedes.
     */
    public MyHashTable() {
        this.CAPACITY = 10;
        this.arrayHash = new Entry[this.CAPACITY];
        this.size = 0;
    }

    /**
     * Esse método gera o código hash de acordo com a capcadidade do array interno.
     *
     * @return Retorna a posição hash de uma chave.
     */
    private int hash(K key) {
        int hash = key.hashCode() % this.CAPACITY;
        if (hash < 0) {
            hash *= -1;
        }
        return hash;
    }

    /**
     * Retorna o número de elementos contidos na estrutura.
     *
     * @return Número de elementos contidos na estrutura.
     */
    public int size() {
        return this.size;
    }

    /**
     * Método que insere um registro na tabela hash. Caso já exista uma chave igual apenas o valor do registro já existente
     * será substituido. A chave e o valor não podem ser null.
     *
     * @param key Chave do registro.
     *
     * @param value Valor do registro.
     */
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("ERROR: key and value must not be null!");
        }
        int hashIndex = this.hash(key);
        Entry<K, V> entry = this.arrayHash[hashIndex];
        while (entry != null) {
            if(entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
            entry = entry.getNext();
        }
        entry = this.arrayHash[hashIndex];
        this.arrayHash[hashIndex] = new Entry<>(key, value, entry);
        this.size++;
    }

    /**
     * Retorna um registro de acordo com a chave especificada. Caso a chave não existe na estrutura será retornado o valor
     * null. A chave não pode ser null.
     *
     * @param key Chave pela qual se fará a busca.
     *
     * @return Retorna um registro de acordo com a chave especificada.
     */
    private Entry<K, V> getEntry(K key) {
        if (key == null) {
            throw new IllegalArgumentException("ERROR: key must not be null!");
        }
        int hashIndex = this.hash(key);
        Entry<K, V> entry = this.arrayHash[hashIndex];
        while (entry != null) {
            if(entry.getKey().equals(key)) {
                return entry;
            }
            entry = entry.getNext();
        }
        return null;
    }

    /**
     * Retorna um valor de acordo com a chave associada. Caso a chave não existe na estrutura será retornado o valor
     * null. A chave não pode ser null.
     *
     * @param key Chave pela qual se fará a busca.
     *
     * @return Retorna um valor de acordo com a chave associada.
     */
    public V get(K key) {
        Entry<K, V> entry = this.getEntry(key);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    /**
     * Remove um elemento da estrutura de acordo com a chave. A chave não deve ser null.
     *
     * @param key Chave que será procurada para remoção.
     *
     * @return Retrona o valor do elemento removido.
     */
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("ERROR: key must not be null!");
        }
        int hashIndex = this.hash(key);
        Entry<K, V> entry = this.arrayHash[hashIndex];
        Entry<K, V> previousEntry = null;
        while (entry != null && !entry.getKey().equals(key)) {
            previousEntry = entry;
            entry = entry.getNext();
        }
        if (entry == null) {
            return null;
        }
        if (previousEntry == null) {
            this.arrayHash[hashIndex] = entry.getNext();
        }
        else {
            previousEntry.setNext(entry.getNext());
        }
        this.size--;
        return entry.getValue();
    }

    /**
     * Substitui o registro especificado pela chave mudando seu valor por um novo valor. A mudança só será feita
     * se já existir um registro com a chave passada como parâmetro.
     *
     * @param key Chave especificada para busca.
     *
     * @param newValue Novo valor do registro.
     *
     * @return Retorna true caso alguma substituição seja feita ou false caso nenhuma mudança seja feita.
     */
    public boolean replace(K key, V newValue) {
        Entry<K, V> entry = this.getEntry(key);
        if (entry != null) {
            entry.setValue(newValue);
            return true;
        }
        return false;
    }

    /**
     * Esse método retorna se uma determinada chave está contida na estrutura.
     *
     * @param key Chave procurada.
     *
     * @return Retorna se uma determinada chave está contida na estrutura.
     */
    public boolean containsKey(K key) {
        return this.getEntry(key) != null;
    }

    /**
     * Esse método retorna se um determinado valor está contida na estrutura.
     *
     * @param value Valor procurada.
     *
     * @return Retorna sse um determinado valor está contida na estrutura.
     */
    public boolean containsValue(V value) {
        if (value == null) {
            throw new IllegalArgumentException("ERROR: value must not be null!");
        }
        for (Entry<K, V> entry : this.arrayHash) {
            while (entry != null) {
                if (entry.getValue().equals(value)) {
                    return true;
                }
                entry = entry.getNext();
            }
        }
        return false;
    }

    /**
     * Faz a limpeza da estrutura, removendo todos os elementos.
     */
    public void clear() {
        Entry<K, V> entry;
        Entry<K, V> nextEntry;
        for (int i = 0; i < this.arrayHash.length; i++) {
            entry = this.arrayHash[i];
            while (entry != null) {
                nextEntry = entry.getNext();
                entry.setKey(null);
                entry.setValue(null);
                entry.setNext(null);
                entry = nextEntry;
                this.size--;
            }
            this.arrayHash[i] = null;
        }
    }

    /**
     * Diz se a estrutura está vazia, se não contém elementos.
     *
     * @return true caso a estrutura esteja vazia ou false caso contenha algum elemento.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("{");
        for (Entry<K, V> entry : this.arrayHash) {
            while (entry != null) {
                sBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
                entry = entry.getNext();
            }
        }
        if (sBuilder.length() > 2) {
            sBuilder.delete(sBuilder.length() - 2, sBuilder.length());
        }
        return sBuilder.append("}").toString();
    }

}