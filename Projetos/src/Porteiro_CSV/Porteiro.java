package Porteiro_CSV;

import java.util.Scanner;

public class Porteiro {

    public static void main(String[] args) {
        boolean endProcess = true;
        do {

            Scanner scanner = new Scanner(System.in);
            //BUSCA UMA RESPOSTA DO USUARIO E CHECA SE É VALIDA
            int resposta;
            int[] possiveisRespostas = {1,2,3,4,5,6};
            boolean respostaErrada = true;
            
            do {
                //EXIBE O MENU
                exibirMenu(1);
                System.out.print("Sua opção: ");
                resposta = scanner.nextInt();
                if (!inteiroNoArray(possiveisRespostas, resposta)) {
                System.out.println("Digite uma opção válida por favor\n\n");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                limparTela();
                } else{
                respostaErrada = false;
                scanner.close();
                }
            } while (respostaErrada);
            
            switch (resposta) {
            case 1:
                
                break;
        
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;  
            default:
                break;
            }
        } while (endProcess);

    //

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
            System.out.println("║ (1) Tabela completa sem ordenação    ║");
            System.out.println("║ (2) Tabela completa ordenada         ║");
            System.out.println("║ (3) Ver apenas apartamentos vazios   ║");
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

    private static boolean inteiroNoArray(int[] array, int valor) {
        for (int elemento : array) {
            if (elemento == valor) {
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

}
