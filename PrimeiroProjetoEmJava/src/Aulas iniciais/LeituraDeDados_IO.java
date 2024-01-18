import java.util.Scanner;


public class LeituraDeDados_IO {
    

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.err.println("Qual é o meu nome?");
        String answer = s.nextLine();
        System.out.println("Isso aí, eu sou o "+ answer);
    }
}
