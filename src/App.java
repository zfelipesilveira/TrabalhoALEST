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
            case 2: break;
            case 3: break;
            case 4: pesquisaPalavra(); break;
            default: System.out.println("Fim do programa. "); break;
        }
        }while(opcao!=0);


    }

    public static void pesquisaPalavra(){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite a palavra que deseja pesquisar: ");
        String umaPalavra = in.nextLine();
        //chama o método que pesquisa a palavra e printa
        System.out.println("Digite a pagina que deseja visualizar: ");
        int umaPagina = in.nextInt();
        //chama o método que printa a pagina desejada
    }

}