import java.util.*;

public class Cardapio {
    private static String escolha;


    public static void main(String[] args ) {
        Scanner scInput = new Scanner(System.in);
        System.out.println(" --- Bem vindo ao Cardápio Digital! --- \n [1]. X - Salada \n [2]. X - Burguer \n [3]. X - Bacon \n Digite o número do lanche: ");
        escolha = scInput.nextLine();
        switch (escolha) {
            case "1":
            System.out.println("X - Salada??? tá de regime??? - Seu pedido ficará pronto logo");
            
                
                break;
            case "2":
            System.out.println("X - Burguer - o tradicional - Seu pedido ficará pronto logo");

                break;
            case "3":
            System.out.println("X Bacon - Ninguém resiste ao BACON - Seu pedido ficará pronto logo");

                break;
        
            default:
            System.out.println("Número inválido");
                break;
 
        }
        scInput.close();   
    }
}