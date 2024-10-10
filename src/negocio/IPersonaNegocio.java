package negocio;

import java.util.List;
import entidad.Persona;
import negocioImpl.NoNumericoExcepcion;

public interface IPersonaNegocio
{
	public boolean agregar(Persona persona);
	public boolean eliminar(Persona persona);
	public boolean modificar(Persona persona);
	public Persona obtenerPersona(String dni);
	public boolean dniDisponible(Persona persona);
	public List<Persona> readAll();
	public boolean contieneTextoElDni(String dni) throws NoNumericoExcepcion;
}
