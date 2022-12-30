package jose.as2.services.strategy;

import jose.as2.entities.RelojEntity;
import jose.as2.services.RelojService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

public class CsvReader implements ReaderStrategy{

    @Override
    public void reader(String stream, RelojService relojService) throws IOException, ParseException {
        if (!stream.isEmpty()) {
            String content = stream;
            String[] lineas = content.split("\n");
            String[] registro;
            for (int i = 1; i < lineas.length; i++) {
                registro = lineas[i].split(";");
                relojService.guardar( new RelojEntity(registro[0], registro[1], registro[2]));
            }
        }
    }
}
