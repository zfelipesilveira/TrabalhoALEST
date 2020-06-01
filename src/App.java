import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        ListaStopwords ls = new ListaStopwords();
        ManipulaStopWords.guardaStopWords(ls);
        LinkedListPalavra lp = new LinkedListPalavra();
        ManipulaTextos.leLivro(lp, ls);
        
        System.out.println("Bem-vindo(a) ao nosso trabalho de ALEST I; ");
        int opcao;
        do{
        System.out.println("Digite 0 para sair do programa: ");
        System.out.println("Digite 1 para exibir todo o índice remissivo: ");
        System.out.println("Digite 2 para exibir o porcentual de stopwords do texto: ");
        System.out.println("Digite 3 para encontrar a palavra mais frequente do texto: ");
        System.out.println("Digite 4 para pesquisar uma palavra específica ");
        opcao = in.nextInt();
        switch(opcao){
            case 1: System.out.println(lp.toString()); break;
            case 2: mostraPorcentagem(ls); break;
            case 3: mostraPalavraMaisFrequente(lp); break;
            case 4: pesquisaPalavra(lp); break;
            default: System.out.println("Fim do programa. "); break;
        }
        }while(opcao!=0);


    }

    public static void pesquisaPalavra(LinkedListPalavra lp){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a palavra que deseja pesquisar: ");
        String umaPalavra = in.nextLine();
        pesquisarPalavra(umaPalavra, lp);
        System.out.println("Digite a pagina que deseja visualizar: ");
        int umaPagina = in.nextInt();
        ManipulaTextos.mostraPagina(umaPagina);
    }

    public static void pesquisarPalavra(String s, LinkedListPalavra lp){
        Palavra p = lp.buscarPalavra(s);
        ListaPaginas paginas = p.getListaPaginas();
        System.out.println("A palavra pesquisada aparece nas seguintes páginas: " + paginas);

    }

    public static void mostraPalavraMaisFrequente(LinkedListPalavra lp){
        String maisFrequente = lp.encontraMaisFrequente();
        System.out.println("A palavra mais frequente do livro é: " + maisFrequente);

    }

    public static void mostraPorcentagem(ListaStopwords ls){
        double porcentagem;
        porcentagem = ManipulaTextos.calculaPorcentagem(ls);
        System.out.println("A porcentagem de stopwords do livro é de aproximadamente " + porcentagem + "%" + "\n");
    }

}