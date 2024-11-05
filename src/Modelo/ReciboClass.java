package Modelo;
//Librerias
import java.util.Date;


public class ReciboClass {
    private int idRecibo;
    private String idCita;
    private double precio;
    private String descripcion;
    private String nombre;
    private String apellido;
    private String dni;
    private String idMascota;
    private String nombreMascota;
    private String nombreServicio;
    private String nombreVeterinario;
    private String apellidoVeterinario;
    private Date fecha;
    private String hora;
    public ReciboClass() {}

    public int getIdRecibo()                                        {return idRecibo;}
    public void setIdRecibo(int idRecibo)                           {this.idRecibo = idRecibo;}
    public String getIdCita()                                       {return idCita;}
    public void setIdCita(String idCita)                            {this.idCita = idCita;}
    public double getPrecio()                                       {return precio;}
    public void setPrecio(double precio)                            {this.precio = precio;}
    public String getDescripcion()                                  {return descripcion;}
    public void setDescripcion(String descripcion)                  {this.descripcion = descripcion;}
    public String getNombre()                                       {return nombre;}
    public void setNombre(String nombre)                            {this.nombre = nombre;}
    public String getApellido()                                     {return apellido;}
    public void setApellido(String apellido)                        {this.apellido = apellido;}
    public String getDni()                                          {return dni;}
    public void setDni(String dni)                                  {this.dni = dni;}
    public String getIdMascota()                                    {return idMascota;}
    public void setIdMascota(String idMascota)                      {this.idMascota = idMascota;}
    public String getNombreMascota()                                {return nombreMascota;}
    public void setNombreMascota(String nombreMascota)              {this.nombreMascota = nombreMascota;}
    public String getNombreServicio()                               {return nombreServicio;}
    public void setNombreServicio(String nombreServicio)            {this.nombreServicio = nombreServicio;}
    public String getNombreVeterinario()                            {return nombreVeterinario;}
    public void setNombreVeterinario(String nombreVeterinario)      {this.nombreVeterinario = nombreVeterinario;}
    public String getApellidoVeterinario()                          {return apellidoVeterinario;}
    public void setApellidoVeterinario(String apellidoVeterinario)  {this.apellidoVeterinario = apellidoVeterinario;}
    public Date getFecha()                                          {return fecha;}
    public void setFecha(Date fecha)                                {this.fecha = fecha;}
    public String getHora()                                         {return hora;}
    public void setHora(String hora)                                {this.hora = hora;}
    
    // Método para devolver un arreglo de objetos
    public Object[] RegistroRecibo(int numeracion) {
        return new Object[] { numeracion, idRecibo, idCita, precio, descripcion };
    }
    
    
}//Fin Clase
