package std.guedes.convertdecimalnumber.util;

import java.util.Stack;

/**
 * Essa classe disponibiliza um método para conversão de número decimal em um número correspondente em outra base.
 *
 * @author João Guedes.
 */
public class Mathematics {

    /**
     * Converte um número de base decimal em um número correspondente em outra base. A base númerica deve ser de 2 a 16.
     *
     * @param decimalNumber Número em base decimal.
     *
     * @param base Base numérica em que o número decimal será convertido.
     *
     * @return Um número decimal convertido para outra base numérica.
     */
    public static String decimalToAnyBase(int decimalNumber, int base) {
        if (decimalNumber == 0)
            return "0";
        if (base < 2 || base > 16)
            throw new IllegalArgumentException("Numeric Base must be between 2 and 16");
        String bases = "0123456789ABCDEF";
        Stack<Integer> stack = new Stack<>();
        while (decimalNumber > 0) {
            stack.push(decimalNumber % base);
            decimalNumber /= base;
        }
        StringBuilder convertedNumber = new StringBuilder();
        while(!stack.isEmpty())
            convertedNumber.append(bases.charAt(stack.pop()));
        return convertedNumber.toString();
    }

}