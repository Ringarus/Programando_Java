package Banco_Digital;
import java.io.*;

public class Searcher {
    public static void main(String[] args) {
        // Especifica o caminho do arquivo
        String caminhoArquivo = "banco.txt";

        // Especifica a string que você deseja encontrar e substituir
        String textoParaEncontrar = "Tchuibiraudawn";
        String novoTexto = "GALALAU";

        try {
            // Leitura do conteúdo do arquivo
            FileReader fileReader = new FileReader(caminhoArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder conteudo = new StringBuilder();
            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
                // Substitui o texto se encontrado
                if (linha.contains(textoParaEncontrar)) {
                    linha = linha.replace(textoParaEncontrar, novoTexto);
                }
                conteudo.append(linha).append(System.lineSeparator());
            }

            // Fecha o BufferedReader
            bufferedReader.close();

            // Sobrescreve o arquivo com o conteúdo modificado
            FileWriter fileWriter = new FileWriter(caminhoArquivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(conteudo.toString());

            // Fecha o BufferedWriter
            bufferedWriter.close();

            System.out.println("Conteúdo modificado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
