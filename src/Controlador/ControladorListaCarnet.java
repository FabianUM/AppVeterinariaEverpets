package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Vista.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorListaCarnet implements ActionListener{
    FrmListaCarnet vista;
    CRUD_Carnet crud;
    
    public String consulta = "SELECT idCarnet, idMascota, imagen FROM CARNET_MASCOTA";

    public ControladorListaCarnet(FrmListaCarnet f12) {
        vista=f12;
        vista.btnBuscar.addActionListener(this);
        vista.btnLimpiarFiltro.addActionListener(this);
        ActualizarTabla(consulta);
        Procesos.ProcesosListaDeCarnet.Presentacion(f12);
    }//fin constructor
    
    void ActualizarTabla(String query){
        crud = new CRUD_Carnet();
        crud.MostrarCarnetEnTabla(vista.tblListaCarnet,query);
        ManejadorTablas.FormatoTablaListarCarnet(vista.tblListaCarnet);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnBuscar){
            String query=consulta+" where idMascota='"+vista.txtBuscar.getText()+"';";
            ActualizarTabla(query);
            ProcesosListaDeCarnet.LimpiarEntradas(vista);
        }//fin boton
        
        if(e.getSource()==vista.btnLimpiarFiltro){
            ActualizarTabla(consulta);
        }//fin boton
        
    }//fin metodo
    
}//fin clase
