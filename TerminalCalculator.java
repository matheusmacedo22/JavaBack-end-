import java.util.*;

public class TerminalCalculator {
    private static String numero1;
    private static String numero2;

    public static void main(String[] args ) {
        Scanner scInput = new Scanner(System.in);
        System.out.println("Digite o primeiro número que será somada, e tecle enter: ");
        numero1 = scInput.nextLine();
        System.out.println("Digite o segundo número que será somada, e tecle enter: ");
        numero2 = scInput.nextLine();
        System.out.println(String.format("O resultado da soma é: %d", Integer.valueOf(numero1) + Integer.valueOf(numero2)));
        
        scInput.close();
    }
}