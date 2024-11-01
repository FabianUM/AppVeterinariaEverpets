package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Vista.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorListaCitas implements ActionListener{
    FrmListaDeCitas vista;
    String consulta="SELECT c.IdCita,p.Nombres,p.Apellidos,p.DNI,m.IdMascota,m.Nombre_mascota,s.NombreServicio,v.NombresVeterinario,c.FechaCita,t.hora,ec.TipoEstado" +
                   " FROM CITA c"+
                   " INNER JOIN MASCOTA m ON c.IdMascota=m.IdMascota"+
                   " INNER JOIN PROPIETARIO p ON m.idPropietario=p.idPropietario"+
                   " INNER JOIN SERVICIOS s ON c.idServicios=s.idServicios"+
                   " INNER JOIN VETERINARIO v ON c.idVeterinario=v.idVeterinario"+
                   " INNER JOIN TURNO t ON c.idTurno=t.idTurno"+
                   " INNER JOIN ESTADO_CITA ec ON c.idEstado=ec.idEstado";
    CRUD_ReservarCita crud;

    public ControladorListaCitas(FrmListaDeCitas f4) {
        vista=f4;
        vista.btnTodos.addActionListener(this);
        vista.btnPendientes.addActionListener(this);
        vista.btnCancelados.addActionListener(this);
        vista.btnTerminados.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        ActualizarTabla(consulta);
        Procesos.ProcesosListaDeCitas.Presentacion(f4);
    }//fin constructor
    
    void ActualizarTabla(String query){
        crud = new CRUD_ReservarCita();
        crud.MostrarCitaEnTabla(vista.tblListaCitas, query);
        ManejadorTablas.FormatoTablaListarCitas(vista.tblListaCitas);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnTodos){
            ActualizarTabla(consulta);
        }//fin boton
        
        if(e.getSource()==vista.btnPendientes){
            String query=consulta+" where c.idEstado=1;";
            ActualizarTabla(query);
        }//fin boton
        
        if(e.getSource()==vista.btnCancelados){
            String query=consulta+" where c.idEstado=3;";
            ActualizarTabla(query);
        }//fin boton
        
        if(e.getSource()==vista.btnTerminados){
            String query=consulta+" where c.idEstado=2;";
            ActualizarTabla(query);
        }//fin boton
        
        if(e.getSource()==vista.btnBuscar){
            String query=consulta+" where c.idMascota='"+vista.txtBuscar.getText()+"';";
            ActualizarTabla(query);
            ProcesosListaDeCitas.LimpiarEntradas(vista);
        }//fin boton
        
    }//fin metodo
    
}//fin clase
