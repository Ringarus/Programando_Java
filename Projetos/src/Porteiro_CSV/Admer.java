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

    static void alterador(int coluna, String valorOriginal, String alteracao) {
        
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
    
    static void remover(int fullOrParcial, int coluna, String remocao, String parametro) {
        //1 -> Remover o registro inteiro
        //2 -> Remover apenas o conteúdo da coluna
        //3 -> Remover a linha se o parâmetro fornecido for encontrado em qualquer coluna
        //4 -> Remover a coluna se o parâmetro fornecido for encontrado em qualquer coluna
        ArrayList<String[]> tabelaAtual = gerarTabelinha();

        try {
            // Escrever o Novo Conteúdo no Arquivo Temporário
            File arquivoTemporario = new File("temporario.txt");
            FileWriter escritor = new FileWriter(arquivoTemporario);
            BufferedWriter buffEscritor = new BufferedWriter(escritor);

            for (String[] linhas : tabelaAtual) {
                // Verifica se o conteúdo da coluna é igual ao que desejamos remover
                if (linhas[coluna].equals(remocao)) {
                    if (fullOrParcial == 1) {
                        // Remover o registro inteiro
                        continue; // Pula para a próxima iteração sem escrever a linha
                    } else if (fullOrParcial == 2) {
                        // Remover apenas o conteúdo da coluna
                        linhas[coluna] = "null"; // ou null, dependendo da necessidade
                    } else if (fullOrParcial == 3) {
                        // Remover a linha se o parâmetro fornecido for encontrado em qualquer coluna
                        boolean parametroEncontrado = false;
                        for (String valorColuna : linhas) {
                            if (valorColuna.equals(parametro)) {
                                parametroEncontrado = true;
                                break; // Parar a busca se encontrar o parâmetro em qualquer coluna
                            }
                        }
                        if (parametroEncontrado) {
                            continue; // Pula para a próxima iteração sem escrever a linha
                        }
                    } else if (fullOrParcial == 4) {
                        // Remover a coluna se o parâmetro fornecido for encontrado em qualquer coluna
                        boolean parametroEncontrado = false;
                        for (String valorColuna : linhas) {
                            if (valorColuna.equals(parametro)) {
                                parametroEncontrado = true;
                                break; // Parar a busca se encontrar o parâmetro em qualquer coluna
                            }
                        }
                        if (parametroEncontrado) {
                            linhas[coluna] = "null"; // ou null, dependendo da necessidade
                        }
                    }
                    
                    
                }

                // Escrever a linha no arquivo temporário
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

}
