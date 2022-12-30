package jose.as2.services.strategy;

import jose.as2.services.RelojService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

public class ReaderContext {
    private ReaderStrategy strategy;

    public void setReaderMethod(ReaderStrategy strategy){
        this.strategy = strategy;
    }
    public ReaderStrategy getStrategy(){
        return this.strategy;
    }
    public void readerFile(String stream, RelojService relojService) throws IOException, ParseException {
        this.strategy.reader(stream, relojService);
    }

}
