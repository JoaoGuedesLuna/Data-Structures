package std.guedes.contactsapp.model.builder;

import std.guedes.contactsapp.model.Contact;

/**
 * Essa classe tem como objetivo criar uma Contact (Contato) por meio da chamada de seus métodos de forma sucessiva.
 *
 * @author João Guedes.
 */
public class ContactBuilder {

    private final Contact contact;

    /**
     * Essa classe tem como objetivo criar uma Contact (Contato) por meio da chamada de seus métodos de forma sucessiva.
     *
     * @author João Guedes.
     */
    public ContactBuilder() {
        contact = new Contact();
    }

    /**
     * Adiciona um id ao contato que será criado. Para finalizar a chamada de métodos sucessivos chame o método build.
     *
     * @param id id do contato que será criado.
     *
     * @return retorna o próprio objeto ContactBuilder permitindo a chamada de mais métodos sucessivos.
     */
    public ContactBuilder id(String id) {
        this.contact.setId(id);
        return this;
    }

    /**
     * Adiciona um nome ao contato que será criado. Para finalizar a chamada de métodos sucessivos chame o método build.
     *
     * @param name nome do contato que será criado.
     *
     * @return retorna o próprio objeto ContactBuilder permitindo a chamada de mais métodos sucessivos.
     */
    public ContactBuilder name(String name) {
        this.contact.setName(name);
        return this;
    }

    /**
     * Adiciona um telefone ao contato que será criado. Para finalizar a chamada de métodos sucessivos chame o método build.
     *
     * @param telephone telefone do contato que será criado.
     *
     * @return retorna o próprio objeto ContactBuilder permitindo a chamada de mais métodos sucessivos.
     */
    public ContactBuilder telephone(String telephone) {
        this.contact.setTelephone(telephone);
        return this;
    }

    /**
     * Adiciona um email ao contato que será criado. Para finalizar a chamada de métodos sucessivos chame o método build.
     *
     * @param email email do contato que será criado.
     *
     * @return retorna o próprio objeto ContactBuilder permitindo a chamada de mais métodos sucessivos.
     */
    public ContactBuilder email(String email) {
        this.contact.setEmail(email);
        return this;
    }

    /**
     * Método que retorna um Contact (Contato). Deve ser usado no fim da construção do contato, após a chamada de outro métodos
     * sucessivos.
     *
     * @return retorna uma contato.
     */
    public Contact build() {
        return this.contact;
    }

}