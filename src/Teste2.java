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
        
       
        
    }
}
