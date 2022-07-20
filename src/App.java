import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.net.URL;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://raw.githubusercontent.com/alexfelipe/imersao-java/json/top250.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Imprimir o JSON recuperado.
        // System.out.println(body);

        // Extrair só os dados que interessam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // System.out.println(listaDeFilmes.size());
        // System.out.println(listaDeFilmes.get(0));

        // Exibir e manipular os dados.

        // Var é para não ficar repetindo o nome da Class junto com o new Class()
        var geradora = new GeradorDeFiguirinhas();

        for ( Map<String, String> filme: listaDeFilmes) {

            String urlImage = filme.get("image");
            String titulo = filme.get("title");
            String imDbRation = filme.get("imDbRating");

            InputStream inputStream = new URL(urlImage).openStream();
            String nomeArquivo = titulo + ".png";

            geradora.criar(inputStream, nomeArquivo);

            System.out.println("\u001b[3mTítulo: \u001b[m\u001b[1m"+ titulo + "\u001b[m");
            System.out.println("\u001b[3mPoster: \u001b[m\u001b[1m"+ urlImage + "\u001b[m");
            System.out.println("\u001b[45m\u001b[3mClassificação: \u001b[m\u001b[45m\u001b[1m"+ imDbRation+ " \u001b[m");

            int classificacao = (int) Float.parseFloat(imDbRation);
            String stars = "";
            for(int i = 0; i<classificacao; i++) {
                stars = stars + "\u2B50";
            }
            System.out.println(stars);
            System.out.println();
        }
    }
}
