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
        limparTela();
        Scanner scanner = new Scanner(System.in);
        boolean finalizar = false;
        String[] respostasMenuGeral = {"1","2","3","4","5","6","e"};
        String[] respostasSubmenus = {"1","2","b"};
        ArrayList<String[]> tabela = Interno.gerarTabelaCompleta();
        do {
            int resposta = verificar(0, respostasMenuGeral, scanner);
            if (resposta==-1) break;
            int subResposta = verificar(resposta, respostasSubmenus, scanner);
            switch (resposta) {
            case -1:
                continue;
            case 1:
                if (subResposta==1) {
                    Interno.exibirTabelaFormatada(tabela);
                } else {
                    Interno.exibirTabelaFormatada(tabela,true);
                }
                break;
        
            case 2:
                if (subResposta==1) {
                    Scanner scan = new Scanner(System.in);           
                    System.out.printf("Digite o número do andar: ");   
                    resposta = scan.nextInt();   
                    Interno.exibirTabelaFormatada(Interno.pesquisar(resposta),false);
                    System.out.println("Digite E para sair ou insira outra letra para nova atividade: ");
                    String exit = scan.nextLine();
                    if (exit.equalsIgnoreCase("E")) {
                        finalizar = false;
                    }
                    scan.close();
                    
                } else {
                    Interno.exibirTabelaFormatada(Interno.gerarTabelaCompleta(),true);
                }
                break;
            case 3:
                if (subResposta==1) {
                    adicionarRegistro(true);
                    if (back()) {
                        finalizar = true;
                    }
                } else {
                    adicionarRegistro(false);
                    if (back()) {
                        finalizar = true;
                    }
                }
                break;
            case 4:
                if (subResposta==1) {
                    atualizarDados(false);
                    if (back()) {
                        finalizar = true;
                    }
                } else {
                    atualizarDados(true);
                    if (back()) {
                        finalizar = true;
                    }
                }
                break;
            case 5:
                break;
            case 6:
                if (subResposta==1) {
                    Interno.atualizarOcupacao();
                    if (back()) {
                        finalizar = true;
                    }
                } else {
                    Interno.atualizarMoradores();
                    if (back()) {
                        finalizar = true;
                    }
                }
                break;  
            default:
                break;
            }
        } while (!finalizar);
        scanner.close();

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

    /*
    static int verificar(int tipoDoMenu,String[] opcoes){
        String resposta;
        boolean respostaErrada = true;
        Scanner scanner = new Scanner(System.in);
        do {
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
            }
        } while (respostaErrada);
        scanner.close();

        limparTela();
        //Posso ter problemas aqui futuramente
        return Integer.valueOf(resposta);
    }
    */

    static int verificar(int tipoDoMenu, String[] opcoes, Scanner scanner) {
        String answer = "";
        boolean respostaErrada = true;
    
        do {
            exibirMenu(tipoDoMenu);
            System.out.print("Sua opção: ");
            String resposta = scanner.nextLine().trim().toUpperCase();
    
            if (resposta.equalsIgnoreCase("B") || resposta.equalsIgnoreCase("E")) {
                answer = resposta;
                respostaErrada = false;
                return -1;
            } else if (!estaNoArray(opcoes, resposta)) {
                System.out.println("Digite uma opção válida por favor\n\n");
                aguardar(2000);
                limparTela();
            } else {
                respostaErrada = false;
                answer = resposta;
            }
        } while (respostaErrada);
    
        limparTela();
    
        // Convertendo a resposta para Integer
        try {
            return Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            // Lidar com a exceção se a entrada não for um número
            e.printStackTrace();
            return -1;
        }
    }  
    
    static void adicionarRegistro(boolean regCompleto){
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
                        String[] novoRegistro = registrar(regCompleto);
                        peqAlterar(novoRegistro, listaVerificar, resposta.toString());
                        System.out.println("Processo de registro concluído");
                        aguardar(500);
                        endOfProcess = true;
                    } else {
                        System.out.println("Por favor insira um apartamento válido!");
                        aguardar(800);
                        limparTela(); 
                        break;
                }
                }
            
            }
        } while (!endOfProcess);

        scan.close();

    }

    private static void peqAlterar(String[] registro, ArrayList<String[]> lista, String apartamento){
        String arquivo = Interno.arquivo;
        int option = registro.length;
        try {
            File arquivoTemporario = new File("temporario.txt");
            FileWriter escritor = new FileWriter(arquivoTemporario);
            BufferedWriter buffEscritor = new BufferedWriter(escritor);
            if (option==4) {
                for (String[] linhas : lista) {
                    if (linhas[1].contains(apartamento)) {
                        linhas[2] = "Ocupado";
                        linhas[3] = registro[0];
                        linhas[4] = registro[1];
                        linhas[5] = registro[2];
                        linhas[6] = registro[3];
                    }
                buffEscritor.write(String.join(",", linhas));
                buffEscritor.newLine();
                }
            }
            else if (option==2) {
                for (String[] linhas : lista) {
                    if (linhas[1].contains(apartamento)) {
                        linhas[2] = "Ocupado";
                        linhas[3] = registro[0];
                        linhas[4] = registro[1];
                        linhas[5] = "null";
                        linhas[6] = "null";
                    }
                    buffEscritor.write(String.join(",", linhas));
                    buffEscritor.newLine();
                }
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
    private static String[] registrar(boolean completo){
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
        if (completo==false) {
            scan.close();
            return registro;  
        }
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

    private static boolean back(){
        Scanner scan = new Scanner(System.in);           
        System.out.println("Digite E para sair ou B para realizar uma nova operacao: ");
        String exit = scan.nextLine();
        if (exit.equalsIgnoreCase("E")) {
            scan.close();
            return false;
        } else if (exit.equalsIgnoreCase("B")) {
            scan.close();
            return true;
        } else {
            scan.close();
            return true;
        }
    }

    private static void atualizarDados(boolean isMultiple){
        String[] opcoes = {"1","2","3","4","b"};
        String resposta;
        boolean respostaErrada = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║                                      ║");
            System.out.println("║ O que deseja alterar?                ║");
            System.out.println("║                                      ║");
            System.out.println("║ (1) Nome do proprietário             ║");
            System.out.println("║ (2) Moradores                        ║");
            System.out.println("║ (3) Telefone de contato              ║");
            System.out.println("║ (4) Email de contato                 ║");
            System.out.println("║                                      ║");
            System.out.println("║═══════════╔══════════════════════════╝");
            System.out.println("║ (e)sair   ║");
            System.out.println("╚═══════════╝");      
            System.out.print("Sua opção: ");
            resposta = scanner.nextLine();
            if (resposta.equals("b") || resposta.equals("e")) {
                scanner.close();
                return;
            }
            if (!estaNoArray(opcoes, resposta)) {
            System.out.println("Digite uma opção válida por favor\n\n");
            aguardar(2000);
            limparTela();
            } else{
            respostaErrada = false;
            }
        } while (respostaErrada);
        limparTela();
        Integer apartamento =0;
        if (!isMultiple) {
            System.out.print("Digite o número do apartamento que deseja alterar os dados: ");
            apartamento = scanner.nextInt();
        }

        
        switch (resposta) {
            case "1":
            if (!isMultiple) {
                System.out.print("Digite o nome do novo proprietário: ");
                resposta = scanner.nextLine();
                Interno.alteradorParametro(3, resposta, apartamento.toString());
            } else {
                System.out.print("Digite o nome do antigo proprietário: ");
                String antigo = scanner.nextLine();
                System.out.print("Digite o nome do novo proprietário: ");
                String novo = scanner.nextLine();
                Interno.alterador(3, antigo, novo, true);
            }
                break;
            case "2":
            if (!isMultiple) {
                System.out.print("Digite o nome dos novos moradores separados por '/': ");
                resposta = scanner.nextLine();
                Interno.alteradorParametro(4, resposta, apartamento.toString());
            } else {
                System.out.print("Digite o nome dos antigos moradores separados por '/': ");
                String antigo = scanner.nextLine();
                System.out.print("Digite o nome dos novos moradores separados por '/': ");
                String novo = scanner.nextLine();
                Interno.alterador(4, antigo, novo, true);
            }
                break;
            case "3":
            if (!isMultiple) {
                System.out.print("Digite o novo telefone de contato: ");
                resposta = scanner.nextLine();
                Interno.alteradorParametro(5, resposta, apartamento.toString());
            } else {
                System.out.print("Digite o antigo telefone de contato: ");
                String antigo = scanner.nextLine();
                System.out.print("Digite o novo telefone de contato: ");
                String novo = scanner.nextLine();
                Interno.alterador(5, antigo, novo, true);
            }
                break;
            case "4":
            if (!isMultiple) {
                System.out.print("Digite o novo email de contato: ");
                resposta = scanner.nextLine();
                Interno.alteradorParametro(6, resposta, apartamento.toString());
            } else {
                System.out.print("Digite o antigo email de contato: ");
                String antigo = scanner.nextLine();
                System.out.print("Digite o novo email de contato: ");
                String novo = scanner.nextLine();
                Interno.alterador(6, antigo, novo, true);
            }
                break;    
            default:
                break;
        }
        scanner.close();

    }

}
