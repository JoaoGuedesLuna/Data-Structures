package std.guedes.contactsapp;

import std.guedes.contactsapp.model.Contact;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Essa é a classe principal do programa, é nela que haverá a execução de toda a aplicação. O objetivo dessa classe
 * é simular um aplicativo onde a pessoa pode adicionar seus contatos, buscar seus contatos, ou remover seus contatos.
 * Toda a parte gráfica do programa foi feita apenas utilizando-se de métodos estáticos da classe JOptionPane.
 *
 * @author João Guedes.
 */
public class ContactsApp {

    /**
     * Lista de contatos do usuário.
     */
    private final List<Contact> contacts;

    /**
     * Essa é a classe principal do programa, é nela que haverá a execução de toda a aplicação. O objetivo dessa classe
     * é simular um aplicativo onde a pessoa pode adicionar seus contatos, buscar seus contatos, ou remover seus contatos.
     * Toda a parte gráfica do programa foi feita apenas utilizando-se de métodos estáticos da classe JOptionPane.
     *
     * @author João Guedes.
     */
    public ContactsApp() {
        this.contacts = new ArrayList<>();
        this.start();
    }

    /**
     * Inicia um loop que gerencia os painéis da aplicação de acordo com a escolha do usuário. O loop só será encerrado
     * caso o usuário deseje sair da aplicação.
     */
    private void start() {
        Integer option;
        do {
            option = this.showCentralOptionsDialog();
            if (option == null)
                return;
            if (option == 3)
                this.showAddContactDialog();
            else if (this.contacts.isEmpty())
                JOptionPane.showMessageDialog(null, "     Lista de contatos vazia.", null, JOptionPane.INFORMATION_MESSAGE);
            else if (option == 1)
                this.showContactSearchDialog();
            else if (option == 2)
                this.showContactsListDialog();
            else if (option == 4)
                this.showEditContactDialog();
            else if (option == 5)
                this.showRemoveContacDialog();
            else if (option == 6)
                this.showRemoveAllContatcsDialog();
        } while (true);
    }

