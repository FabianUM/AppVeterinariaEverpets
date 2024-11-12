package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUD_Ticket extends ConectarBD{
    public CRUD_Ticket (){}
    
    // Método para mostrar los tickets en un JTable
    public void MostrarTicketEnTabla(JTable tabla, String consulta) {
        String[] Titulos = {"Nro", "ID Ticket", "ID Cita", "Fecha", "Hora"};
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        tabla.setModel(modelo);
        int cantreg = 0;

        try {
            // Ejecuta la consulta para obtener los registros
            rs = st.executeQuery(consulta);

            while (rs.next()) {
                cantreg++;
                TicketClass t = new TicketClass();
                t.setIdTicket(rs.getInt(1));
                t.setIdCita(rs.getString(2));
                t.setFecha(rs.getDate(3));
                t.setHora(rs.getString(4));
                modelo.addRow(t.RegistroTicket(cantreg));
            }
            con.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR al mostrar los tickets en el JTable: " + e);
        }
    }//Fin metodo
    
    //metodo que muestra datos en ticket
    public TicketClass DatosTicket(int Codigo){
        TicketClass ticket = new TicketClass();
        try{
            rs=st.executeQuery("SELECT ti.IdCita, c.FechaCita, tu.hora"+
                              " FROM TICKET ti"+
                              " INNER JOIN CITA c ON ti.idCita =c.idCita"+
                              " INNER JOIN TURNO tu ON c.idTurno=tu.idTurno"+
                              " WHERE ti.idTicket="+Codigo+";");
            while(rs.next()){
                ticket.setIdCita(rs.getString("ti.IdCita")); 
                ticket.setFecha(rs.getDate("c.FechaCita"));  
                ticket.setHora(rs.getString("tu.hora")); 
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se muestran datos del ticket..."+e);
        }
        return ticket;
    }//fin metodo
    
}//Fin clase
