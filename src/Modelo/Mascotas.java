package Modelo;
//librerias
import DAO.*;

public class Mascotas {
    private String idMascota;
    private String nombreM;
    private String sexoM;
    private int tipoM;
    private int edadM;
    private double pesoM;
    private int propietarioM;
    public Mascotas(){}

    public String getIdMascota()                        {return idMascota;}
    public void setIdMascota(String idMascota)          {this.idMascota = idMascota;}
    public String getNombreM()                          {return nombreM;}
    public void setNombreM(String nombreM)              {this.nombreM = nombreM;}
    public String getSexoM()                            {return sexoM;}
    public void setSexoM(String sexoM)                  {this.sexoM = sexoM;}
    public int getTipoM()                               {return tipoM;}
    public void setTipoM(int tipoM)                     {this.tipoM = tipoM;}
    public int getEdadM()                               {return edadM;}
    public void setEdadM(int edadM)                     {this.edadM = edadM;}
    public double getPesoM()                            {return pesoM;}
    public void setPesoM(double pesoM)                  {this.pesoM = pesoM;}
    public int getpropietarioM()                        {return propietarioM;}
    public void setpropietarioM(int propietarioM)      {this.propietarioM = propietarioM;}
    
    
    public Object[] RegistroMascotas(int numeracion){
        
        AdministrarClaves ac = new AdministrarClaves();
        AdministrarClaves ac1 = new AdministrarClaves();
        
        Object[] fila={numeracion,idMascota,nombreM,
                       ac.RecuperarNombre(ac.queryTipoMasc, tipoM),
                       sexoM,edadM,pesoM,ac1.RecuperarNombre(ac1.queryDNI, propietarioM)};
        return fila;
   }
    
}//fin clase
