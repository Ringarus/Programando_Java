import java.io.IOException;

public class Console {
    public static void main(String[] args) throws IOException {
        //0 -> alterar dados
        //1 -> saque, deposito e transferencia
        Banking console = new Banking("banco.txt");
        console.alterarArquivo("12345678912", 1, null);
    }
}
