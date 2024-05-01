package empresa;
import empresa.Administrador;

public class Sistema {
    private static Sistema referencia=null;
    private Empresa GUILLEsa;
    private Administrador admin;
    
    
    public Sistema(Administrador admin)
    {
        this.GUILLEsa=Empresa.getReferencia();
        this.admin=admin;
    }
    
    public  static Sistema getReferancia()
    {
        if(referencia == null)
        {   
            referencia=new Sistema(new Administrador("nombre","admin","admin"));
        }
        return referencia;
    }
   
}
