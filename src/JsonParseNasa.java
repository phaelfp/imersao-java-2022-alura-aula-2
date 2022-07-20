import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonParseNasa implements JsonParser {

    public List<Map<String, String>> parse(String json) {
        
        Gson gson = new Gson();
        
        Type ListType = new TypeToken<ArrayList<NasaApod>>(){}.getType();
 
        ArrayList<NasaApod> list = gson.fromJson(json, ListType);  

        List<Map<String, String>> dados = new ArrayList<>();

        for (NasaApod item : list) {

            Map<String, String> atributosItem = new HashMap<>();

            atributosItem.put("title", item.getTitle());
            atributosItem.put("url", item.getUrl());            

            dados.add(atributosItem);
        }

        return dados;
    }
    
}
