package HoterlReserva;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class Repositorio_de_reserva {
    private List<Reserva> reservas = new ArrayList<>();

    public void save(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> getAllReserva() {
        return reservas;
    }
}
