import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String args[]){
        ListaStopwords ls = new ListaStopwords();
        ManipulaStopWords.guardaStopWords(ls);
        System.out.println(ls);



    }
}