package Porteiro_CSV;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class Admer {
    final static String arquivo = "C:\\Users\\Valério\\Documents\\Java_Project\\Programando_Java\\Projetos\\src\\Porteiro_CSV\\predio.txt";
    //static ArrayList<String[]> tabelaOriginal = gerarTabelinha();
    //static ArrayList<String[]> tabelaAtual = new ArrayList<>(tabelaOriginal);

    public static void main(String[] args) {
        adicionar();
        exibirTabelaFormatada();
    }

    

    public static void exibirTabelaFormatada() {
        ArrayList<String[]> tabelaExibir = gerarTabelinha();
        System.out.println("    | Andar  | Apartamento | Ocupado | Proprietario  |        Moradores          |    TelContato    |            Email               |");
        System.out.println("    |--------|-------------|---------|---------------|---------------------------|------------------|--------------------------------|");
        boolean primeiraIteracao = true;
        for (String[] arrayLinha : tabelaExibir) {
            if (!primeiraIteracao) {
                System.out.format("    | %-6s | %-11s | %-7s | %-13s | %-25s | %-16s | %-30s |\n", 
                                arrayLinha[0], arrayLinha[1], arrayLinha[2], arrayLinha[3], arrayLinha[4], arrayLinha[5], arrayLinha[6]);
            }
            primeiraIteracao = false;
        }
    }
    
    static ArrayList<String[]> gerarTabelinha() {
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

    private void alterador(int coluna, String valorOriginal, String alteracao) {
        
        ArrayList<String[]> tabelaAtual = new ArrayList<>(gerarTabelinha());

        try {
            // Alterar os Dados na Tabela
            for (String[] linhas : tabelaAtual) {
                if (linhas[coluna].contains(valorOriginal)) {
                    linhas[coluna] = linhas[coluna].replace(valorOriginal, alteracao);
                }
            }
    
            // Escrever o Novo Conteúdo no Arquivo Temporário
            File arquivoTemporario = new File("temporario.txt");
            FileWriter escritor = new FileWriter(arquivoTemporario);
            BufferedWriter buffEscritor = new BufferedWriter(escritor);
    
            for (String[] linhas : tabelaAtual) {
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
    
    static void adicionar() {
        try (BufferedWriter buffEscritor = new BufferedWriter(new FileWriter(arquivo, true))) {
            String linha = "1,101,true,Pacco,Jefferson/Mae dele,21880900528,jeffinbotafogo@gmail.com";
            buffEscritor.write(linha);
            buffEscritor.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void remover(int fullOrParcial, int coluna, String remocao) {
        
        try (BufferedWriter buffEscritor = new BufferedWriter(new FileWriter(arquivo, true))) {
            String linha = "1,101,true,Pacco,Jefferson/Mae dele,21880900528,jeffinbotafogo@gmail.com";
            buffEscritor.write(linha);
            buffEscritor.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
