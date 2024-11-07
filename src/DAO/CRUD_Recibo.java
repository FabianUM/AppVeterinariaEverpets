package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUD_Recibo extends ConectarBD{
    public CRUD_Recibo (){}
    
    // Método para mostrar los tickets en un JTable
    public void MostrarReciboEnTabla(JTable tabla, String consulta) {
        String[] Titulos = {"Nro", "ID Recibo", "ID Cita", "Precio", "Descripcion"};
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        tabla.setModel(modelo);
        int cantreg = 0;

        try {
            // Ejecuta la consulta para obtener los registros
            rs = st.executeQuery(consulta);

            while (rs.next()) {
                cantreg++;
                ReciboClass r = new ReciboClass();
                r.setIdRecibo(rs.getInt(1));
                r.setIdCita(rs.getString(2));
                r.setPrecio(rs.getDouble(3));
                r.setDescripcion(rs.getString(4));
                modelo.addRow(r.RegistroRecibo(cantreg));
            }
            con.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR al mostrar los recibos en el JTable: " + e);
        }
    }//Fin metodo
    
    //metodo que muestra datos en ticket
    public ReciboClass DatosRecibo(int Codigo){
        ReciboClass recibo = new ReciboClass();
        try{
            rs=st.executeQuery("SELECT r.IdCita, p.Nombres, p.Apellidos, p.DNI, m.idMascota, m.Nombre_mascota, s.NombreServicio, v.NombresVeterinario, v.ApellidosVeterinario, c.FechaCita, t.hora, c.Precio"+
                              " FROM RECIBO r" +
                              " INNER JOIN CITA c ON r.IdCita=c.IdCita"+
                              " INNER JOIN MASCOTA m ON c.IdMascota=m.IdMascota"+
                              " INNER JOIN PROPIETARIO p ON m.IdPropietario=p.IdPropietario"+
                              " INNER JOIN SERVICIOS s ON c.idServicios=s.idServicios"+
                              " INNER JOIN VETERINARIO v ON c.idVeterinario=v.idVeterinario"+
                              " INNER JOIN TURNO t ON c.idTurno=t.idTurno"+
                              " WHERE r.idRecibo='"+Codigo+"';");
            while(rs.next()){
                recibo.setIdCita(rs.getString("r.IdCita"));
                recibo.setNombre(rs.getString("p.Nombres"));
                recibo.setApellido(rs.getString("p.Apellidos"));
                recibo.setDni(rs.getString("p.DNI"));
                recibo.setIdMascota(rs.getString("m.idMascota"));
                recibo.setNombreMascota(rs.getString("m.Nombre_mascota"));
                recibo.setNombreServicio(rs.getString("s.NombreServicio"));
                recibo.setNombreVeterinario(rs.getString("v.NombresVeterinario"));
                recibo.setApellidoVeterinario(rs.getString("v.ApellidosVeterinario"));
                recibo.setFecha(rs.getDate("c.FechaCita"));  
                recibo.setHora(rs.getString("t.hora")); 
                recibo.setPrecio(rs.getDouble("c.Precio"));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se muestran datos del ticket..."+e);
        }
        return recibo;
    }//fin metodo
    
}//Fin clase
