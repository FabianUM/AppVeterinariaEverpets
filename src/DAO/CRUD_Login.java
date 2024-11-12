package DAO;
//librerias
import Formatos.*;
import Modelo.*;

public class CRUD_Login extends ConectarBD{
    public CRUD_Login(){}
    
    public Usuarios login(String usuario, String clave){
        String sql="SELECT idUsuario,apellidos, nombres,correo,clave,esActivo,imagen,idRol "+
                "FROM USUARIOS WHERE nombres='"+usuario+"' and clave='"+clave+"'";
        Usuarios u = new Usuarios();
        int cant=0;
        try {
            st=con.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                cant++;
                Mensajes.M1("bienvenido(a) "+usuario);
                u.setIdUsuario(rs.getInt(1));
                u.setApellidos(rs.getString(2));
                u.setNombres(rs.getString(3));
                u.setCorreo(rs.getString(4));
                u.setClave(rs.getString(5));
                u.setEsActivo(rs.getInt(6));
                u.setImagen(rs.getBytes(7));
                u.setIdRol(rs.getInt(8));
                u.RegistroUsuarios(cant);
            }
        } catch (Exception e) {
            Mensajes.M1("Error: "+e);
        }
        return u;
    }//fin metodo
    
}//fin clase
