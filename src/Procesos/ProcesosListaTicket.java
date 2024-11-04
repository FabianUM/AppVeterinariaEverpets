package Procesos;
//librerias
import Vista.*;

public class ProcesosListaTicket {
    public static void Presentacion(FrmListaTicket f13){
        f13.setVisible(true);
        f13.setTitle("Listar Tickets");
    }
    
    public static void LimpiarEntradas(FrmListaTicket f13){
        f13.txtBuscar.setText("");
        f13.txtBuscar.requestFocus();
    }
    
}//fin clase
