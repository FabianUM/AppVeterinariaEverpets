package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class CRUD_Propietarios extends ConectarBD{
    public CRUD_Propietarios(){}
    
    //metodo que muestra en JTable los registros de las tablas categorias
    public void MostrarCategoriasEnTabla(JTable tabla){
        String[] Titulos={"Nro","DNI","Nombres","Apellidos","Direccion","Telefono","Correo"};
        DefaultTableModel modelo=new DefaultTableModel(null,Titulos);
        tabla.setModel(modelo);
        Propietarios cat=new Propietarios();
        int cantreg=0;
        try{
            rs=st.executeQuery("SELECT p.DNI,p.Nombres,p.Apellidos,p.Direccion,p.Telefono,p.Correo" +
                              " FROM PROPIETARIO p;");
            while(rs.next()){
                cantreg++;
                cat.setDNI(rs.getString(1));
                cat.setNombres(rs.getString(2));
                cat.setApellidos(rs.getString(3));
                cat.setDireccion(rs.getString(4));
                cat.setTelefono(rs.getString(5));
                cat.setCorreo(rs.getString(6));
                modelo.addRow(cat.RegistroPropietarios(cantreg));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
    //metodo que inserta registros a la tabla
    public void InsertarPropietario(Propietarios cat){
        try{
            //preparando la consulta con parametros a travez de los simbolos de interrogante(?)
            ps=con.prepareStatement("INSERT INTO PROPIETARIO" +
                                    " VALUES (?,?,?,?,?,?);");
            //actualizando los parametros
            ps.setString(1, cat.getDNI());
            ps.setString(2, cat.getNombres());
            ps.setString(3, cat.getApellidos());
            ps.setString(4, cat.getDireccion());
            ps.setString(5, cat.getTelefono());
            ps.setString(6, cat.getCorreo());
            //actualizamos y ejecutamos la consulta
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede insertar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que recupera un registro de la tabla por medio del id
    public Propietarios RecuperarPropietario(String idcat){
        Propietarios cat=null;
        try{
            rs=st.executeQuery("SELECT p.DNI,p.Nombres,p.Apellidos,p.Direccion,p.Telefono,p.Correo"+
                              " FROM PROPIETARIO p" +
                              " WHERE p.DNI='"+idcat+"';");
            if(rs.next()){
                cat=new Propietarios();
                cat.setDNI(rs.getString(1));
                cat.setNombres(rs.getString(2));
                cat.setApellidos(rs.getString(3));
                cat.setDireccion(rs.getString(4));
                cat.setTelefono(rs.getString(5));
                cat.setCorreo(rs.getString(6));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return cat;
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void ActualizarPropietario(Propietarios cat){
        try{
            ps=con.prepareStatement("UPDATE PROPIETARIO p SET p.DNI=?,p.Nombres=?,p.Apellidos=?,p.Direccion=?,p.Telefono=?,p.Correo=? WHERE p.DNI=?;");
            ps.setString(1, cat.getDNI());
            ps.setString(2, cat.getNombres());
            ps.setString(3, cat.getApellidos());
            ps.setString(4, cat.getDireccion());
            ps.setString(5, cat.getTelefono());
            ps.setString(6, cat.getCorreo());
            ps.setString(7, cat.getDNI());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que recupera el dueño al label
    public Propietarios RecuperarNombre(String idcat, JLabel etiqueta){
        Propietarios cat=null;
        try{
            rs=st.executeQuery("SELECT p.Nombres,p.Apellidos"+
                              " FROM PROPIETARIO p" +
                              " WHERE p.DNI='"+idcat+"';");
            if(rs.next()){
                cat=new Propietarios();
                cat.setNombres(rs.getString(1));
                cat.setApellidos(rs.getString(2));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return cat;
        
    }//fin metodo
    
    //metodo que recupera el dueño al label
    public Propietarios DatosCatnetP(String idcat, JLabel e1, JLabel e2, JLabel e3){
        Propietarios cat=null;
        try{
            rs=st.executeQuery("SELECT p.Nombres,p.Apellidos,p.Direccion,p.Telefono"+
                              " FROM PROPIETARIO p" +
                              " WHERE p.DNI='"+idcat+"';");
            if(rs.next()){
                cat=new Propietarios();
                cat.setNombres(rs.getString(1));
                cat.setApellidos(rs.getString(2));
                cat.setDireccion(rs.getString(3));
                cat.setTelefono(rs.getString(4));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return cat;
        
    }//fin metodo
    
}//fin clase
