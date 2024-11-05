package Modelo;
//librerias
public class Empresa {
    private int idEmpresa;
    private String RUC;
    private String nombre;
    private String telefono;
    private String direccion;
    private byte[] imagen;
    public Empresa(){}

    public int getIdEmpresa()                   {return idEmpresa;}
    public void setIdEmpresa(int idEmpresa)     {this.idEmpresa = idEmpresa;}
    public String getRUC()                      {return RUC;}
    public void setRUC(String RUC)              {this.RUC = RUC;}
    public String getNombre()                   {return nombre;}
    public void setNombre(String nombre)        {this.nombre = nombre;}
    public String getTelefono()                 {return telefono;}
    public void setTelefono(String telefono)    {this.telefono = telefono;}
    public String getDireccion()                {return direccion;}
    public void setDireccion(String direccion)  {this.direccion = direccion;}
    public byte[] getImagen()                   {return imagen;}
    public void setImagen(byte[] imagen)        {this.imagen = imagen;}
    
    
}//fin clase
