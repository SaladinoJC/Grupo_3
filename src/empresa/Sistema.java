package empresa;


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
    
    
    public Sistema(Administrador admin)
    {
        this.GUILLEsa=Empresa.getReferencia();
        this.admin=admin;
    }
    
    public  static Sistema getReferencia()
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
