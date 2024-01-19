package Basico;
/**
 * TryCatchFinally
 */
public class TryCatchFinally {
    /*
     * O try serve pra executar um bloco que pode vir a gerar uma exceção
     * O catch pega esse erro e o trata
     * O finally executa com ou sem exceção, ou seja, sempre
     */
    public static void main(String[] args) {
        try {
            // Bloco de código que pode gerar uma exceção]
            // Aqui deve ser criado um ZeroDivisionError
            int resultado = 0;
            int doidera = 1;
            resultado = doidera / resultado;
        } catch (ArithmeticException e) {
            // Trata a exceção
            System.out.println("Erro aritmético: " + e.getMessage());
        } finally {
            // Bloco de código que será executado sempre, ocorrendo ou não uma exceção
            System.out.println("Bloco finally");
        }
        
    }
}