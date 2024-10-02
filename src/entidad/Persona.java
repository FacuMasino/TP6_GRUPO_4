package entidad;

public class Persona
{
	private String dni;
	private String nombre;
	private String apellido;
	
	public Persona()
	{
		setDni("No tiene");
		setNombre("Natalia");
		setApellido("Natalia");
	}

	public String getDni()
	{
		return dni;
	}

	public void setDni(String dni)
	{
		this.dni = dni;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getApellido()
	{
		return apellido;
	}
	
	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}
}
