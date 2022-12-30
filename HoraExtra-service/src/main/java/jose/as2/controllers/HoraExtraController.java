package jose.as2.controllers;

import jose.as2.entities.HoraExtraEntity;
import jose.as2.services.HoraExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8082", maxAge = 3600)
@RestController
@RequestMapping("/HoraExtra")
public class HoraExtraController {
    @Autowired
    HoraExtraService horaExtraService;


    @PostMapping("/")
    public HoraExtraEntity guardar(@RequestBody HoraExtraEntity registro){
        HoraExtraEntity obj = horaExtraService.guardar(registro);
        return obj;
    }

    @GetMapping("/byMes/{mes}")
    public ResponseEntity<List<HoraExtraEntity>> getByStudentId(@PathVariable("mes") String mes) throws ParseException {
        List<HoraExtraEntity> books = horaExtraService.getAllbyMes(mes);
        return ResponseEntity.ok(books);
    }

}
