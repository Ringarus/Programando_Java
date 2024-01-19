package Basico;
/**
 * EstruturasDeControle
 */
public class EstruturasDeControle {

    public static void main(String[] args) {
    int numero = 10;
    String nome = "Joseph";
    char JosephFirstLetter = 'J';
    /*
    * Vamos estudar primeiramente estruturas de condição e seus shortcuts (ternary)
    */
    if(numero >= 10){
        System.out.println("É maior ou igual ao número 10.");
    } else if(numero<=8){
        System.out.println("É menor ou igual ao número 8.");
    } else {
        System.out.println("É o número 9.");
    }

    // Para comparar strings usamos .equals()
    // Para comparar caracteres usamos '=='
    if (nome.equals("Joseph")){
        System.out.println("Seu nome é Joseph.");
    } else {
        System.out.println("Ei! Você não é o Joseph!");
    }

    // Para usar o ternário (shortcut de uma condicional) usamos (condição) ? retorno caso V : retorno caso F;
    System.out.printf("A primeira letra do seu nome é J? %s", (JosephFirstLetter=='J')?"SIM":"NÃO");
    }
}