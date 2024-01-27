package Banco_Digital;
//Definindo imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

//Definindo classe
public class Banking {
    //Tornando nomeArquivo um atributo privado
    private String nomeArquivo;

    //Criando o Constructor
    public Banking(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    //Método de instância para ler o arquivo -> Aqui é dado opção de procurar por CPF
    public String lerArquivo() throws IOException {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        }
        return conteudo.toString();
    }

    //Método de instância para escrever no arquivo -> Aqui verificamos duplicidade de CPF
    public void escreverArquivo(String Nome, String CPF, String Idade, String Senha) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo,true))) {
            String[] temp = {Nome,CPF,Idade,Senha,"0.00","9","3"};
            String conteudo = String.join(",", temp);
            conteudo = preencherEspacos(conteudo, 99);
            bw.write(conteudo);
        }
    }

    //Método para alterar algo no txt -> Aqui pedimos verificação de senha
    public String alterarArquivo(String cpfAlvo, int operation, Double saldo){
        boolean findedCpf = false;
        //operation 0 para alterar, 1 para escolha de saque,dep e transf e 2 para transferencia
        try (RandomAccessFile arquivo = new RandomAccessFile(nomeArquivo, "rw")) {
            String linha;
            long posicaoInicioLinha = 0;
            while ((linha = arquivo.readLine()) != null) {
                
                String[] temp = linha.split(",");
                String[] destRemet = cpfAlvo.split("-");
                
                //Verificando se o cpf alvo é o cpf lido
                if (temp[1].equals(cpfAlvo) || temp[1].equals(destRemet[0])) {
                    String papaco=temp[4];
                    String novo;
                    String opt;
                    Scanner scan = new Scanner(System.in);
                    boolean acesso=false;
                    //Retira saldo da conta do remetente
                    if (operation == 3) {
                            Double novoSaldo = Double.parseDouble(temp[4]) - saldo;
                            temp[4] = Double.toString(novoSaldo);
                        }
                    //OPCAO PARA TRANSFERENCIA
                    if (operation==2 && saldo>=0) {
                        Double valorTransf;
                        System.out.printf("Deseja transferir para o CPF %s ?\n(1)SIM\n(2)NÃO\nResposta: ",destRemet[0]);
                        opt = scan.nextLine();
                        if(opt.equals("1")){
                            do {
                                System.out.print("INSIRA O VALOR PARA TRANSFERÊNCIA: ");
                                opt = scan.nextLine();
                                opt = opt.replace(",", ".");
                                valorTransf = Double.parseDouble(opt);
                            } while (valorTransf>saldo);
                            //Chama a retirada do saldo do remetente
                            Double novoSaldo = Double.parseDouble(temp[4]) + Double.parseDouble(opt);
                            temp[4] = Double.toString(novoSaldo);
                            alterarArquivo(destRemet[1], 3, valorTransf);
                        } else {
                            break;
                        }
                    }
                    //INSERIR VERIFICAÇÃO POR SENHA
                    if (operation==1){
                        System.out.printf("Insira a senha da conta de cpf %s\nSenha:",temp[1]);
                        String senha = scan.nextLine();
                        acesso = (senha.equals(temp[3]))?true:false;
                        //Caso a alteração seja para saque ou depósito
                        if (acesso==true && operation==1) {
                            System.err.println("(1) Saque\n"+
                                                "(2) Depósito\n" + 
                                                "(3) Transferência\n");
                            System.out.print("Opção: ");
                            opt = scan.nextLine();
                            Boolean validadeOperacao = false;
                            switch (opt) {
                                case "1":
                                do {
                                    System.out.print("Insira valor do saque: ");
                                    novo = scan.nextLine();
                                    novo = novo.replace(",", ".");
                                    validadeOperacao = (Double.parseDouble(novo)<=(Double.parseDouble(temp[4])))?true:false;
                                    if(validadeOperacao==false){
                                        System.out.println("Valor acima do saldo atual, por favor tente novamente.");
                                    }
                                } while (validadeOperacao==false);
                                temp[4] = novo;
                                    break;
                                case "2":
                                do {
                                    System.out.print("Insira o valor do depósito: ");
                                    novo = scan.nextLine();
                                    novo = novo.replace(",", ".");
                                    validadeOperacao = (Double.parseDouble(novo)<=(100000000.00 - Double.parseDouble(temp[4])))?true:false;
                                    if(validadeOperacao==false){
                                        System.out.println("Valor excede o limite de saldo da conta (1 milhão)");
                                    }
                                } while (validadeOperacao==false);
                                Double nSaldo = Double.parseDouble(novo)+Double.parseDouble(temp[4]);
                                temp[4] = Double.toString(nSaldo);
                                    break;
                                case "3":
                                System.out.print("Insira o CPF do destinatário: ");
                                novo = scan.nextLine();
                                String concac = novo+"-"+temp[1];
                                papaco = alterarArquivo(concac, 2, Double.parseDouble(temp[4]));
                                    break;
                                default:
                                    break;
                            }
                        } 
                        else if(acesso==true && operation==0){
                            System.err.println("(1) Alterar nome\n"+
                                                "(2) Alterar CPF\n" + 
                                                "(3) Alterar idade\n" + 
                                                "(4) Alterar senha\n");
                            System.out.print("Opção: ");
                            opt = scan.nextLine();
                            switch (opt) {
                                case "1":
                                System.out.print("Insira o novo NOME: ");
                                novo = scan.nextLine();
                                temp[0] = novo;
                                    break;
                                case "2":
                                System.out.print("Insira o novo CPF: ");
                                novo = scan.nextLine();
                                temp[1] = novo;
                                    break;
                                case "3":
                                System.out.print("Insira a nova IDADE: ");
                                novo = scan.nextLine();
                                temp[2] = novo;
                                    break;
                                case "4":
                                System.out.print("Insira a nova SENHA: ");
                                novo = scan.nextLine();
                                temp[3] = novo;
                                    break;

                                default:
                                    break;
                            }
                        } 
                        else{
                            System.err.println("ACESSO NEGADO!");
                        }
                    }
                    if (papaco.equals("") && operation == 1){
                        break;
                    }
                    //Fechando scanner
                    scan.close();
                    String novaLinha = String.join(",", temp);
                    // Modificar a linha conforme necessário
                    String linhaModificada = preencherEspacos(novaLinha, 99);
                    arquivo.seek(posicaoInicioLinha);
                    arquivo.writeBytes(linhaModificada);
                    // A linha foi encontrada e modificada, podemos sair do loop
                    break;
                } else {
                    findedCpf = true;
                }
                posicaoInicioLinha = arquivo.getFilePointer();  // Salvar a posição do início da próxima linha
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (findedCpf==false) {
            System.out.println("CPF não encontrado");
        }
        return "";
    }
    
    //Método para preencher a linha com um comprimento máximo e evitar erros de sobrescrita
    private String preencherEspacos(String texto, int comprimentoMaximo) {
        //Por padrão estou usando 99 de comprimento maximo
        if (texto.length() < comprimentoMaximo) {
            int espacosRestantes = comprimentoMaximo - texto.length();
            StringBuilder espacosBuilder = new StringBuilder();
            for (int i = 0; i < espacosRestantes; i++) {
                espacosBuilder.append(" ");
            }
            return texto + espacosBuilder.toString() + "\n";
        } else {
            return texto.substring(0, comprimentoMaximo);
        }
    }

}
