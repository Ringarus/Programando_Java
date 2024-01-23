public class  Aluno extends Pessoa{
    private Integer turma;
    private Double nota;
    
    //Abstract com método
    @Override
    public int andar(int passos){
        return passos*2;
    }
    
    

}
