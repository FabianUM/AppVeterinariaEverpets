package Procesos;
//librerias
import Vista.*;

public class ProcesosImprimirCarnetMascota {
    public static void Presentacion(ImprimirCarnetMascota f5){
        f5.setVisible(true);
        f5.setTitle("Imprimir Carnet Mascota");
    }
    
    public static void LimpiarEntradas(ImprimirCarnetMascota f5){
        
        f5.txtCodigo.setText("");
        f5.txtCodigo.requestFocus();
    }
    
    public static void BotonesAlIniciar(ImprimirCarnetMascota f5){
        f5.btnImprimir.setEnabled(false);
        f5.btnImprimir.setVisible(false);
    }
    
    public static void BotonesAlRecuperar(ImprimirCarnetMascota f5){
        f5.txtCodigo.setEnabled(false);
        
        f5.btnMostrarDatos.setEnabled(false);
        f5.btnMostrarDatos.setVisible(false);
        
        f5.btnSeleccionarImagen.setEnabled(false);
        f5.btnSeleccionarImagen.setVisible(false);
        
        f5.btnGenerarImprimir.setEnabled(false);
        f5.btnGenerarImprimir.setVisible(false);
    }
    
    public static void LimpiarEntradasCarnet(Carnet f5){
        f5.lblCodigo.setText("");
        f5.lblDueño.setText("");
        f5.lblDNI.setText("");
        f5.lblMascota.setText("");
        f5.lblTipo.setText("");
        f5.lblSexo.setText("");
        f5.lblDireccion.setText("");
        f5.lblTelefono.setText("");
        f5.lblImagenMascota.setIcon(null);
    }
    
}//fin clase
