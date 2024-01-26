import java.io.IOException;

public class Console {
    public static void main(String[] args) throws IOException {
        
        ManipuladorArquivo console = new ManipuladorArquivo("banco.txt");
        console.alterarArquivo(null);
        String ler = console.lerArquivo();
        System.out.println(ler);
    }
}
