import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        
        // Fazer uma conexão HTTP e buscar os 10 primeiros filmes do top 250 filmes
        //String url = "https://raw.githubusercontent.com/alexfelipe/imersao-java/json/top250.json";
        // Fazer uma conexão HTTP e buscar 3 fotos da nasa
        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        
        var httpBody = new ClienteHttp().buscaDados(url);

        // Imprimir o JSON recuperado.
        // System.out.println(body);

        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        List<Conteudo> listaDeConteudo = extrator.extraiConteudos(httpBody);

        var geradora = new GeradorDeFiguirinhas();

        for ( Conteudo conteudo: listaDeConteudo) {

            String titulo = conteudo.getTitulo();
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = titulo + ".png";

            geradora.criar(inputStream, nomeArquivo);

            System.out.println("\u001b[3mTítulo: \u001b[m\u001b[1m"+ titulo + "\u001b[m");
            System.out.println();
        }
    }
}
