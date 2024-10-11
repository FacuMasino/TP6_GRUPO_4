package negocioImpl;

public class DNINoDisponibleExcepcion extends Exception {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "El DNI ingresado ya esta en uso";
	}	

}