package ar.edu.unlp.info.oo1.ejercicio18;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateLapseTest {
	
	TimeLapse lapso, lapso2, lapsoNeg, lapsoBisiesto, lapsoNoBisiesto;
	
	@BeforeEach
	void setUp() throws Exception{
		lapso = new DateLapse(LocalDate.of(2026, 10, 30), LocalDate.of(2026, 11, 30)); //Desde 30-10-2026 hasta 30-11-2026
		lapso2 = new DateLapse(LocalDate.of(2026, 10, 30), LocalDate.of(2026, 10, 30)); //mismo día
		lapsoNeg = new DateLapse(LocalDate.of(2026, 11, 30), LocalDate.of(2026, 10, 30)); //Al revés
		lapsoBisiesto = new DateLapse(LocalDate.of(2024, 2, 28), LocalDate.of(2024, 3, 1)); 
		lapsoNoBisiesto = new DateLapse(LocalDate.of(2023, 2, 28), LocalDate.of(2023, 3, 1));
	}
	
	@Test
	
	public void includeDateBordes() {
		assertFalse(lapso.includesDate(LocalDate.of(2026, 10, 30))); //Testeo en el from no esté incluido
		assertFalse(lapso.includesDate(LocalDate.of(2026, 11, 30))); //Testeo en el to no esté incluido
		assertTrue(lapso.includesDate(LocalDate.of(2026, 11, 2))); //Testeo que la fecha por parametro existe entre el from y el to
		assertFalse(lapso.includesDate(LocalDate.of(2026, 10, 29))); //Testeo que la fecha por parametro está un día antes del from de un lapso
		assertFalse(lapso.includesDate(LocalDate.of(2026, 12, 1))); //Testeo que la fecha por parametro está un día después del to de un lapso
	}
	
	@Test
	//Testeo que la fecha por parametro no está entre las 2 fechas ya que son iguales from y to
	public void iguales() {
		assertFalse(lapso2.includesDate(LocalDate.of(2026, 12, 1)));
	}
	
	@Test
	//Testeo que hay un mes de diferencia para "lapso"
	public void cantidadDiasEntreFechas() {
		assertEquals(31, lapso.sizeInDays());
	}
	
	@Test
	//Testeo que no hay dias de distancia para un mismo día
	public void cantidadDeDiasIgual() {
		assertEquals(0, lapso2.sizeInDays());
	}
	
	@Test
	//Testeo que el from es mayor al to y esto da una cantidad negativa. Está mal -consultar-
	public void cantidadDiasNegativo() {
		assertEquals(-31, lapsoNeg.sizeInDays());
	}
	
	@Test
	public void sizeInDaysAnioBisiesto() {
		 assertEquals(2, lapsoBisiesto.sizeInDays());
	}
	
	@Test
	public void sizeInDaysAnioNoBisiesto() {
		 assertEquals(1, lapsoNoBisiesto.sizeInDays());
	}
	
}