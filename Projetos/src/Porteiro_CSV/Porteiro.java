package Porteiro_CSV;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Porteiro {

    public static void main(String[] args) {
        boolean endProcess = true;
        int resposta;
        String[] respostasMenuGeral = {"1","2","3","4","5","6","e"};
        String[] respostasSubmenus = {"1","2","b"};
        do {
            resposta = verificar(1, respostasMenuGeral);
            if (resposta==-1) break;
            int subResposta;
            subResposta = verificar(resposta, respostasSubmenus);
            switch (resposta) {
            case -1:
                continue;
            case 1:
                if (subResposta==1) {
                    Interno.Ordenar(true);
                } else {
                    Interno.exibirTabelaFormatada(Interno.gerarTabelaCompleta(),true);
                }
                break;
        
            case 2:
                if (subResposta==1) {
                    Scanner scan = new Scanner(System.in);           
                    System.out.printf("Digite o número do andar: ");   
                    resposta = scan.nextInt();   
                    Interno.exibirTabelaFormatada(Interno.pesquisar(resposta));
                    System.out.println("Digite E para sair ou insira outra letra para nova atividade: ");
                    String exit = scan.nextLine();
                    if (exit.equalsIgnoreCase("E")) {
                        endProcess = false;
                    }
                    scan.close();
                    
                } else {
                    Interno.exibirTabelaFormatada(Interno.gerarTabelaCompleta(),true);
                }
                break;
            case 3:
                if (subResposta==1) {
                    Interno.Ordenar(true);
                } else {
                    Interno.exibirTabelaFormatada(Interno.gerarTabelaCompleta(),true);
                }
                break;
            case 4:
                verificar(resposta, respostasSubmenus);
                break;
            case 5:
                verificar(resposta, respostasSubmenus);
                break;
            case 6:
                verificar(resposta, respostasSubmenus);
                break;  
            default:
                break;
            }

        } while (endProcess);

    //
        System.err.println("Obrigado por utilizar o sistema");
    }

    private static void exibirMenu(int tipoMenu) {
        switch (tipoMenu) {
            case 0:
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║ Bem-vindo ao sistema de portaria     ║");
            System.out.println("║ Qual serviço deseja acessar?         ║");
            System.out.println("║                                      ║");
            System.out.println("║ (1) Ver tabela de informações        ║");
            System.out.println("║ (2) Pesquisar                        ║");
            System.out.println("║ (3) Adicionar novo registro          ║");
            System.out.println("║ (4) Alterar dados                    ║");
            System.out.println("║ (5) Remover registro                 ║");
            System.out.println("║ (6) Atualizar registros com erro     ║");
            System.out.println("║═══════════╔══════════════════════════╝");
            System.out.println("║ (e)sair   ║");
            System.out.println("╚═══════════╝");                  
                break;
            case 1:
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║                                      ║");
            System.out.println("║ Qual tipo de tabela gostaria de ver? ║");
            System.out.println("║                                      ║");
            System.out.println("║ (1) Tabela completa ordenada         ║");
            System.out.println("║ (2) Ver apenas apartamentos vazios   ║");
            System.out.println("║                                      ║");
            System.out.println("║═══════════╔══════════════════════════╝");
            System.out.println("║ (b)voltar ║");
            System.out.println("╚═══════════╝");                
                break;
            case 2:
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║                                      ║");
            System.out.println("║ Realizar pesquisa por:               ║");
            System.out.println("║                                      ║");
            System.out.println("║ (1) Número de andar                  ║");
            System.out.println("║ (2) Número do apartamento            ║");
            System.out.println("║                                      ║");
            System.out.println("║═══════════╔══════════════════════════╝");
            System.out.println("║ (b)voltar ║");
            System.out.println("╚═══════════╝");                
                break;
            case 3:
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║                                      ║");
            System.out.println("║ Adicionar novo registro:             ║");
            System.out.println("║                                      ║");
            System.out.println("║ (1) Registro completo                ║");
            System.out.println("║ (2) Registro de locação              ║");
            System.out.println("║                                      ║");
            System.out.println("║═══════════╔══════════════════════════╝");
            System.out.println("║ (b)voltar ║");
            System.out.println("╚═══════════╝");                
                break;
            case 4:
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║                                      ║");
            System.out.println("║ Como deseja alterar os dados?        ║");
            System.out.println("║                                      ║");
            System.out.println("║ (1) Ocorrência única                 ║");
            System.out.println("║ (2) Múltiplas ocorrências            ║");
            System.out.println("║                                      ║");
            System.out.println("║═══════════╔══════════════════════════╝");
            System.out.println("║ (b)voltar ║");
            System.out.println("╚═══════════╝");
                break;
            case 5:
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║                                      ║");
            System.out.println("║ Remover registros por qual método?   ║");
            System.out.println("║                                      ║");
            System.out.println("║ (1) Múltiplas ocorrências            ║");
            System.out.println("║ (2) Ocorrência única                 ║");
            System.out.println("║                                      ║");
            System.out.println("║═══════════╔══════════════════════════╝");
            System.out.println("║ (b)voltar ║");
            System.out.println("╚═══════════╝");
                break;
            case 6:
            System.out.println("╔══════════════════════════════════════╗     ╔══════════════════════════════════════╗");
            System.out.println("║                                      ║     ║ *** Para entender melhor ***         ║");
            System.out.println("║ Qual tipo de atualização deseja:     ║     ║                                      ║");
            System.out.println("║                                      ║     ║ (1) Havendo apartamentos vazios o    ║");
            System.out.println("║ (1) Atualizar por ocupação do apt.   ║     ║ sistema irá limpar o registro dos    ║");
            System.out.println("║ (2) Atualizar por moradores do apt.  ║     ║ antigos moradores. Caso o ap. esteja ║");
            System.out.println("║                                      ║     ║ ocupado e sem moradores, será pedido ║");
            System.out.println("║═══════════╔══════════════════════════╝     ║ o nome dos novos moradores.          ║");
            System.out.println("║ (b)voltar ║                                ║                                      ║");
            System.out.println("╚═══════════╝                                ║ (2) Se houver moradores, muda o apt. ║");                
            System.out.println("                                             ║ para ocupado. Não havendo moradores  ║");
            System.out.println("                                             ║ muda o status para vazio.            ║");
            System.out.println("                                             ╚══════════════════════════════════════╝");

            break;
            default:
                break;
        }

    }

    private static boolean estaNoArray(String[] array, String valor) {
        for (String elemento : array) {
            if (elemento.equals(valor)) {
                return true; // Encontrou o valor no array
            }
        }
        return false; // Valor não encontrado no array
    }

    private static void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void aguardar(long milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int verificar(int tipoDoMenu,String[] opcoes){
        String resposta;
        boolean respostaErrada = true;
        do {
            Scanner scanner = new Scanner(System.in);
            exibirMenu(tipoDoMenu);
            System.out.print("Sua opção: ");
            resposta = scanner.nextLine();
            if (resposta.equals("b") || resposta.equals("e")) {
                scanner.close();
                return -1;
            }
            if (!estaNoArray(opcoes, resposta)) {
            System.out.println("Digite uma opção válida por favor\n\n");
            aguardar(2000);
            limparTela();
            } else{
            respostaErrada = false;
            scanner.close();
            }
        } while (respostaErrada);
        limparTela();
        //Posso ter problemas aqui futuramente
        return Integer.valueOf(resposta);
    }

    static int adicionarRegistro(){
        Scanner scan = new Scanner(System.in);
        Integer resposta;
        boolean endOfProcess = false;
        ArrayList<String[]> listaVerificar = Interno.gerarTabelaCompleta();

        do {
            Interno.exibirTabelaFormatada(Interno.gerarTabelaCompleta(),true);
            System.out.println("POR FAVOR ESCOLHA O APARTAMENTO QUE DESEJA HABITAR:");
            resposta = scan.nextInt();
            for (String[] elementos : listaVerificar) {
                if (elementos[1].equals(resposta.toString())){
                    if (elementos[2].equalsIgnoreCase("Vazio")) {
                        String[] novoRegistro = registrar();
                        String proprietario = novoRegistro[0];
                        String moradores = novoRegistro[1];
                        String telefone = novoRegistro[2];
                        String email = novoRegistro[3];


                        endOfProcess = true;
                    } else {
                        System.out.println("Por favor insira um apartamento válido!");
                        aguardar(1000);
                        limparTela(); 
                        break;
                }
                }
            
            }
        } while (!endOfProcess);

        scan.close();

    }

    private static void peqAlterar(){
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

    /**
     * Finalmente aprendi a adicionar uma descrição aos métodos
     */
    private static String[] registrar(){
        Scanner scan = new Scanner(System.in);
        String[] registro = {};
        boolean verificado = false;
        String resposta;
        do {
            System.out.print("Insira o nome do proprietário:");
            resposta = scan.nextLine();
            if (resposta.length()> 11) {
                System.out.println("Por favor insira um nome de registro de até 11 caracteres");
                aguardar(1000);
                limparTela();
            } else {
                verificado = true;
                registro[0] = resposta;
            }
        } while (!verificado);
        verificado = false;
        do {
            System.out.print("Insira o nome dos moradores separados por '/': ");
            resposta = scan.nextLine();
            if (resposta.length()> 25) {
                System.out.println("Por favor insira os nomes de registro de até 25 caracteres");
                aguardar(1000);
                limparTela();
            } else {
                verificado = true;
                registro[1] = resposta;
            }
        } while (!verificado);
        verificado = false;
        do {
            System.out.print("Insira o telefone de contato: ");
            resposta = scan.nextLine();
            if (resposta.length()> 15) {
                System.out.println("Por favor insira um telefone de registro de até 15 caracteres");
                aguardar(1000);
                limparTela();
            } else {
                verificado = true;
                registro[2] = resposta;
            }
        } while (!verificado);
        verificado = false;
        do {
            System.out.print("Insira um email para contato: ");
            resposta = scan.nextLine();
            if (resposta.length()> 30) {
                System.out.println("Por favor insira um email de registro de até 30 caracteres");
                aguardar(1000);
                limparTela();
            } else {
                verificado = true;
                registro[3] = resposta;
            }
        } while (!verificado);
        verificado = false;


        scan.close();
        return registro;
    }

}
