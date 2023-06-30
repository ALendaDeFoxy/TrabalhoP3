package HoterlReserva;

import java.time.LocalDate;

public class Reserva  {
    private String nome;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    
	public LocalDate getDataCheckIn() {
		return dataCheckIn;
	}
	public void setDataCheckIn(LocalDate dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataCheckOut() {
		return dataCheckOut;
	}
	public void setDataCheckOut(LocalDate dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}
}
   
