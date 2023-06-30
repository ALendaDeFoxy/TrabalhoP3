package HoterlReserva;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class Reserva_serviço {
    private Repositorio_de_reserva reservaRepository;

    public Reserva_serviço(Repositorio_de_reserva reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void fazerReserva(Reserva reserva) {
        if (reserva.getDataCheckIn().isAfter(reserva.getDataCheckOut())) {
            throw new IllegalArgumentException("A data de check-in deve ser anterior à data de check-out");
        }

        if (!verificarDisponibilidade(reserva.getDataCheckIn(), reserva.getDataCheckOut())) {
            throw new RuntimeException("Desculpe, não há disponibilidade para as datas selecionadas");
        }

        reservaRepository.save(reserva);
    }

    private boolean verificarDisponibilidade(LocalDate dataCheckIn, LocalDate dataCheckOut) {
        List<Reserva> reservas = reservaRepository.getAllReserva();
        for (Reserva reservaExistente : reservas) {
            if (reservaExistente.getDataCheckIn().isBefore(dataCheckOut) && reservaExistente.getDataCheckOut().isAfter(dataCheckIn)) {
                return false;
            }
        }
        return true;
    }

    public List<Reserva> getAllReservas() {
        return reservaRepository.getAllReserva();
    }
}
