public class Teste2 {
    public static void main(String args[]){
        ListaStopwords ls = new ListaStopwords();
        ManipulaStopWords.guardaStopWords(ls);
        String stopwords = ls.toString();
        System.out.println(stopwords);
    }
}
