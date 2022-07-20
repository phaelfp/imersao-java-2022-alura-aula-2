import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParseIMDB implements JsonParser {

    public List<Map<String, String>> parse(String json) {

        Gson gson = new Gson();
        ListOfFilmes listOfFilmes = gson.fromJson(json, ListOfFilmes.class);
        List<Map<String, String>> dados = new ArrayList<>();

        for (Filme item : listOfFilmes.items) {

            Map<String, String> atributosItem = new HashMap<>();

            atributosItem.put("title", item.getTitle());
            atributosItem.put("image", item.getImage());
            atributosItem.put("imDbRating", item.getImDbRating());

            dados.add(atributosItem);
        }

        return dados;
    }
}