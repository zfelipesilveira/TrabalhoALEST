import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ManipulaStopWords {
    public static void guardaStopWords(ListaStopwords ls){
        Path path = Paths.get("stopwords.txt");
        try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String linha = null;
            while ((linha = br.readLine()) != null) {
                Scanner sc = new Scanner(linha);
                String stopword = sc.next(); // pega a stopword
                ls.add(stopword); //guarda a stopword na lista com arranjo
            }
        }
        catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }
}
