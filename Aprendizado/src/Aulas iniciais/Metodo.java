
public class Metodo {
    public static void main(String[] args) {

        //Chamada de método de classe
        int soma = SomarLados.calcula(1,2);
        
        // Chamada de método de instância
        Retangulo retangulo = new Retangulo(3, 4);
        double areaRetangulo = retangulo.calcularArea();
        System.out.println("Área do retângulo: " + areaRetangulo);
        dizerOi("Fernanda");
        System.out.printf("A soma dos lados vale:%d",soma);
    }

    //Método normal
    static void dizerOi(String nome){
        System.out.println("Olá "+ nome);
    }

    //método recursivo



  
    
}
  
//Método de classe x Método de instância

    // Método de classe
class SomarLados {
    // Método de classe (estático) para calcular a soma de dois lados
    static int calcula(int lado1,int lado2) {
        return lado1+lado2;
    }
}

// Método de instância

class Retangulo {
    double comprimento;
    double largura;

    // Construtor
    Retangulo(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    // Método de instância para calcular a área de um retângulo
    double calcularArea() { 
        return comprimento * largura;
    }
}