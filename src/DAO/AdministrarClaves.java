package DAO;
//librerias
import Formatos.*;

public class AdministrarClaves extends ConectarBD{
    public String consultaTipoMasc="SELECT t.idTipoMascota FROM TIPO_MASCOTA t WHERE t.Nombre_TipoMascota=?;";
    public String consultaServicio="SELECT s.idServicios FROM SERVICIOS s WHERE s.NombreServicio=?;";
    public String consultaTurno="SELECT t.idTurno FROM TURNO t WHERE t.hora=?;";
    public String consultaRol="SELECT r.idRol FROM ROLES r WHERE r.descripcion=?;";
    public String consultaDNI="SELECT idPropietario FROM PROPIETARIO WHERE DNI=?;";
    
    public AdministrarClaves(){}
    
    //metodo que recibe una consulta y parametro para retornar la id de un registro
    public int RecuperarID(String consulta,String nombre){
        int id=0;
        try{
            ps=con.prepareStatement(consulta);
            ps.setString(1, nombre);
            rs=ps.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar la id..."+e);
        }
        return id;
    }//fin metodo
    
    public String queryTipoMasc="SELECT Nombre_TipoMascota FROM TIPO_MASCOTA WHERE idTipoMascota=?;";
    public String queryServicio="SELECT NombreServicio FROM SERVICIOS WHERE idServicios=?;";
    public String queryTurno="SELECT hora FROM TURNO WHERE idTurno=?;";
    public String queryRol="SELECT descripcion FROM ROLES WHERE idRol=?;";
    public String queryDNI="SELECT DNI FROM PROPIETARIO WHERE idPropietario=?;";
    
    //metodo que recupera el nombre a traves de la id
    public String RecuperarNombre(String consulta, int id){
        String nombre=null;
        try{
            ps=con.prepareStatement(consulta);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                nombre=rs.getString(1);
            }
            con.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede recuperar el nombre... "+ex);
        }
        return nombre;
    }//fin metodo
    
    public String consultaVeterina="SELECT v.idVeterinario FROM VETERINARIO v WHERE v.NombresVeterinario=?;";
    public String consultaIddMasco="SELECT m.idMascota FROM MASCOTA m WHERE m.Nombre_mascota=?;";
    public String consultaNomVeter="SELECT v.NombresVeterinario FROM VETERINARIO v WHERE v.idVeterinario=?;";
    public String consultaNomMasco="SELECT m.Nombre_mascota FROM MASCOTA m WHERE m.idMascota=?;";
    public String consultaDNI2="SELECT p.DNI FROM MASCOTA m INNER JOIN PROPIETARIO p ON m.idPropietario=p.idPropietario WHERE m.idMascota=?;";
    
    //metodo que recibe una consulta y parametro para retornar la id de un registro
    public String RecuperarCodigo(String consulta,String nombre){
        String id=null;
        try{
            ps=con.prepareStatement(consulta);
            ps.setString(1, nombre);
            rs=ps.executeQuery();
            if(rs.next()){
                id=rs.getString(1);
            }
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar la id..."+e);
        }
        return id;
    }//fin metodo
    
}//fin clase
