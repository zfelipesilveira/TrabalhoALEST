public class Palavra {
    private String palavra;
    private int ocorrencias;
    private ListaPaginas listapaginas;

    public Palavra(String palavra){
        this.palavra = palavra;

    }

    public String getPalavra(){
        return palavra;
    }

    public ListaPaginas getListaPaginas(){
        return listapaginas;
    }
   
    public int getOcorrencias(){
        return ocorrencias;
    }

    public void inserePagina(Integer pagina){
        listapaginas.add(pagina);
    }

    @Override
    public String toString() {
        return palavra + " -> " + listapaginas.toString();
    }
}