package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import com.mysql.cj.jdbc.Blob;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUD_Carnet extends ConectarBD{
    public CRUD_Carnet (){}
    
    //metodo que inserta un registro de carnet con imagen
    public void InsertarCarnet(CarnetClass carnet) {
        try {
            ps = con.prepareStatement("INSERT INTO CARNET_MASCOTA (idMascota, imagen)"+
                                     " VALUES(?,?)");
            
            ps.setString(1, carnet.getIdMascota());
            
            if (carnet.getImagen() != null) {
                ps.setBytes(2, carnet.getImagen());
            } else {
                ps.setNull(2, java.sql.Types.BLOB);
            }
            
            
            ps.executeUpdate();
            Mensajes.M1("Carnet insertado correctamente");
        } catch (Exception e) {
            Mensajes.M1("ERROR al insertar carnet: " + e.getMessage());
        }
    }//fin metodo
    
}//Fin clase
