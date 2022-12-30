package jose.as2.controllers;

import jose.as2.entities.JustificativoEntity;
import jose.as2.servicies.JustificativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/Justificativos")
public class JustificativoController {
    @Autowired
    JustificativoService justificativoService;

    @PostMapping("/")
    public JustificativoEntity guardar(@RequestBody JustificativoEntity nuevo_justificativo){
        JustificativoEntity obj = justificativoService.guardar(nuevo_justificativo);
        return obj;
    }

    @GetMapping("/byMes/{mes}")
    public ResponseEntity<List<JustificativoEntity>> getByStudentId(@PathVariable("mes") String mes) throws ParseException {
        List<JustificativoEntity> books = justificativoService.getAllbyMes(mes);
        return ResponseEntity.ok(books);
    }
}
