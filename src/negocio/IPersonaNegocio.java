package negocio;

import java.util.List;
import entidad.Persona;
import negocioImpl.DNINoDisponibleExcepcion;
import negocioImpl.NoCaracterExcepcion;
import negocioImpl.NoNumericoExcepcion;

public interface IPersonaNegocio
{
	public boolean agregar(Persona persona) throws NoCaracterExcepcion, NoNumericoExcepcion, DNINoDisponibleExcepcion;
	public boolean eliminar(Persona persona);
	public boolean modificar(Persona persona);
	public Persona obtenerPersona(String dni);
	public boolean dniDisponible(Persona persona);
	public List<Persona> readAll();
	public boolean contieneTextoElDni(String dni) throws NoNumericoExcepcion;
}
