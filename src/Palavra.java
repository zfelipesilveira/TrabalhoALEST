public class Palavra {
    private String palavra;
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

}