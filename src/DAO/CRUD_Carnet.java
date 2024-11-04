package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import com.mysql.cj.jdbc.Blob;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUD_Carnet extends ConectarBD{
    public CRUD_Carnet (){}
   
    // Método para mostrar los carnets en un JTable
    public void MostrarCarnetEnTabla(JTable tabla, String consulta) {
        String[] Titulos = {"Nro", "ID Carnet", "Imagen", "ID Mascota"};
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        tabla.setModel(modelo);
        int cantreg = 0;

        try {
            // Ejecuta la consulta para obtener los registros
            rs = st.executeQuery(consulta);

            while (rs.next()) {
                cantreg++;
                CarnetClass carnet = new CarnetClass();
                carnet.setIdCarnet(rs.getInt("idCarnet"));
                carnet.setIdMascota(rs.getString("idMascota"));

                // Recupera la imagen como BLOB
                Blob blob = (Blob) rs.getBlob("imagen");
                if (blob != null) {
                    byte[] imagenBytes = blob.getBytes(1, (int) blob.length());
                    // Convierte el arreglo de bytes en un ImageIcon
                    ImageIcon imagenIcon = new ImageIcon(imagenBytes);
                    // Se agrega la imagen como ImageIcon en el registro
                    modelo.addRow(new Object[]{cantreg, carnet.getIdCarnet(), imagenIcon, carnet.getIdMascota()});
                } else {
                    // Si no hay imagen, se puede agregar un icono vacío o nulo
                    modelo.addRow(new Object[]{cantreg, carnet.getIdCarnet(), null, carnet.getIdMascota()});
                }
            }
            con.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR al mostrar los carnets en el JTable: " + e);
        }
    }//Fin metodo
    
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
    
    // Método para mostrar los carnets en un JTable
    public void RecuperarCarnet(JTable tabla) {
        String[] Titulos = {"Nro", "ID Carnet", "Imagen", "ID Mascota"};
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        tabla.setModel(modelo);
        int cantreg = 0;

        try {
            // Ejecuta la consulta para obtener los registros
            rs = st.executeQuery("SELECT idCarnet, idMascota, imagen FROM CARNET_MASCOTA");

            while (rs.next()) {
                cantreg++;
                CarnetClass carnet = new CarnetClass();
                carnet.setIdCarnet(rs.getInt("idCarnet"));
                carnet.setIdMascota(rs.getString("idMascota"));

                // Recupera la imagen como BLOB
                Blob blob = (Blob) rs.getBlob("imagen");
                if (blob != null) {
                    byte[] imagenBytes = blob.getBytes(1, (int) blob.length());
                    // Convierte el arreglo de bytes en un ImageIcon
                    ImageIcon imagenIcon = new ImageIcon(imagenBytes);
                    // Se agrega la imagen como ImageIcon en el registro
                    modelo.addRow(new Object[]{cantreg, carnet.getIdCarnet(), imagenIcon, carnet.getIdMascota()});
                } else {
                    // Si no hay imagen, se puede agregar un icono vacío o nulo
                    modelo.addRow(new Object[]{cantreg, carnet.getIdCarnet(), null, carnet.getIdMascota()});
                }
            }
            con.close();
        } catch (Exception e) {
            Mensajes.M1("ERROR al mostrar los carnets en el JTable: " + e);
        }
    }//Fin metodo
    
}//Fin clase
