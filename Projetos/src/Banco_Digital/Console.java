package Banco_Digital;
import java.io.IOException;

public class Console {
    public static void main(String[] args) throws IOException {
        //0 -> alterar dados
        //1 -> saque, deposito e transferencia
        Banking console = new Banking("banco.txt");
        console.escreverArquivo("Jose Mario", "11111111122", "75", "1945");
        console.lerArquivo();
    }
}
