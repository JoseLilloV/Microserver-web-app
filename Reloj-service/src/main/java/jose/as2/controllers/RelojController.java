package jose.as2.controllers;

import jose.as2.entities.RelojEntity;
import jose.as2.models.RequestModel;
import jose.as2.services.RelojService;
import jose.as2.services.strategy.CsvReader;
import jose.as2.services.strategy.JsonReader;
import jose.as2.services.strategy.ReaderContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/Reloj")
public class RelojController {
    @Autowired
    RelojService relojService;

    @GetMapping("/byMes/{mes}")
    public ResponseEntity<List<RelojEntity>> getByStudentId(@PathVariable("mes") String mes) throws ParseException {
        List<RelojEntity> registros = relojService.getAllByMes(mes);
        return ResponseEntity.ok(registros);
    }

    @PostMapping("/cargarArchivo")
    public ResponseEntity<String> carga(@RequestBody RequestModel registro) throws IOException, ParseException {
        ReaderContext context = new ReaderContext();

        //String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        switch (registro.getTipo()){
            case "DATA.txt":
                context.setReaderMethod(new CsvReader());
                context.readerFile(registro.getStream(), relojService);
                break;
            case "HORAS.JSON":
                context.setReaderMethod(new JsonReader());
                context.readerFile(registro.getStream(), relojService);
                break;
            default:
                return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok("Archivo del reloj cargado correctamente");
    }
}
