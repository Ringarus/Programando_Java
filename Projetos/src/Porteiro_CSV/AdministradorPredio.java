package Porteiro_CSV;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class AdministradorPredio {
    final static String arquivo = "C:\\Users\\Valério\\Documents\\Java_Project\\Programando_Java\\Projetos\\src\\Porteiro_CSV\\predio.txt";
    static ArrayList<String[]> tabela = gerarTabelinha();

    public static void main(String[] args) {
        alterador(3, "Jefferson", "Mathias");
        adicionar();
        exibirTabelaFormatada();
    }

    public static void exibirTabelaFormatada() {
        System.out.println("| Andar  | Apartamento | Ocupado | Proprietario  |        Moradores          |    TelContato    |            Email               |");
        System.out.println("|--------|-------------|---------|---------------|---------------------------|------------------|--------------------------------|");
        boolean primeiraIteracao = true;
        for (String[] arrayLinha : tabela) {
            if (!primeiraIteracao) {
                System.out.format("| %-6s | %-11s | %-7s | %-13s | %-25s | %-16s | %-30s |\n", 
                                arrayLinha[0], arrayLinha[1], arrayLinha[2], arrayLinha[3], arrayLinha[4], arrayLinha[5], arrayLinha[6]);
            }
            primeiraIteracao = false;
    }

    }
    
    private static ArrayList<String[]> gerarTabelinha() {
        ArrayList<String[]> listaFinal = new ArrayList<String[]>();

        try {
            FileReader leitor = new FileReader(arquivo);
            BufferedReader buffLeitor = new BufferedReader(leitor);
            String linha;
            
            while ((linha = buffLeitor.readLine()) != null) {
                String[] arrayLinha = linha.split(",");
                listaFinal.add(arrayLinha);
            }
            
            buffLeitor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaFinal;
    }

    private static void alterador(int coluna, String valorOriginal, String alteracao) {
        try {
    
            // Alterar os Dados na Tabela
            for (String[] linhas : tabela) {
                if (linhas[coluna].contains(valorOriginal)) {
                    linhas[coluna] = linhas[coluna].replace(valorOriginal, alteracao);
                }
            }
    
            // Escrever o Novo Conteúdo no Arquivo Temporário
            File arquivoTemporario = new File("temporario.txt");
            FileWriter escritor = new FileWriter(arquivoTemporario);
            BufferedWriter buffEscritor = new BufferedWriter(escritor);
    
            for (String[] linhas : tabela) {
                buffEscritor.write(String.join(",", linhas));
                buffEscritor.newLine();
            }
    
            buffEscritor.close();
    
            // Substituir o Arquivo Original pelo Novo Arquivo Temporário
            Files.move(arquivoTemporario.toPath(), Paths.get(arquivo), StandardCopyOption.REPLACE_EXISTING);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void adicionar() {
        try (BufferedWriter buffEscritor = new BufferedWriter(new FileWriter(arquivo, true))) {
            String linha = "1,101,true,Mathias,Jefferson/Mae dele,21880900528,jeffinbotafogo@gmail.com";
            buffEscritor.write(linha);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}