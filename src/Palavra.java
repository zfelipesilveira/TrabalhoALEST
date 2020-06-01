public class Palavra {
    private String palavra;
    private int ocorrencias = 0;
    private ListaPaginas listapaginas;

    public Palavra(String palavra){
        this.palavra = palavra;
        listapaginas = new ListaPaginas();
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

    public void addOcorrencias(){
        ocorrencias = ocorrencias + 1;
    }
    public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z]*$");
    }
    @Override
    public String toString() {
        return palavra + " -> " + listapaginas.toString();
    }
}