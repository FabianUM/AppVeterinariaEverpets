package Modelo;
//librerias

public class ConsultarCarnet {
    private int idCarnet;
    private byte[] imagen;
    private String idMascota;
    private String NombreMascota;
    private String SexoMascota;
    private String NombreDueño;
    private String ApellidoDueño;
    private String DNI;
    private String Direccion;
    private String Telefono;
    private String TipoMascota;
    public ConsultarCarnet(){}

    public int getIdCarnet()                                    {return idCarnet;}
    public void setIdCarnet(int idCarnet)                       {this.idCarnet = idCarnet;}
    public byte[] getImagen()                                   {return imagen;}
    public void setImagen(byte[] imagen)                        {this.imagen = imagen;}
    public String getIdMascota()                                {return idMascota;}
    public void setIdMascota(String idMascota)                  {this.idMascota = idMascota;}
    public String getNombreMascota()                            {return NombreMascota;}
    public void setNombreMascota(String NombreMascota)          {this.NombreMascota = NombreMascota;}
    public String getSexoMascota()                              {return SexoMascota;}
    public void setSexoMascota(String SexoMascota)              {this.SexoMascota = SexoMascota;}
    public String getNombreDueño()                              {return NombreDueño;}
    public void setNombreDueño(String NombreDueño)              {this.NombreDueño = NombreDueño;}
    public String getApellidoDueño()                            {return ApellidoDueño;}
    public void setApellidoDueño(String ApellidoDueño)          {this.ApellidoDueño = ApellidoDueño;}
    public String getDNI()                                      {return DNI;}
    public void setDNI(String DNI)                              {this.DNI = DNI;}
    public String getDireccion()                                {return Direccion;}
    public void setDireccion(String Direccion)                  {this.Direccion = Direccion;}
    public String getTelefono()                                 {return Telefono;}
    public void setTelefono(String Telefono)                    {this.Telefono = Telefono;}
    public String getTipoMascota()                              {return TipoMascota;}
    public void setTipoMascota(String TipoMascota)              {this.TipoMascota = TipoMascota;}
    
    
    
    
}//Fin Clase
