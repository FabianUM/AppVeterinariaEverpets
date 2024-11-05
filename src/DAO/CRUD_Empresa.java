package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import Vista.*;
import com.mysql.cj.jdbc.Blob;
import java.io.File;
import java.io.FileInputStream;

public class CRUD_Empresa extends ConectarBD{
    public CRUD_Empresa(){}
    FrmEmpresa vista;
    
    //metodo que actualiza el registro EMPRESA con imagen
    public void ActualizarEmpresaImagen(Empresa e) {
        try {
            ps = con.prepareStatement("UPDATE EMPRESA SET RUC = ?, Nombre = ?, Telefono = ?, Direccion = ?, imagen = ? WHERE idEmpresa = ?");
            ps.setString(1, e.getRUC());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getTelefono());
            ps.setString(4, e.getDireccion());

            if (e.getImagen() != null) {
                ps.setBytes(5, e.getImagen());
            } else {
                ps.setNull(5, java.sql.Types.BLOB);
            }

            ps.setInt(6, e.getIdEmpresa());
            ps.executeUpdate();
            Mensajes.M1("Datos de Empresa actualizados correctamente");
        } catch (Exception ex) {
            Mensajes.M1("ERROR al actualizar Empresa: " + ex.getMessage());
        }
    }//fin metodo
    
    //metodo que recupera un registro de la tabla por medio del id
    public Empresa RecuperarEmpresa(){
        Empresa em=null;
        try{
            rs=st.executeQuery("SELECT MAX(idEmpresa) as idEmpresa, RUC, Nombre, Telefono, Direccion, Imagen"+
                              " FROM EMPRESA" +
                              " GROUP BY idEmpresa;");
            if(rs.next()){
                em=new Empresa();
                em.setIdEmpresa(rs.getInt(1));
                em.setRUC(rs.getString(2));
                em.setNombre(rs.getString(3));
                em.setTelefono(rs.getString(4));
                em.setDireccion(rs.getString(5));
                // Recuperar la imagen
                Blob blob = (Blob) rs.getBlob("Imagen");
                if (blob != null) {
                    em.setImagen(blob.getBytes(1, (int) blob.length()));
                }
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar la Empresa ..."+e);
        }
        return em;
    }//fin metodo
    
    
}//fin clase
