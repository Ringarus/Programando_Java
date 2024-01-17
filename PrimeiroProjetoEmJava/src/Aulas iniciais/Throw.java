public class Throw {
    

    public static void main(String[] args) {
        try {
            validarIdade(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void validarIdade(int idade) {
        if (idade < 18) {
            throw new IllegalArgumentException("Idade deve ser maior ou igual a 18");
        }

        System.out.println("Idade válida.");
    }

    
}
