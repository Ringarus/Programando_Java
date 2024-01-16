import java.util.Scanner;

public class Armazena {
    /* EX1
    * Crie um programa que declare variáveis para armazenar seu 
    * nome, idade e altura. Em seguida, imprima essas informações 
    * formatadas no console. 
    */

    /* EX2
     * Modifique o programa anterior para utilizar diferentes tipos de dados primitivos e realizar 
     * operações aritméticas, relacionais e lógicas. 
     * Por exemplo, calcule a média de duas notas, verifique se a idade é maior que 18, etc.
     */

    /*
     * NOTA: PARA COMPARAR STRINGS NÃO USAR '==' E SIM O MÉTODO .equals()
     */



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu NOME:");
        String nome = scanner.nextLine();
        System.out.print("Digite sua IDADE:");
        int idade = scanner.nextInt();
        System.out.printf("Oi, meu nome é %s e tenho %d anos\n", nome, idade);
        System.out.print("Deseja ver suas notas? (true/false)");
        boolean avalia = scanner.nextBoolean();
        if (idade > 18){
            System.out.print("VERIFICANDO: É maior de 18 anos.");
            if (nome.equals("Aluno") && avalia==true ){
                System.out.printf("USER: %s\n", nome);
                float nota1 = 9;
                float nota2 = 8;
                System.out.printf("Minha nota foi %.2f\n", ((nota1+nota2)/2));
            }
        }
    scanner.close();
    }
}
