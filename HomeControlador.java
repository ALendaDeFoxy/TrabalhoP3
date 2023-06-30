package HoterlReserva;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class HomeControlador {
    private Reserva_serviço reservaServico;

    public HomeControlador(Reserva_serviço reservaServico) {
        this.reservaServico = reservaServico;
    }

    @GetMapping("/")
    public String exibirFormularioReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "home";
    }

    @PostMapping("/reserva")
    public String processarFormularioReserva(@ModelAttribute("reserva") Reserva reserva) {
        reservaServico.fazerReserva(reserva);
        return "sucesso";
    }

    @GetMapping("/reservas")
    public String exibirReservas(Model model) {
        List<Reserva> reservas = reservaServico.getAllReservas();
        model.addAttribute("reservas", reservas);
        return "reservas";
    }
}
