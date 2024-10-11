package negocioImpl;

public class NoCaracterExcepcion extends Exception {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "El nombre y apellido solo pueden contener caracteres";
	}	

}