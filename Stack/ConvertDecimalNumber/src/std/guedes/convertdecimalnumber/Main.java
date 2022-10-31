package std.guedes.convertdecimalnumber;

import std.guedes.convertdecimalnumber.util.Mathematics;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite um número inteiro em decimal: ");
        int decimalNumber = input.nextInt();
        input.close();
        System.out.printf("O número %d em binário é %s\n",decimalNumber, Mathematics.decimalToAnyBase(decimalNumber, 2));
        System.out.printf("O número %d em hexadecimal é %s\n",decimalNumber, Mathematics.decimalToAnyBase(decimalNumber, 16));
    }

}