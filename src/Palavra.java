public class Palavra {
    private String palavra;
    private int ocorrencias;
    private LinkedListOfInteger listapaginas;

    public Palavra(String palavra){
        this.palavra = palavra;
    }

    public String getPalavra(){
        return palavra;
    }

    public LinkedListOfInteger getListaPaginas(){
        return listapaginas;
    }
   
    public int getOcorrencias(){
        return ocorrencias;
    }
}