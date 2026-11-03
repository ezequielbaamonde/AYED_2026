package ar.edu.unlp.info.oo1.ejercicio18;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse implements TimeLapse{
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}

	public LocalDate getFrom() {
		return this.from;
		
	}
	
	public LocalDate getTo() {
		return this.to;
	}

	public int sizeInDays() {
		//Equivalente: return (int) from.until(to, ChronoUnit.DAYS);
		//Se pone (int) para castear el LONG que retorna ChronoUnit a int
		return (int) ChronoUnit.DAYS.between(from, to);
	}
	
	
	//Estrictamente entre
	public boolean includesDate(LocalDate other) {
		return (other.isAfter(this.from) && (other.isBefore(this.to)));
	}

}