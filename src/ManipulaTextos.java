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

        int contWords = 0;
        int contStopwords = 0;
        int pagAtual = 1;

        for (int i = 1; i<=3343 ; i++) {
            //System.out.println("\nPalavras da linha " + i + ": ");
            if (i%40==0) pagAtual = pagAtual +1;
            linhas[i - 1] = linhas[i - 1].replaceAll("\\t", " "); // substitui tab por espaco em branco
            linhas[i - 1] = linhas[i - 1].replaceAll(",", ""); // para remover vírgulas
            linhas[i - 1] = linhas[i - 1].replaceAll("\\.", ""); // remove ponto final
            linhas[i - 1] = linhas[i - 1].replaceAll(":", "");
            linhas[i - 1] = linhas[i - 1].replaceAll(";", "");
            linhas[i - 1] = linhas[i - 1].replaceAll("!", "");
            linhas[i - 1] = linhas[i - 1].replaceAll("\\)", "");
            linhas[i - 1] = linhas[i - 1].replaceAll("\\(", "");
            linhas[i - 1] = linhas[i - 1].replaceAll("\\'", "");

            String[] tokens = linhas[i - 1].split(" "); // divide a string pelo espaço em branco
            for (String s : tokens) {
                s = s.toLowerCase();

                contWords = contWords + 1; // conta palavras no total
                if (ls.contains(s)) contStopwords = contStopwords + 1; // conta as stopwords
                Palavra p = new Palavra(s);
                if (!ls.contains(s) && !lp.contains(s)) {
                    p.addOcorrencias();
                    lp.add(p); // SE a palavra não é stopword E ainda não está no índice, ela é adicionada na lista de palavras.
                }
                if (lp.contains(s)) {
                    lp.AdicionaPagina(s, pagAtual);  // se a lista de página já possui a palavra, a palavra recebe o número da página em que ela aparece.
                    lp.AdicionaOcorrencia(s);
                }

            }
        }


    }

    public static double calculaPorcentagem(ListaStopwords ls) {
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

        double porcentagem = 0;
        double contWords = 0;
        double contStopwords = 0;
        int pagAtual = 1;
        for (int i = 1; i<=3343 ; i++) {
            //System.out.println("\nPalavras da linha " + i + ": ");
            if (i%40==0) pagAtual = pagAtual +1;
            linhas[i - 1] = linhas[i - 1].replaceAll("\\t", " "); // substitui tab por espaco em branco
            linhas[i - 1] = linhas[i - 1].replaceAll(",", ""); // para remover vírgulas
            linhas[i - 1] = linhas[i - 1].replaceAll("\\.", ""); // remove ponto final
            linhas[i - 1] = linhas[i - 1].replaceAll(":", "");
            linhas[i - 1] = linhas[i - 1].replaceAll(";", "");
            linhas[i - 1] = linhas[i - 1].replaceAll("!", "");
            linhas[i - 1] = linhas[i - 1].replaceAll("\\)", "");
            linhas[i - 1] = linhas[i - 1].replaceAll("\\(", "");

            String[] tokens = linhas[i - 1].split(" "); // divide a string pelo espaço em branco
            for (String s : tokens) {
                s = s.toLowerCase();
                //System.out.println("->" + s);
                //System.out.println(aux);
                contWords = contWords + 1; // conta palavras no total
                if (ls.contains(s)) contStopwords = contStopwords + 1; // conta as stopwords

            }
        }
        porcentagem = ((contStopwords/contWords) * 100);
        porcentagem = porcentagem*100;
        porcentagem = Math.floor(porcentagem);
        porcentagem = porcentagem/100;
        return porcentagem;

    }

    public static void mostraPagina(int pag){
        String linhas[] = new String[1000000];
        int numLinhas = 0;
        int numPaginas = 1;

        Path path1 = Paths.get("alice.txt");

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

        int fim = pag * 40;
        int inicio = fim - 40;
        int n = inicio;

        System.out.println("--------------------- Página " + pag + " ---------------------");
        for (int j = 0; j < 40 && n < fim; j++, n++) {
            System.out.println(linhas[n]);

        }
        System.out.println("--------------------- Fim da Página " + pag + " ---------------------");
        System.out.println("\n");


    }

    public static void leLivroComOcorrencia(LinkedListPalavra lp, ListaStopwords ls) {
        String linhas[] = new String[1000000];
        int numLinhas = 0;
        int numPaginas = 1;

        Path path1 = Paths.get("alice.txt");

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



        int pagAtual = 1;

        for (int i = 1; i<=3343 ; i++) {
            //System.out.println("\nPalavras da linha " + i + ": ");
            if (i%40==0) pagAtual = pagAtual +1;
            linhas[i - 1] = linhas[i - 1].replaceAll("\\t", " "); // substitui tab por espaco em branco
            linhas[i - 1] = linhas[i - 1].replaceAll(",", ""); // para remover vírgulas
            linhas[i - 1] = linhas[i - 1].replaceAll("\\.", ""); // remove ponto final
            linhas[i - 1] = linhas[i - 1].replaceAll(":", "");
            linhas[i - 1] = linhas[i - 1].replaceAll(";", "");
            linhas[i - 1] = linhas[i - 1].replaceAll("!", "");
            linhas[i - 1] = linhas[i - 1].replaceAll("\\)", "");
            linhas[i - 1] = linhas[i - 1].replaceAll("\\(", "");



            String[] tokens = linhas[i - 1].split(" "); // divide a string pelo espaço em branco
            for (String s : tokens) {
                s = s.toLowerCase();


                Palavra p = new Palavra(s);
                if (!ls.contains(s) && !lp.contains(s)) {
                    p.addOcorrencias();
                    lp.add(p); // SE a palavra não é stopword E ainda não está no índice, ela é adicionada na lista de palavras.
                }
                if (lp.contains(s)) {
                    lp.AdicionaPagina(s, pagAtual);  // se a lista de página já possui a palavra, a palavra recebe o número da página em que ela aparece.
                    lp.AdicionaOcorrencia(s);
                }

            }
        }

    }


}
