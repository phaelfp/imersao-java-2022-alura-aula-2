import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaLinguagem implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String json) {

        JsonParser parser = new JsonParseLinguagem();
        
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de atributos e adicionar na lista de conteudo

        for (Map<String, String> atributo : listaDeAtributos) {
            String titulo = atributo.get("title");
            String urlImagem = atributo.get("url");

            conteudos.add( new Conteudo(titulo, urlImagem));
        }

        return conteudos;
    }
}
