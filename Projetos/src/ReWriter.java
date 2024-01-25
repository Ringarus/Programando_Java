import java.io.IOException;
import java.io.RandomAccessFile;

public class ReWriter {
    public static void main(String[] args) {
        String caminhoArquivo = "banco.txt";
        String linhaParaModificar = "Joao,123,18,2904,300.00,3";
        String novaLinha = "Jefferson,581,18,7777,3000.00,1";

        try (RandomAccessFile arquivo = new RandomAccessFile(caminhoArquivo, "rw")) {
            String linha;
            long posicaoInicioLinha = 0;
            while ((linha = arquivo.readLine()) != null) {
                if (linha.equals(linhaParaModificar)) {
                    // Modificar a linha conforme necessário
                    String linhaModificada = String.format("%-" + linha.length() + "s", novaLinha);
                    arquivo.seek(posicaoInicioLinha);
                    arquivo.writeBytes(linhaModificada);
                    break;  // A linha foi encontrada e modificada, podemos sair do loop
                }
                posicaoInicioLinha = arquivo.getFilePointer();  // Salvar a posição do início da próxima linha
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}