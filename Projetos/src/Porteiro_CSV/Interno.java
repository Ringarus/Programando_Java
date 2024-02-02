package Porteiro_CSV;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Interno {
    final static String arquivo = "C:\\Users\\valco\\Documents\\Programar\\Programando_Java\\Projetos\\src\\Porteiro_CSV\\predio.txt";
    
    private static void cabecalho(boolean apenasVazios){
        if (apenasVazios) {
            System.out.println("    --------------------------------------------------");
            System.out.println("    | Andar  | Apartamento |  Estado  | Proprietario  |");
            System.out.println("    --------------------------------------------------");
            } else{
            System.out.println("    ----------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("    | Andar  | Apartamento |  Estado  | Proprietario  |        Moradores          |    TelContato    |            Email               |");
            System.out.println("    ----------------------------------------------------------------------------------------------------------------------------------"); 
        }
    }

    public static void exibirTabelaFormatada(ArrayList<String[]> tabelaExibir, boolean mostrarApenasVazios) {
        cabecalho(mostrarApenasVazios);
        boolean primeiraIteracao = true;
        for (String[] arrayLinha : tabelaExibir) {
            if ((mostrarApenasVazios && arrayLinha[2].equals("Vazio"))&&(!primeiraIteracao && arrayLinha.length >= 7)) {
                    System.out.format("    | %-6s | %-11s | %-11s | %-13s |\n",arrayLinha[0], arrayLinha[1], arrayLinha[2], arrayLinha[3]);
            }
            else if ((!primeiraIteracao && arrayLinha.length >= 7) && !mostrarApenasVazios) {
                System.out.format("    | %-6s | %-11s | %-11s | %-13s | %-25s | %-16s | %-30s |\n",arrayLinha[0], arrayLinha[1], arrayLinha[2], arrayLinha[3], arrayLinha[4], arrayLinha[5], arrayLinha[6]);
            } 
            primeiraIteracao = false;
        }
        if (mostrarApenasVazios) {
            System.out.println("    --------------------------------------------------\n");
        } else {
            System.out.println("    ----------------------------------------------------------------------------------------------------------------------------------\n");
        }
    }

    public static void exibirTabelaFormatada(ArrayList<String[]> tabelaExibir) {
        cabecalho(false);
        boolean primeiraIteracao = true;
        for (String[] arrayLinha : tabelaExibir) {
            if (!primeiraIteracao && arrayLinha.length >= 7) {
                System.out.format("    | %-6s | %-11s | %-11s | %-13s | %-25s | %-16s | %-30s |\n",arrayLinha[0], arrayLinha[1], arrayLinha[2], arrayLinha[3], arrayLinha[4], arrayLinha[5], arrayLinha[6]);
            } 
            primeiraIteracao = false;
        }
            System.out.println("    ----------------------------------------------------------------------------------------------------------------------------------\n");
    }
    
    static ArrayList<String[]> gerarTabelaCompleta() {
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

    static ArrayList<String[]> pesquisar(String apartamento){
        ArrayList<String[]> listaFinal = new ArrayList<String[]>();
        try {
            FileReader leitor = new FileReader(arquivo);
            BufferedReader buffLeitor = new BufferedReader(leitor);
            String linha;
            boolean colunasBase = true;
            while ((linha = buffLeitor.readLine()) != null) {
                String[] arrayLinha = linha.split(",");
                if (arrayLinha[1].equals(apartamento)) {
                    listaFinal.add(arrayLinha);
                } else if(colunasBase) {
                    listaFinal.add(arrayLinha);
                    colunasBase = false;
                }
            }
            buffLeitor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaFinal;
    }

    static ArrayList<String[]> pesquisar(Integer andar){
        String numeroAndar = andar.toString();
        ArrayList<String[]> listaFinal = new ArrayList<String[]>();

        try {
            FileReader leitor = new FileReader(arquivo);
            BufferedReader buffLeitor = new BufferedReader(leitor);
            String linha;
            boolean colunasBase = true;
            while ((linha = buffLeitor.readLine()) != null) {
                String[] arrayLinha = linha.split(",");
                if (arrayLinha[0].equals(numeroAndar)) {
                    listaFinal.add(arrayLinha);
                } else if(colunasBase) {
                    listaFinal.add(arrayLinha);
                    colunasBase = false;
                }
            }
            buffLeitor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaFinal;
    }

    static void alterador(int coluna, String valorOriginal, String alteracao, boolean trocarTodasOcorrencias) {
        
        ArrayList<String[]> tabelaAtual = new ArrayList<>(gerarTabelaCompleta());

        try {
            // Escrever o Novo Conteúdo no Arquivo Temporário
            File arquivoTemporario = new File("temporario.txt");
            FileWriter escritor = new FileWriter(arquivoTemporario);
            BufferedWriter buffEscritor = new BufferedWriter(escritor);
            boolean trocaPendente = true;
            // Alterar os Dados na Tabela
            for (String[] linhas : tabelaAtual) {
                if (linhas[coluna].contains(valorOriginal) && trocarTodasOcorrencias) {
                    linhas[coluna] = linhas[coluna].replace(valorOriginal, alteracao);
                } else if (linhas[coluna].contains(valorOriginal) && !trocarTodasOcorrencias) {
                    if (trocaPendente) {
                        linhas[coluna] = linhas[coluna].replace(valorOriginal, alteracao);
                        trocaPendente = false;
                    }
                }
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
    
    static int adicionar(String Andar, String Apartamento, String Ocupado, String Proprietario, String Moradores, String Tel, String Email) {
        if(VerificarDuplicataApartamento(Andar, Apartamento)){
            try (BufferedWriter buffEscritor = new BufferedWriter(new FileWriter(arquivo, true))) {
                String linha;
                linha = Andar+","+Apartamento+","+Ocupado+","+Proprietario+","+Moradores+","+Tel+","+Email;
                buffEscritor.write(linha);
                buffEscritor.newLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        } else {
            System.out.println("Apartamento duplicado, por favor tente novamente");
            return 0;
        }
    }

    static int adicionar(String Andar, String Apartamento, String Ocupado, String Proprietario, String Moradores, String Tel) {
        if(VerificarDuplicataApartamento(Andar, Apartamento)){
            try (BufferedWriter buffEscritor = new BufferedWriter(new FileWriter(arquivo, true))) {
                String linha;
                linha = Andar+","+Apartamento+","+Ocupado+","+Proprietario+","+Moradores+","+Tel+"null";
                buffEscritor.write(linha);
                buffEscritor.newLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        } else {
            System.out.println("Apartamento duplicado, por favor tente novamente");
            return 0;
        }
    }

    static int adicionar(String Andar, String Apartamento, String Ocupado, String Proprietario) {
        if(VerificarDuplicataApartamento(Andar, Apartamento)){
            try (BufferedWriter buffEscritor = new BufferedWriter(new FileWriter(arquivo, true))) {
                String linha;
                linha = Andar+","+Apartamento+","+Ocupado+","+Proprietario+"null"+"null"+"null";
                buffEscritor.write(linha);
                buffEscritor.newLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        } else {
            System.out.println("Apartamento duplicado, por favor tente novamente");
            return 0;
        }
    }
    
    static void remover(int fullOrParcial, int coluna, String remocao, String parametro) {
        /*
         * Esse método tem 4 argumentos 
         * fullOrParcial = possui 4 modos apresentados abaixo.
         * coluna = é a coluna que buscamos remover, indo de acordo com o index da coluna
         * remocao = é a condição para removermos uma linha ou coluna
         * parametro = é uma segunda condição, funcionando como um WHERE
         */

        //1 -> Remover o registro inteiro (GENERALISTA O REGISTRO INTEIRO)
        //2 -> Remover apenas o conteúdo da coluna (GENERALISTA REMOVENDO APENAS COLUNA)
        //3 -> Remover a linha se o parâmetro fornecido for encontrado em qualquer coluna (ESPECIFICO REMOVENDO LINHA)
        //4 -> Remover a coluna se o parâmetro fornecido for encontrado em qualquer coluna (ESPECIFICO REMOVENDO COLUNA)
        ArrayList<String[]> tabelaAtual = gerarTabelaCompleta();

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

    private static boolean VerificarDuplicataApartamento(String andar, String apartamento) {
        try (BufferedReader ledor = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            String[] componentes;
            while ((linha = ledor.readLine()) != null) {
                componentes = linha.split(",");
                if (componentes[0].equals(andar) && componentes[1].equals(apartamento)) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    static void Ordenar(boolean ordenarPorApartamento){
        if (ordenarPorApartamento) {
            ArrayList<String[]> tabelaAtual = new ArrayList<>(gerarTabelaCompleta());
            tabelaAtual.sort(Comparator.comparing(array -> array[1]));
            exibirTabelaFormatada(tabelaAtual, false);
        }
        else {
            ArrayList<String[]> tabelaAtual = new ArrayList<>(gerarTabelaCompleta());
            tabelaAtual.sort(Comparator.comparing(array -> array[0]));
            exibirTabelaFormatada(tabelaAtual, false);
        }

    }

    static void atualizarMoradores() {
        ArrayList<String[]> tabelaAtual = new ArrayList<>(gerarTabelaCompleta());
    
        try {
            // Escrever o Novo Conteúdo no Arquivo Temporário
            File arquivoTemporario = new File("temporario.txt");
            FileWriter escritor = new FileWriter(arquivoTemporario);
            BufferedWriter buffEscritor = new BufferedWriter(escritor);
    
            Scanner scanner = new Scanner(System.in);
    
            // Alterar os Dados na Tabela
            for (String[] linhas : tabelaAtual) {
                if (linhas[2].contains("false")) {
                    linhas[4] = linhas[4].replace(linhas[4], "null");
                } else if (linhas[2].contains("true") && linhas[4].equals("null")) {
                    System.out.printf("Insira os moradores do apartamento %s separador por '/' : ", linhas[1]);
                    String moradores = scanner.nextLine();
                    if (moradores.contains(",")) {
                        moradores.replace(",", "/");
                    }
                    linhas[4] = moradores;
                }
                buffEscritor.write(String.join(",", linhas));
                buffEscritor.newLine();
            }
    
            scanner.close();
            buffEscritor.close();
    
            // Substituir o Arquivo Original pelo Novo Arquivo Temporário
            Files.move(arquivoTemporario.toPath(), Paths.get(arquivo), StandardCopyOption.REPLACE_EXISTING);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static void atualizarOcupacao() {
        ArrayList<String[]> tabelaAtual = new ArrayList<>(gerarTabelaCompleta());
    
        try {
            // Escrever o Novo Conteúdo no Arquivo Temporário
            File arquivoTemporario = new File("temporario.txt");
            FileWriter escritor = new FileWriter(arquivoTemporario);
            BufferedWriter buffEscritor = new BufferedWriter(escritor);
    
            // Alterar os Dados na Tabela
            for (String[] linhas : tabelaAtual) {
                if (linhas[4].contains("null")) {
                    linhas[2] = linhas[2].replace("true", "false");
                } else if (linhas[2].contains("false") && !linhas[4].contains("null")) {
                    linhas[2] = "true";
                }
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
