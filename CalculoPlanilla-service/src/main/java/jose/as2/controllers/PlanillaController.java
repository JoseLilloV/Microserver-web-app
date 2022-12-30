package jose.as2.controllers;

import jose.as2.entities.PlanillaEntity;
import jose.as2.services.PlanillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/CalculoPlanilla")
public class PlanillaController {

    @Autowired
    PlanillaService planillaService;


    @GetMapping("/byMes/{mes}")
    public ResponseEntity<List<PlanillaEntity>> getByStudentId(@PathVariable("mes") int mes) {
        List<PlanillaEntity> planilla = planillaService.byMes(mes);
        return ResponseEntity.ok(planilla);
    }

    @GetMapping("/CalcularByMes/{mes}")
    public ResponseEntity<String> CalcularPlanilla(@PathVariable("mes") int mes) throws ParseException {
        List<PlanillaEntity> planilla = planillaService.calularPlanilla(mes);
        return  ResponseEntity.ok("Planilla caluculada correctamente correctamente");
    }
}
