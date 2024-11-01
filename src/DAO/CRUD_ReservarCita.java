package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class CRUD_ReservarCita extends ConectarBD{
    public CRUD_ReservarCita(){}
    
    //metodo que muestra en JTable los registros de las tablas categorias
    public void MostrarCitaEnTablaTurno(JTable tabla, String fecha){
        String[] Titulos={"Nro","Codigo","Fecha","Turno","Estado"};
        DefaultTableModel modelo=new DefaultTableModel(null,Titulos);
        tabla.setModel(modelo);
        Citas cat=new Citas();
        int cantreg=0;
        try{
            rs=st.executeQuery("SELECT c.idCita,c.FechaCita,c.idTurno,c.idEstado" +
                              " FROM CITA c"+
                              " WHERE c.FechaCita='"+fecha+"';");
            while(rs.next()){
                cantreg++;
                cat.setIdCita(rs.getString(1));
                cat.setFecha(rs.getDate(2));
                cat.setIdTurno(rs.getInt(3));
                cat.setIdEstado(rs.getInt(4));
                modelo.addRow(cat.RegistroFechas(cantreg));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
    //metodo que muestra en JTable los registros de las tablas categorias
    public void MostrarCitaEnTabla(JTable tabla, String consulta){
        String[] Titulos={"Nro","Cita","Propietario","DNI","Mascota","Nombre PET","Servicio","Veterinario","Fecha","Hora","Estado"};
        DefaultTableModel modelo=new DefaultTableModel(null,Titulos);
        tabla.setModel(modelo);
        ConsultarCita cat=new ConsultarCita();
        int cantreg=0;
        try{
            rs=st.executeQuery(consulta);
            while(rs.next()){
                cantreg++;
                cat.setIdCita(rs.getString(1));
                cat.setNombres(rs.getString(2));
                cat.setApellidos(rs.getString(3));
                cat.setIdMascota(rs.getString(4));
                cat.setIdMascota(rs.getString(5));
                cat.setNombreM(rs.getString(6));
                cat.setNombreServicio(rs.getString(7));
                cat.setNombreV(rs.getString(8));
                cat.setFecha(rs.getDate(9));
                cat.setHora(rs.getString(10));
                cat.setTipoEstado(rs.getString(11));
                modelo.addRow(cat.RegistroCitas(cantreg));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
     //metodo que inserta registros a la tabla
    public void InsertarCita(Citas cat){
        try{
            //preparando la consulta con parametros a travez de los simbolos de interrogante(?)
            ps=con.prepareStatement("INSERT INTO CITA (idMascota,FechaCita,idTurno,idServicios,idVeterinario,Precio,Descripcion,idEstado)" +
                                    " VALUES(?,?,?,?,?,?,?,1);");
            //actualizando los parametros
            ps.setString(2, cat.getIdMascota());
            
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(3, df.format(cat.getFecha()));
            
            ps.setInt(4, cat.getIdTurno());
            ps.setInt(5, cat.getIdServicios());
            ps.setString(6, cat.getIdVeterinario());
            ps.setDouble(7, cat.getPrecio());
            ps.setString(8, cat.getDescripcion());
            //actualizamos y ejecutamos la consulta
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede insertar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que recupera un registro de la tabla por medio del id
    public Citas RecuperarCita(String idcat){
        Citas cat=null;
        try{
            rs=st.executeQuery("SELECT c.IdCita, c.idMascota, c.FechaCita, c.idTurno, c.idServicios, c.idVeterinario, c.Precio, c.Descripcion" +
                              " FROM CITA c" +
                              " WHERE c.IdCita='"+idcat+"';");
            if(rs.next()){
                cat=new Citas();
                cat.setIdCita(rs.getString(1));
                cat.setIdMascota(rs.getString(2));
                cat.setFecha(rs.getDate(3));
                cat.setIdTurno(rs.getInt(4));
                cat.setIdServicios(rs.getInt(5));
                cat.setIdVeterinario(rs.getString(6));
                cat.setPrecio(rs.getDouble(7));
                cat.setDescripcion(rs.getString(8));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return cat;
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void TerminarCita(Citas cat){
        try{
            ps=con.prepareStatement("UPDATE CITA SET idEstado=2 WHERE IdCita=?;");
            ps.setString(1, cat.getIdCita());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void CancelarCita(Citas cat){
        try{
            ps=con.prepareStatement("UPDATE CITA SET idEstado=3 WHERE IdCita=?;");
            ps.setString(1, cat.getIdCita());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void ReprogramarCita(Citas cat){
        try{
            ps=con.prepareStatement("UPDATE CITA c SET c.FechaCita=?, c.idTurno=? WHERE c.IdCita=?;");
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(1, df.format(cat.getFecha()));
            ps.setInt(2, cat.getIdTurno());
            ps.setString(3, cat.getIdCita());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que muestra codigo en ticket
    public void CargarCodigoTicket(JLabel codigo){
        try{
            rs=st.executeQuery("SELECT MAX(idTicket) AS idTicket FROM TICKET;");
            if(rs.next()){
                String c=rs.getString("IdCita");
                codigo.setText(c);
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede ..."+ex);
        }
    }//fin metodo
    
    //metodo que muestra datos en ticket
    public void DatosTicket(String Codigo, JLabel j1, JLabel j2){
        try{
            rs=st.executeQuery("SELECT c.FechaCita, tu.hora"+
                              " FROM TICKET ti"+
                              " INNER JOIN CITA c ON ti.IdCita =c.IdCita"+
                              " INNER JOIN TURNO tu ON c.idTurno=tu.idTurno"+
                              " WHERE ti.idTicket='"+Codigo+"';");
            while(rs.next()){
                Date f=rs.getDate("c.FechaCita");
                String h=rs.getString("tu.hora");
                j1.setText(f.toString());
                j2.setText(h);
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
    //metodo que recupera el dueño al label
    public void DatosRecibo(String idCi, JLabel e1, JLabel e2, JLabel e3, JLabel e4, JLabel e5, JLabel e6, JLabel e7, JLabel e8, JLabel e9){
        try{
            rs=st.executeQuery("SELECT p.Nombres, p.Apellidos, p.DNI, m.idMascota, m.Nombre_mascota, s.NombreServicio, v.NombresVeterinario, v.ApellidosVeterinario, c.FechaCita, t.hora, c.Precio"+
                              " FROM RECIBO r" +
                              " INNER JOIN CITA c ON r.IdCita=c.IdCita"+
                              " INNER JOIN MASCOTA m ON c.IdMascota=m.IdMascota"+
                              " INNER JOIN PROPIETARIO p ON m.IdPropietario=p.IdPropietario"+
                              " INNER JOIN SERVICIOS s ON c.idServicios=s.idServicios"+
                              " INNER JOIN VETERINARIO v ON c.idVeterinario=v.idVeterinario"+
                              " INNER JOIN TURNO t ON c.idTurno=t.idTurno"+
                              " WHERE r.IdCita='"+idCi+"';");
            while(rs.next()){
                String Nombres=rs.getString("p.Nombres");
                String Apellidos=rs.getString("p.Apellidos");
                String dni=rs.getString("p.DNI");
                String idMacota=rs.getString("m.idMascota");
                String NombreM=rs.getString("m.Nombre_mascota");
                String NombreS=rs.getString("s.NombreServicio");
                String NombreV=rs.getString("v.NombresVeterinario");
                String ApellidosV=rs.getString("v.ApellidosVeterinario");
                Date fecha=rs.getDate("c.FechaCita");
                String hora=rs.getString("t.hora");
                Double precio=rs.getDouble("c.Precio");
                e1.setText(Nombres+" "+Apellidos);
                e2.setText(dni);
                e3.setText(idMacota);
                e4.setText(NombreM);
                e5.setText(NombreS);
                e6.setText(NombreV+" "+ApellidosV);
                e7.setText(fecha.toString());
                e8.setText(hora);
                e9.setText(precio.toString());
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
    }//fin metodo
    
}//fin clase
