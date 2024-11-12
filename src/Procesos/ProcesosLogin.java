package Procesos;
//librerias
import Vista.*;

public class ProcesosLogin {
    public static void Presentacion(FrmLogin fl){
        fl.setVisible(true);
        fl.setLocationRelativeTo(null);
        fl.setTitle("Frm Login");
    }
    
    public static void LimpiarEntradas(FrmLogin fl){
        fl.txtContraseña.setText("");
        fl.txtNombre.setText("");
    }
    
    public static void VistasSupervisor(FormularioMenu fm){
        fm.mitemTurnosCita.setEnabled(false);
        fm.mitemTurnosCita.setVisible(false);
        fm.mitemMantenimientoServicioMascotas.setEnabled(false);
        fm.mitemMantenimientoServicioMascotas.setVisible(false);
        fm.jAdministracion.setEnabled(false);
        fm.jAdministracion.setVisible(false);
        fm.jReportes.setEnabled(false);
        fm.jReportes.setVisible(false);
    }
    
    public static void VistasEmpleado(FormularioMenu fm){
        fm.jMenuConfiguracion.setEnabled(false);
        fm.jMenuConfiguracion.setVisible(false);
        fm.jAdministracion.setEnabled(false);
        fm.jAdministracion.setVisible(false);
        fm.jReportes.setEnabled(false);
        fm.jReportes.setVisible(false);
    }
    
}//fin clase
