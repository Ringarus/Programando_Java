package Porteiro_CSV;

public class Porteiro {

    //COLUNAS : Andar,Apartamento,Ocupado,Proprietario,Moradores,TelContato,Email

    // O porteiro vai ser responsável por excluir, adicionar e alterar dados

    public static void main(String[] args) {
        Admer.adicionar("5","501","true","Valerio","Valerio","21999999999","vhyst@gmail.com");
        Admer.exibirTabelaFormatada();
    }

    
}
