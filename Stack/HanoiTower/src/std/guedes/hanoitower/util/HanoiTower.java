package std.guedes.hanoitower.util;

import java.util.Stack;

/**
 * Essa classe simula o jogo Torre de Hanói. O famoso jogo da Torre de Hanói é um "quebra-cabeça" que consiste em uma base
 * contendo três pinos, em um dos quais são dispostos alguns discos uns sobre os outros, em ordem crescente de diâmetro,
 * de cima para baixo. <br><br><Strong>Objetivo:</Strong> mover todos os discos para o pino da direita. <br><br>
 * <strong>Regras:</strong> Deve-se mover um disco de cada vez, sendo que um disco maior nunca pode ficar em cima de um disco menor.
 *
 * @author João Guedes.
 */
public class HanoiTower {

    /**
     * Torre da esquerda.
     */
    private Stack<Integer> leftTower;
    /**
     * Torre do meio.
     */
    private Stack<Integer> centerTower;
    /**
     * Torre da direita.
     */
    private Stack<Integer> rightTower;
    /**
     * Número de discos iniciais.
     */
    private int disk;

    /**
     * Essa classe simula o jogo Torre de Hanói. O famoso jogo da Torre de Hanói é um "quebra-cabeça" que consiste em uma base
     * contendo três pinos, em um dos quais são dispostos alguns discos uns sobre os outros, em ordem crescente de diâmetro,
     * de cima para baixo. <br><br><Strong>Objetivo:</Strong> mover todos os discos para o pino da direita. <br><br>
     * <strong>Regras:</strong> Deve-se mover um disco de cada vez, sendo que um disco maior nunca pode ficar em cima de um disco menor.
     *
     * @param disk Número de discos iniciais.
     *
     * @author João Guedes.
     */
    public HanoiTower(int disk) {
        this.leftTower = new Stack<>();
        this.centerTower = new Stack<>();
        this.rightTower = new Stack<>();
        this.disk = disk;
        for (int i = disk; i >= 1; i--)
            this.leftTower.push(i);
    }

    /**
     * Exibe o estado atual das três torres.
     */
    public void show() {
        System.out.println(this.leftTower);
        System.out.println(this.centerTower);
        System.out.println(this.rightTower);
        System.out.println();
    }

    /**
     * Soluciona o desafio Torre de Hanói.
     */
    public void solve() {
        this.solve(this.leftTower, this.centerTower, this.rightTower, this.disk);
    }

    /**
     * Soluciona o desafio Torre de Hanói.
     *
     * @param originalTower Torre de origem. Torre que contém o disco que será movido.
     *
     * @param auxiliaryTower Torre auxiliar.
     *
     * @param targetTower Torre de destino.
     *
     * @param disk Número de discos na torre de origem.
     */
    private void solve(Stack<Integer> originalTower, Stack<Integer> auxiliaryTower, Stack<Integer> targetTower, int disk) {
        if (disk < 1)
            return;
        this.solve(originalTower, targetTower, auxiliaryTower, disk-1); // origem para o auxiliar
        targetTower.push(originalTower.pop());                               // origem para o destino
        this.solve(auxiliaryTower, originalTower, targetTower, disk-1); // auxiliar para o destino
    }

}
