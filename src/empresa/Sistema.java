package empresa;


/**
 * La clase Sistema representa el sistema principal de la empresa.
 * Contiene una referencia a la empresa y al administrador del sistema.
 */
public class Sistema {
    private static Sistema referencia=null;

    /**
     * @aggregation composite
     */
    public Empresa GUILLEsa;

    /**
     * @aggregation composite
     */
    private Administrador admin;
    
    /**
     * Constructor de la clase Sistema.
     * 
     * @param admin El administrador del sistema.
     */
    public Sistema(Administrador admin)
    {
        this.GUILLEsa=Empresa.getReferencia();
        this.admin=admin;
    }
        
    /**
     * Obtiene una referencia al sistema.
     * Si no existe una referencia, se crea una nueva instancia del sistema con un administrador predeterminado.
     * 
     * @return Una referencia al sistema.
     */
    public static Sistema getReferencia()
    {
        if(referencia == null)
        {   
            referencia=new Sistema(new Administrador("nombre","admin","admin"));
        }
        return referencia;
    }

	@Override
	public String toString() {
		return "Sistema [GUILLEsa=" + GUILLEsa + ", admin=" + admin + "]";
	}
   
    
}
