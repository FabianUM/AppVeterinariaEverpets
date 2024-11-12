package Modelo;
//librerias
import java.util.Date;

public class TicketClass {
    private int idTicket;
    private String idCita;
    private String hora;
    private Date fecha;
    public TicketClass() {}

    public int getIdTicket()                    {return idTicket;}
    public void setIdTicket(int idTicket)       {this.idTicket = idTicket;}
    public String getIdCita()                   {return idCita;}
    public void setIdCita(String idCita)        {this.idCita = idCita;}
    public String getHora()                     {return hora;}
    public void setHora(String hora)            {this.hora = hora;}
    public Date getFecha()                      {return fecha;}
    public void setFecha(Date fecha)            {this.fecha = fecha;}
    
    // Método para devolver un arreglo de objetos
    public Object[] RegistroTicket(int numeracion) {
        return new Object[] { numeracion, idTicket, idCita, fecha, hora };
    }
    
    
}//Fin Clase
