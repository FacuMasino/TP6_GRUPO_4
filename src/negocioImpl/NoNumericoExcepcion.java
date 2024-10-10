package negocioImpl;

public class NoNumericoExcepcion extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoNumericoExcepcion () {
		
		
		
	}
	@Override
	public String getMessage() {
		return "El valor ingresado no tiene formato numero";
	}

	
	
	
	

}
