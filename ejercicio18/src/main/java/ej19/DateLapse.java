package ej19;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import ar.edu.unlp.info.oo1.ejercicio18.TimeLapse;


public class DateLapse implements TimeLapse {
	private LocalDate from;
	private int sizeInDays;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.sizeInDays= (int) ChronoUnit.DAYS.between(from, to);
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.from.plusDays(this.sizeInDays); //Se calcula el "hasta"
		//plusDays es un método de LocalDate que le suma 'n' días a una LocalDate y
		//devuelve una nueva fecha. Es el opuesto de minusDays, que use en el otro ejercicio
	}
	
	public int sizeInDays() {
		return this.sizeInDays; //Ahora se devuelve directo
	}

	public boolean includesDate(LocalDate other) {
	    return other.isAfter(this.from) && other.isBefore(this.getTo());
	}
	
}
