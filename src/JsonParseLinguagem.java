import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class JsonParseLinguagem implements JsonParser {

    public List<Map<String, String>> parse(String json) {
        
        Gson gson = new Gson();
        
        Type ListType = new TypeToken<ArrayList<Linguagem>>(){}.getType();
 
        ArrayList<Linguagem> list = gson.fromJson(json, ListType);  

        List<Map<String, String>> dados = new ArrayList<>();

        for (Linguagem item : list) {

            Map<String, String> atributosItem = new HashMap<>();

            atributosItem.put("title", item.getName());
            atributosItem.put("url", item.getUrlImage());            

            dados.add(atributosItem);
        }

        return dados;
    }
    
}

