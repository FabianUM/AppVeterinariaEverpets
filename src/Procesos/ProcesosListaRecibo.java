package Procesos;
//librerias
import Vista.*;

public class ProcesosListaRecibo {
    public static void Presentacion(FrmListaRecibo f14){
        f14.setVisible(true);
        f14.setTitle("Listar Recibos");
    }
    
    public static void LimpiarEntradas(FrmListaRecibo f14){
        f14.txtBuscar.setText("");
        f14.txtBuscar.requestFocus();
    }
    
}//fin clase
