package jose.as2.services.strategy;

import jose.as2.services.RelojService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

public interface ReaderStrategy {
    public void reader(String steam, RelojService relojService) throws IOException, ParseException;
}

