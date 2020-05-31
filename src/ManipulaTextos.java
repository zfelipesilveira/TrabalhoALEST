import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ManipulaTextos {
    public static void leLivro(LinkedListPalavra lp, ListaStopwords ls) {
        String linhas[] = new String[1000000];
        int numLinhas = 0;
        int numPaginas = 1;

        Path path1 = Paths.get("alice.txt");// java.txt AQUI TEMOS QUE COLOCAR ALGUM DOS TEXTOS QUE ELA DEU

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                linhas[numLinhas] = line;
                numLinhas++;
                if (numLinhas % 40 == 0) {
                    numPaginas++;
                }
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }

//        int n = 0;
//        for (int i = 1; i <= numPaginas; i++) {
//            System.out.println("--------------------- Pagina " + i + " ---------------------");
//            for (int j = 0; j < 40 && n < numLinhas; j++, n++) {
//                System.out.println(linhas[n]);
//            }
//        }

        int contWords = 0;
        int contStopwords = 0;
        int aux = 0;
        while (aux < numPaginas) {

            for (int i = 1; i <= 40; i++) {
                System.out.println("\nPalavras da linha " + i + ": ");
                linhas[i - 1] = linhas[i - 1].replaceAll("\\t", " "); // substitui tab por espaco em branco
                linhas[i - 1] = linhas[i - 1].replaceAll(",", ""); // para remover vírgulas
                linhas[i - 1] = linhas[i - 1].replaceAll("\\.", ""); // remove ponto final
                String[] tokens = linhas[i - 1].split(" "); // divide a string pelo espaço em branco
                for (String s : tokens) {
                    s = s.toLowerCase();
                    System.out.println("->" + s);
                    System.out.println(aux);
                    contWords = contWords +1;
                    if (ls.contains(s)) contStopwords = contStopwords +1;
                    Palavra p = new Palavra(s);
                    if(lp.contains(p)) p.inserePagina(aux);
                    else lp.add(p);
                }

            }
            aux++;
        }
    }
}
