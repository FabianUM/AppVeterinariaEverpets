package Procesos;
//librerias
import Vista.*;

public class ProcesosListaDeCarnet {
    public static void Presentacion(FrmListaCarnet f12){
        f12.setVisible(true);
        f12.setTitle("Listar Carnet");
    }
    
    public static void LimpiarEntradas(FrmListaCarnet f12){
        f12.txtBuscar.setText("");
        f12.txtBuscar.requestFocus();
    }
    
}//fin clase
