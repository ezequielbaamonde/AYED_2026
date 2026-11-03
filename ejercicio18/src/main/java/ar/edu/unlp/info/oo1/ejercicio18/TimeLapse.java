package ar.edu.unlp.info.oo1.ejercicio18;
import java.time.LocalDate;

public interface TimeLapse {
	public LocalDate getFrom();
	public LocalDate getTo();
	public int sizeInDays();
	public boolean includesDate(LocalDate other);
}
