package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class CRUD_Mascotas extends ConectarBD{
    public CRUD_Mascotas(){}
    
    //metodo que muestra en JTable los registros de las tablas categorias
    public void MostrarCategoriasEnTabla(JTable tabla){
        String[] Titulos={"Nro","Codigo","Nombre","Tipo","Sexo","Edad","Peso","DNI Propietario"};
        DefaultTableModel modelo=new DefaultTableModel(null,Titulos);
        tabla.setModel(modelo);
        Mascotas cat=new Mascotas();
        int cantreg=0;
        try{
            rs=st.executeQuery("SELECT m.idMascota, m.Nombre_mascota, m.Sexo_mascota, m.idTipoMascota, m.Edad_mascota, m.Peso_mascota, m.idPropietario" +
                              " FROM MASCOTA m");
            while(rs.next()){
                cantreg++;
                cat.setIdMascota(rs.getString(1));
                cat.setNombreM(rs.getString(2));
                cat.setSexoM(rs.getString(3));
                cat.setTipoM(rs.getInt(4));
                cat.setEdadM(rs.getInt(5));
                cat.setPesoM(rs.getDouble(6));
                cat.setpropietarioM(rs.getInt(7));
                modelo.addRow(cat.RegistroMascotas(cantreg));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
    //metodo que inserta registros a la tabla
    public void InsertarMascota(Mascotas cat){
        try{
            //preparando la consulta con parametros a travez de los simbolos de interrogante(?)
            ps=con.prepareStatement("INSERT INTO MASCOTA (Nombre_mascota,Sexo_mascota,idTipoMascota,Edad_mascota,Peso_mascota,idPropietario)" +
                                    " VALUES (?,?,?,?,?,?);");
            //actualizando los parametros
            ps.setString(1, cat.getNombreM());
            ps.setString(2, cat.getSexoM());
            ps.setInt(3, cat.getTipoM());
            ps.setInt(4, cat.getEdadM());
            ps.setDouble(5, cat.getPesoM());
            ps.setInt(6, cat.getpropietarioM());
            //actualizamos y ejecutamos la consulta
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede insertar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que recupera un registro de la tabla por medio del id
    public Mascotas RecuperarMascota(String idcat){
        Mascotas cat=null;
        try{
            rs=st.executeQuery("SELECT m.idMascota, m.Nombre_mascota, m.Sexo_mascota, m.idTipoMascota, m.Edad_mascota, m.Peso_mascota, m.idPropietario"+
                              " FROM MASCOTA m" +
                              " WHERE m.idMascota='"+idcat+"';");
            if(rs.next()){
                cat=new Mascotas();
                cat.setIdMascota(rs.getString(1));
                cat.setNombreM(rs.getString(2));
                cat.setSexoM(rs.getString(3));
                cat.setTipoM(rs.getInt(4));
                cat.setEdadM(rs.getInt(5));
                cat.setPesoM(rs.getDouble(6));
                cat.setpropietarioM(rs.getInt(7));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return cat;
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void ActualizarMascota(Mascotas cat){
        try{
            ps=con.prepareStatement("UPDATE MASCOTA m SET m.Nombre_mascota=?, m.Sexo_mascota=?, m.idTipoMascota=?, m.Edad_mascota=?, m.Peso_mascota=?, m.idPropietario=? WHERE m.idMascota=?;");
            ps.setString(1, cat.getNombreM());
            ps.setString(2, cat.getSexoM());
            ps.setInt(3, cat.getTipoM());
            ps.setInt(4, cat.getEdadM());
            ps.setDouble(5, cat.getPesoM());
            ps.setInt(6, cat.getpropietarioM());
            ps.setString(7, cat.getIdMascota());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar la Mascota..."+e);
        }
    }//fin metodo
    
    //metodo que recupera el dueño al label
    public Mascotas DatosCarnetM(String idcat, JLabel e1, JLabel e2, JLabel e3, JLabel e4, JLabel e5){
        Mascotas cat=null;
        try{
            rs=st.executeQuery("SELECT m.IdMascota,m.idPropietario,m.Nombre_mascota,m.idTipoMascota,m.Sexo_mascota"+
                              " FROM MASCOTA m" +
                              " WHERE m.IdMascota='"+idcat+"';");
            if(rs.next()){
                cat=new Mascotas();
                cat.setIdMascota(rs.getString(1));
                cat.setpropietarioM(rs.getInt(2));
                cat.setNombreM(rs.getString(3));
                cat.setTipoM(rs.getInt(4));
                cat.setSexoM(rs.getString(5));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return cat;
    }//fin metodo
    
}//fin clase
