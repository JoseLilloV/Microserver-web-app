package jose.as2.Services;

import jose.as2.models.Planilla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReportePlanillaService  {

    @Autowired
    RestTemplate restTemplate;

    public List<Planilla> getPlanilla(int mes) {
        List<Planilla> planilla = restTemplate.getForObject("http://CalculoPlanilla-service/CalculoPlanilla/byMes/" + mes, List.class);
        return planilla;
    }


}
