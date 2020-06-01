public class Teste2 {
    public static void main(String args[]){
        ListaStopwords ls = new ListaStopwords();
        ManipulaStopWords.guardaStopWords(ls);
//        String stopwords = ls.toString();
//        System.out.println(stopwords);

        LinkedListPalavra lp = new LinkedListPalavra();
        ManipulaTextos.leLivro(lp, ls);


        double porcentagem;
        porcentagem = ManipulaTextos.calculaPorcentagem(lp, ls);
        System.out.println("A porcentagem de stopwords do livro é de aproximadamente " + porcentagem + "%");

        pesquisarPalavra("alice", lp);

        ManipulaTextos.mostraPagina(1);
        

        
    }

    public static void pesquisarPalavra(String s, LinkedListPalavra lp){
        Palavra p = lp.buscarPalavra(s);
        ListaPaginas paginas = p.getListaPaginas();
        System.out.println("A palavra pesquisada aparece nas seguintes páginas: " + paginas);

    }
}
