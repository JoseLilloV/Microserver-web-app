package jose.as2.services.strategy;

import com.google.gson.*;

import jose.as2.entities.RelojEntity;
import jose.as2.services.RelojService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

public class JsonReader implements ReaderStrategy{

    @Override
    public void reader(String stream, RelojService relojService) throws IOException, ParseException {
        if (!stream.isEmpty()) {
            String content = stream;
            final Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonArray gsonArr = parser.parse(content).getAsJsonArray();
            for (JsonElement obj : gsonArr) {
                JsonObject gsonObj = obj.getAsJsonObject();
                System.out.println(gsonObj);
                relojService.guardar( new RelojEntity( gsonObj.get("fecha").getAsString(),
                        gsonObj.get("hora").getAsString(),
                        gsonObj.get("run").getAsString())
                );
            }


        }
    }
}
