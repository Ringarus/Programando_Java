//Definindo imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

//Definindo classe
public class ManipuladorArquivo {
    //Tornando nomeArquivo um atributo privado
    private String nomeArquivo;

    //Criando o Constructor
    public ManipuladorArquivo(String nomeArquivo) {
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
    public void alterarArquivo(String cpfAlvo){
        try (RandomAccessFile arquivo = new RandomAccessFile(nomeArquivo, "rw")) {
            String linha;
            long posicaoInicioLinha = 0;
            while ((linha = arquivo.readLine()) != null) {
                String[] temp = linha.split(",");
                //Verificando se o cpf alvo é o cpf lido
                if (temp[1].equals(cpfAlvo)) {
                    //INSERIR VERIFICAÇÃO POR SENHA
                    Scanner scan = new Scanner(System.in);
                    boolean acesso=false;
                    System.out.printf("Insira a senha da conta de cpf %s\nSenha:",temp[1]);
                    String senha = scan.nextLine();
                    acesso = (senha.equals(temp[3]))?true:false;
                    //Requisitar qual a mudança que será feita
                    if(acesso==true){
                        System.err.println("(1) Alterar nome\n"+
                                            "(2) Alterar CPF\n" + 
                                            "(3) Alterar idade\n" + 
                                            "(4) Alterar senha\n");
                        System.out.print("Opção: ");
                        String opt = scan.nextLine();
                        String novo;
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
                    } else{
                        System.err.println("ACESSO NEGADO!");
                    }
                    //Fechando scanner
                    scan.close();
                    //Alterar dentro do array o
                    String novaLinha = String.join(",", temp);
                    // Modificar a linha conforme necessário
                    String linhaModificada = preencherEspacos(novaLinha, 99);
                    arquivo.seek(posicaoInicioLinha);
                    arquivo.writeBytes(linhaModificada);
                    // A linha foi encontrada e modificada, podemos sair do loop
                    break;
                }
                posicaoInicioLinha = arquivo.getFilePointer();  // Salvar a posição do início da próxima linha
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
