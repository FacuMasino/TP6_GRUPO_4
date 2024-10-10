package dao;

import java.util.List;
import entidad.Persona;

public interface PersonaDao
{
	public boolean agregar(Persona persona);
	public boolean eliminar(Persona persona);
	public boolean modificar(Persona persona);
	public Persona obtenerPersona(String dni);
	public boolean dniDisponible(String dni);
	public List<Persona> readAll();
}
