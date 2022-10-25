package std.guedes.contactsapp.model;

import std.guedes.contactsapp.model.builder.ContactBuilder;

import java.util.Comparator;
import java.util.Objects;

/**
 * Essa classe representa um contato.
 *
 * @author João Guedes.
 */
public class Contact implements Comparable<Contact> {

    /**
     * Identidade única de cada contato.
     */
    private String id;
    /**
     * Nome do contato.
     */
    private String name;
    /**
     * Telefone do contato.
     */
    private String telephone;
    /**
     * Email do contato.
     */
    private String email;

    /**
     * Essa classe representa um contato.
     *
     * @author João Guedes.
     *
     * @param id id do contato.
     *
     * @param name nome do contato.
     *
     * @param telephone telefone do contato.
     *
     * @param email email do contato.
     */
    public Contact(String id, String name, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
    }

    /**
     * Essa classe representa um contato.
     *
     * @author João Guedes.
     */
    public Contact(){
    }

    /**
     * Retorna o id do contato.
     *
     * @return id do contato.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Altera o id do contato.
     *
     * @param id id que será atribuido ao contato.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retorna o nome do contato.
     *
     * @return nome do contato.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Altera o nome do contato.
     *
     * @param name nome que será atribuido ao contato.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o telefone do contato.
     *
     * @return telefone do contato.
     */
    public String getTelephone() {
        return this.telephone;
    }

    /**
     * Altera o telefone do contato.
     *
     * @param telephone telefone que será atribuido ao contato.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Retorna o email do contato.
     *
     * @return email do contato.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Altera o email do contato.
     *
     * @param email email que será atribuido ao contato.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Instancia um builder para a criação de um contato.
     */
    public static ContactBuilder builder() {
        return new ContactBuilder();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.telephone, this.email);
    }

    /**
     * Verifica se dois objetos são contatos iguais.
     *
     * @param o objeto que será comparado.
     *
     * @return true caso os objetos sejam iguais ou false caso sejam diferentes.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Contact contact = (Contact) o;
        return  Objects.equals(this.id, contact.id) &&
                Objects.equals(this.name, contact.name) &&
                Objects.equals(this.telephone, contact.telephone) &&
                Objects.equals(this.email, contact.email);
    }

    /**
     * Compara se um contato é maior que o outro levando em conta o nome do contato.
     *
     * @param contact objeto que será comparado.
     *
     * @return retorna -1 caso o objeto que chamou seja menor que o objeto que está sendo comparado, 0 caso seja
     * igual ou 1 caso o objeto que chamou seja maior que o objeto que está sendo comparado.
     */
    @Override
    public int compareTo(Contact contact) {
        return this.name.compareTo(contact.name);
    }

    /**
     * Retorna todos os atributos do contato em forma de texto.
     *
     * @return todos os atributos do contato em forma de texto.
     */
    @Override
    public String toString() {
        return "Contact {\n" +
                "   id = '" + this.id + "',\n" +
                "   name='" + this.name + "',\n" +
                "   telephone = '" + this.telephone + "',\n" +
                "   email = '" + this.email + "'\n" +
                '}';
    }

}