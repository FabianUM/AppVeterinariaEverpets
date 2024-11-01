package DAO;
//librerias
import javax.swing.JComboBox;
import Formatos.*;
import Modelo.*;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActualizarCombos extends ConectarBD{
    public String conultaTipoMasc="SELECT t.Nombre_TipoMascota" +
                                 " FROM TIPO_MASCOTA t" +
                                 " ORDER BY 1;";
    
    public String conultaTurno="SELECT t.hora" +
                              " FROM TURNO t" +
                              " ORDER BY 1;";
    
    public String conultaServicio="SELECT distinct s.NombreServicio" +
                                 " FROM SERVICIOS s" +
                                 " ORDER BY 1;";
    
    public String conultaRol="SELECT DISTINCT r.descripcion" +
                                 " FROM roles r" +
                                 " ORDER BY 1;";
   
    
    public ActualizarCombos(){}
    
    public void CargarCombox(JComboBox combo,String consulta){
        try{
            rs=st.executeQuery(consulta);
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    public void CargarComboxMedicinaPorMascota(JComboBox combo,int idMascota){
        try{
            rs=st.executeQuery("SELECT m.nombre_medicina" +
                               " FROM Medicinas m" +
                               " WHERE indicador='A'"+
                               " AND m.id_tipomascota="+idMascota+";");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    public void CargarComboxServicio1(JComboBox combo,int idTipoMascota){
        combo.removeAllItems();
        try{
            rs=st.executeQuery("SELECT s.NombreServicio" +
                               " FROM SERVICIOS s" +
                               " WHERE s.idTipoMascota="+idTipoMascota+";");
            while(rs.next()){
                //lo que va en el combox
                combo.addItem(rs.getString(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    public void CargarComboxServicio2(JComboBox combo, JComboBox c1){
        combo.removeAllItems();
        String nombre;
        nombre=(String)c1.getSelectedItem();
        try{
            rs=st.executeQuery("SELECT m.idTipoMascota" +
                               " FROM MASCOTA m" +
                               " WHERE m.Nombre_mascota='"+nombre+"';");
            while(rs.next()){
                //lo que va en el combox
                CargarComboxServicio1(combo, rs.getInt(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    public void CargarComboxMascotaDNI2(JComboBox combo, String DNI){
        try{
            rs=st.executeQuery(" SELECT m.Nombre_mascota" +
                               " FROM MASCOTA m" +
                               " INNER JOIN PROPIETARIO p ON m.idPropietario=p.idPropietario"+
                               " WHERE p.DNI="+DNI+
                               " ORDER BY 1;");
            
            while(rs.next()){
                //lo que va en el combox
                AdministrarClaves ad=new AdministrarClaves();
                combo.addItem(rs.getString(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    public void CargarComboxVeterinario(JComboBox combo,String servicio){
        combo.removeAllItems();
        try{
            rs=st.executeQuery("SELECT s.idServicios" +
                               " FROM SERVICIOS s" +
                               " WHERE s.NombreServicio='"+servicio+"';");
            while(rs.next()){
                //lo que va en el combox
                CargarComboxVeterinario2(combo, rs.getInt(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    public void CargarComboxVeterinario2(JComboBox combo, int id){
        try{
            rs=st.executeQuery("SELECT v.NombresVeterinario" +
                               " FROM VETERINARIO v" +
                               " WHERE v.idServicios='"+id+"';");
            while(rs.next()){
                //lo que va en el combox
                combo.addItem(rs.getString(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    public void CargarPrecio(JComboBox combo,JTextField precio){
        precio.setText("");
        String nombre;
        nombre=(String)combo.getSelectedItem();
        AdministrarClaves ad=new AdministrarClaves();
        String codigo=ad.RecuperarCodigo(ad.consultaVeterina, nombre);
        try{
            rs=st.executeQuery("SELECT v.Sueldo" +
                               " FROM VETERINARIO v" +
                               " WHERE v.idVeterinario='"+codigo+"';");
            while(rs.next()){
                //lo que va en el combox
                precio.setText(Double.toString(rs.getDouble(1)));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
}//fin clase
