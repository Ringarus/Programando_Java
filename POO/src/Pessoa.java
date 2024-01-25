//Herança totaL -> ABSTRACT
public abstract class Pessoa {
    //private final Integer idade; -> impede que seja duplicado
    private Integer idade;
    private String nome;
    private String endereço;
    private Double altura;



    //CONSTRUTOR -> inicializar objeto
    public Pessoa(int idade, String nome, String endereço, double altura) {
        this.idade = idade;
        this.nome = nome;
        this.endereço = endereço;
        this.altura = altura;
    }
    //SOBRECARGA -> criar outro construtor
    public Pessoa(int idade, String nome) {
        this.idade = idade;
        this.nome = nome;
    }

    //ENCAPSULAMENTO
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereço() {
        return endereço;
    }
    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }


    public abstract int andar(int passos);


}