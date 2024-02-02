package Porteiro_CSV;

public class Porteiro {

    //COLUNAS : Andar,Apartamento,Ocupado,Proprietario,Moradores,TelContato,Email

    // O porteiro vai ser responsável por excluir, adicionar e alterar dados

    public static void main(String[] args) {
        //Como não existia necessidade de orientação a objetos criei tudo estático
        //Admer.adicionar("5","501","true","Valerio","Valerio","21999999999","vhyst@gmail.com");
        //Interno.adicionar("4","407","true","Jefferson","null","2013812983","null");
        //Interno.exibirTabelaFormatada(tabela);  
        //Interno.alterador(3, "Vitor", "Jefferson", false);
        //Interno.Ordenar(false);
        Interno.exibirTabelaFormatada(Interno.gerarTabelaCompleta());
    }

}
