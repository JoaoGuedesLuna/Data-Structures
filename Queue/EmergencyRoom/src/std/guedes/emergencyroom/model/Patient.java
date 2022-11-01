package std.guedes.emergencyroom.model;

/**
 * Essa classe representa um paciente.
 *
 * @author João Guedes.
 */
public class Patient implements Comparable<Patient>{

    /**
     * Nome do paciente.
     */
    private String name;
    /**
     * Prioridade do paciente.
     */
    private int priority;

    /**
     * Essa classe representa um paciente.
     *
     * @param name Nome do paciente.
     *
     * @param priority Prioridade do paciente.
     *
     * @author João Guedes.
     */
    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    /**
     * Retorna o nome do paciente.
     *
     * @return Nome do paciente.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Altera o nome do paciente.
     *
     * @param name Nome que será atribuido ao paciente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a prioridade do paciente.
     *
     * @return Prioridade do paciente.
     */
    public int getPriority() {
        return this.priority;
    }

    /**
     * Altera a prioridade do paciente.
     *
     * @param priority Prioridade que será atribuida ao paciente.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Verifica se um paciente tem mais prioridade que outro.
     *
     * @param patient Paciente que será comparado.
     *
     * @return Retorna 1 caso o paciente que chamou o método tenha mais prioridade, 0 caso a prioridade seja a mesma ou
     * -1 caso a prioridade do paciente que chamou o método seja menor.
     */
    @Override
    public int compareTo(Patient patient) {
        return Integer.compare(this.priority, patient.priority);
    }

    /**
     * Retorna todos os atributos do paciente em forma de texto.
     *
     * @return Todos os atributos do paciente em forma de texto.
     */
    @Override
    public String toString() {
        return "Patient {\n" +
                "   name = '" + this.name + "',\n" +
                "   priority = " + this.priority + ",\n" +
                "}\n";
    }

}