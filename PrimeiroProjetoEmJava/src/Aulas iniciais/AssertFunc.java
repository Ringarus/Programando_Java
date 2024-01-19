
public class AssertFunc {
    // assert serve para verificar uma condição e lançar uma exceção caso seja falsa
    // útil pra depuração mas não aparece no terminal a menos que -ea esteja habilitado
    // Dica: compile o arquivo com javac e depois ao invês de abrir com java arquivo use java -ea arquivo

        public static void main(String[] args) {
            int numero = -5;
            assert (numero >= 0) : "Número não pode ser negativo";
            System.out.println("O programa continua...");
        }

    
}
