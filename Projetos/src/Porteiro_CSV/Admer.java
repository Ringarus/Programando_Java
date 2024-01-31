package Porteiro_CSV;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class Admer {
    final static String arquivo = "C:\\Users\\Valério\\Documents\\Java_Project\\Programando_Java\\Projetos\\src\\Porteiro_CSV\\predio.txt";

    public static void exibirTabelaFormatada() {
        ArrayList<String[]> tabelaExibir = gerarTabelinha();
        System.out.println("    ----------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("    | Andar  | Apartamento | Ocupado | Proprietario  |        Moradores          |    TelContato    |            Email               |");
        System.out.println("    ----------------------------------------------------------------------------------------------------------------------------------");
        boolean primeiraIteracao = true;
        for (String[] arrayLinha : tabelaExibir) {
            if (!primeiraIteracao && arrayLinha.length >= 7) {
                System.out.format("    | %-6s | %-11s | %-7s | %-13s | %-25s | %-16s | %-30s |\n",arrayLinha[0], arrayLinha[1], arrayLinha[2], arrayLinha[3], arrayLinha[4], arrayLinha[5], arrayLinha[6]);
            }
            primeiraIteracao = false;
        }
        System.out.println("    ----------------------------------------------------------------------------------------------------------------------------------\n");
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

    static int adicionar(String Andar, String Apartamento, String Ocupado, String Proprietario, String Moradores) {
        if(VerificarDuplicataApartamento(Andar, Apartamento)){
            try (BufferedWriter buffEscritor = new BufferedWriter(new FileWriter(arquivo, true))) {
                String linha;
                linha = Andar+","+Apartamento+","+Ocupado+","+Proprietario+","+Moradores+"null"+"null";
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

    private static boolean VerificarDuplicataApartamento(String andar, String apartamento) {
        try {
            FileReader ler = new FileReader(arquivo);
            BufferedReader ledor = new BufferedReader(ler);
            String linha;
            String[] componentes;
            while ((linha = ledor.readLine()) != null) {
                componentes = linha.split(",");
                if (componentes[0].equals(andar) && componentes[1].equals(apartamento)) {
                    return false;
                } 
            }
            ler.close();
            ledor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