    /**
     * Exibe um painel central de opções onde o usuário poderá escollher que opção ele deseja usar (visualizar contatos, adicinar contato,
     * buscar contato, remover contato...).
     *
     * @return retorna um valor equivalente a opção que o usuário escolheu.
     */
    private Integer showCentralOptionsDialog() {
        String[] options = this.createOptions();
        String input;
        int intInput;
        do {
            input = JOptionPane.showInputDialog(null, options, "Menu de Opções ⚙", JOptionPane.PLAIN_MESSAGE);
            if (input == null)
                return null;
            try {
                intInput = Integer.parseInt(input);
                if (intInput >= 1 && intInput <= options.length)
                    return intInput;
                JOptionPane.showMessageDialog(null, "          Opção Inválida!", null, JOptionPane.ERROR_MESSAGE);
            }
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "          Opção Inválida!", null, JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
    }

    /**
     * Exibe um painel onde o usuário poderá adicionar um contato a sua lista de contatos, informando nome, telefone e email.
     */
    private void showAddContactDialog() {
        String name, telephone, email;
        Contact newContact;
        do {
            name = this.showInputDialog("Nome", "Adicionar contato ➕", null);
            if (name == null)
                return;
            telephone = this.showInputDialog("Telefone", "Adicionar contato ➕", null);
            if (telephone == null)
                return;
            email = this.showInputDialog("Email", "Adicionar contato ➕",  null);
            if (email == null)
                return;
            if (name.length() == 0 && telephone.length() == 0 && email.length() == 0) {
                JOptionPane.showMessageDialog(null, "Não há nada para salvar. O contato foi descartado.", null, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            newContact = this.createContact(name, telephone, email);
            if (!this.contactAlreadyExists(newContact)) {
                this.contacts.add(newContact);
                this.contacts.sort(Contact::compareTo);
                JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, "Já existe um contato com essa mesma identificação.", null, JOptionPane.ERROR_MESSAGE);
        } while (true);
    }

    /**
     * Exibe um painel onde o usuário poderá visualizar os dados de um contato específico.
     */
    private void showContactSearchDialog() {
        Contact contactSearched = this.showSearchDialog();
        if (contactSearched == null)
            return;
        JOptionPane.showMessageDialog(null, this.contactInfomation(contactSearched), "Contato", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Exibe um painel onde o usuário poderá visualizar todos os seus contatos.
     */
    private void showContactsListDialog() {
        String[] contactsInformations = new String[this.contacts.size()];
        String[] visibleInformation = new String[4];
        String[] options = {"Cancelar", "⏪", "⏩"};
        for (int i = 0; i < this.contacts.size(); i++)
            contactsInformations[i] = this.contactInfomation(this.contacts.get(i));
        for (int i = 0; i < contactsInformations.length && i < visibleInformation.length; i++)
            visibleInformation[i] = contactsInformations[i];
        int option, lastIndex = visibleInformation.length-1, index, j, stop;
        do {
            option = JOptionPane.showOptionDialog(null, visibleInformation, "Visualizar Contatos 📑", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            if (option < 1)
                return;
            int length = visibleInformation.length;
            if (option == 1 && lastIndex > (length-1)) {
                visibleInformation = new String[length];
                index = lastIndex - (length*2-1);
                stop = index + length;
                lastIndex -= length;
                j = 0;
                for (;index < stop; index++)
                    visibleInformation[j++] = contactsInformations[index];
            }
            else if (option == 2 && lastIndex < contactsInformations.length-1) {
                visibleInformation = new String[length];
                index = lastIndex+1;
                stop = index + length;
                lastIndex += length;
                j = 0;
                for (; index < contactsInformations.length && index < stop; index++)
                    visibleInformation[j++] = contactsInformations[index];
            }
        } while (true);
    }

    /**
     * Exibe um painel onde o usuário poderá editar um contato específico.
     */
    private void showEditContactDialog() {
        Contact contactSearched = this.showSearchDialog();
        if (contactSearched == null)
            return;
        Contact editedContact;
        String name, telephone, email;
        do {
            name = this.showInputDialog("Nome", "Adicionar contato ➕", contactSearched.getName());
            if (name == null)
                return;
            telephone = this.showInputDialog("Telefone", "Adicionar contato ➕", contactSearched.getTelephone());
            if (telephone == null)
                return;
            email = this.showInputDialog("Email", "Adicionar contato ➕", contactSearched.getEmail());
            if (email == null)
                return;
            if (name.length() == 0 && telephone.length() == 0 && email.length() == 0)
                JOptionPane.showMessageDialog(null, "Campos vazios. Digite algo ou cancele a edição.", null, JOptionPane.ERROR_MESSAGE);
            else {
                editedContact = this.createContact(name, telephone, email);
                if (!this.editedContactAlreadyExists(contactSearched, editedContact)) {
                    this.contacts.set(this.contacts.indexOf(contactSearched), editedContact);
                    this.contacts.sort(Contact::compareTo);
                    JOptionPane.showMessageDialog(null, "Contato editado com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Já existe um contato com a mesma identificação!", null, JOptionPane.ERROR_MESSAGE);
            }
        } while(true);
    }

    /**
     * Exibe um painel onde o usuário poderá remover um contato em específico.
     */
    private void showRemoveContacDialog () {
        Contact contactSearched = this.showSearchDialog();
        if (contactSearched == null)
            return;
        String message = this.contactInfomation(contactSearched) + "\nTem certeza que deseja excluir este contato?";
        int option = JOptionPane.showConfirmDialog(null, message, "Excluir Contato ❌",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == 0) {
            this.contacts.remove(contactSearched);
            JOptionPane.showMessageDialog(null, "Contato removido com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "O contato não foi excluído.", null, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Exibe um painel onde o usuário poderá remover todos os contatos da sua lista de contatos.
     */
    private void showRemoveAllContatcsDialog() {
        int option = JOptionPane.showConfirmDialog(null, "Você tem certeza que quer excluir todos os seus contatos?", "Excluir todos os contatos ⚠", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option != 0) {
            JOptionPane.showMessageDialog(null, "Seus contatos não foram excluídos!", null, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        this.contacts.clear();
        JOptionPane.showMessageDialog(null, "Contatos excluídos com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Exibe um painel onde o usuário poderá fazer a busca de um contato.
     *
     * @return Retorna um contato. Caso o contato não seja encontrado será retornado o valor null.
     */
    private Contact showSearchDialog() {
        String contactId = this.showInputDialog("Contato: ", "Buscar Contato 🔎", null);
        if (contactId == null)
            return null;
        Contact contactSearched = this.findContactById(contactId);
        if (contactSearched == null)
            JOptionPane.showMessageDialog(null, "Contato não encontrado.", null, JOptionPane.INFORMATION_MESSAGE);
        return contactSearched;
    }

    /**
     * Exibe um painel de entrada onde o usuário irá preencher uma informação do contato.
     *
     * @param message tipo da informação que o usuário irá passar, ex. nome, telefone, email...
     *
     * @param title título do painel.
     *
     * @param initialValue valor inicial do campo de texto.
     *
     * @return retorna o valor que o usuário passou de entrada. Caso ele não passe nada o valor retornado será null.
     */
    private String showInputDialog(String message, String title, String initialValue) {
        String input = (String) JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, null, null, initialValue);
        if (input == null)
            return null;
        return input.trim();
    }

    /**
     * Cria um contato. Caso o nome do contato seja diferente de null, o id do contato será igual ao nome. Caso o nome do
     * contato seja null e o telefone diferente de null, então o id do contato será igual ao telefone. Caso o nome e o
     * telefone sejam null, então o id do contato será igual ao email.
     *
     * @param name nome do contato.
     *
     * @param telephone telefone do contato.
     *
     * @param email email do contato.
     *
     * @return um contato.
     */
    private Contact createContact(String name, String telephone, String email) {
        if (name.trim().length() > 0)
            return new Contact(name, name, telephone, email);
        if (telephone.trim().length() > 0)
            return new Contact(telephone, name, telephone, email);
        return new Contact(email, name, telephone, email);
    }

    /**
     * Busca um contato na lista de contatos pelo id.
     *
     * @param contactId id do contato procurado.
     *
     * @return Retorna um contato. Caso o contato não seja encontrado o valor retornado será null.
     */
    private Contact findContactById(String contactId) {
        for (Contact contact : this.contacts) {
            if (contact.getId().equalsIgnoreCase(contactId))
                return contact;
        }
        return null;
    }

    /**
     * Diz se um contato com uma mesma identificação já existe na lista de contatos.
     *
     * @param contact contato que será avaliado.
     *
     * @return true caso um contato com a mesma identificação já esteja contido na lista de contatos ou false caso não
     * exista nem um contato com a mesma identificação.
     */
    private boolean contactAlreadyExists(Contact contact) {
        return this.findContactById(contact.getId()) != null;
    }

    /**
     * Retorna uma String contendo todas as informações de um contato de forma formatada.
     *
     * @param contact contato que terá suas informações em forma de String.
     *
     * @return String contendo todas as informações de um contato de forma formatada.
     */
    private String contactInfomation(Contact contact) {
        return "-----------------------------------------------------" +
                "\nNome : " + contact.getName() +
                "\nTelefone : " + contact.getTelephone() +
                "\nEmail: " + contact.getEmail() +
                "\n-----------------------------------------------------";
    }

    /**
     * Retorna se um contato editado já existe na lista de contatos.
     *
     * @param contact contato antes da edição.
     *
     * @param editedContact contato após a edição.
     *
     * @return true caso o contato editado já exista ou false caso o contato editado não exista na lista de contatos.
     */
    private boolean editedContactAlreadyExists(Contact contact, Contact editedContact) {
        for (Contact c : this.contacts) {
            if (c.getId().equalsIgnoreCase(editedContact.getId()) && !(c.equals(contact)))
                return true;
        }
        return false;
    }

    /**
     * Retorna um array de String onde cada posição equivale a uma opção da central de opções.
     *
     * @return array de String onde cada posição equivale a uma opção da central de opções.
     */
    private String[] createOptions() {
        return new String[]{"[1] - Buscar Contato 🔎",
                "[2] - Visualizar Contatos 👁",
                "[3] - Adicionar Contato ➕",
                "[4] - Editar Contato 🖍",
                "[5] - Excluir Contato ❌",
                "[6] - Excluir Todos os contatos ⚠"};
    }

    public static void main(String[] args) {
        new ContactsApp();
    }

}