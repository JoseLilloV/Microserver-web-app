package jose.as2.controllers;

import jose.as2.Services.ReportePlanillaService;
import jose.as2.models.Planilla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ReportePlanilla")
public class ReportePlanillaControllers {
    @Autowired
    ReportePlanillaService reportePlanillaService;

    @GetMapping("/byMes/{mes}")
    public ResponseEntity<List<Planilla>> getPlanilla(@PathVariable("mes") int mes) {
        List<Planilla> planilla = reportePlanillaService.getPlanilla(mes);
        return ResponseEntity.ok(planilla);
    }
}
