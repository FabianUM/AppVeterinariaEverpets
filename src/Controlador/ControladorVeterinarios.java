package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Vista.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVeterinarios implements ActionListener{
    FrmVeterinarios vista;
    CRUD_Veterinarios crud;
    Veterinarios cat;

    public ControladorVeterinarios(FrmVeterinarios f7) {
        vista=f7;
        vista.btnRegistrar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnConsultar.addActionListener(this);
        vista.btnDeshabilitar.addActionListener(this);
        ActualizarForma();
        Procesos.ProcesosVeterinarios.Presentacion(f7);
    }//fin constructor
    
    void ActualizarForma(){
         crud = new CRUD_Veterinarios();
         crud.MostrarCategoriasEnTabla(vista.tblEmpleados);
         ProcesosVeterinarios.Estado1(vista);
         ProcesosVeterinarios.LimpiarEntradas(vista);
         ManejadorTablas.FormatoTablaVeterinarios(vista.tblEmpleados);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnRegistrar){
           cat=ProcesosVeterinarios.LeerDatos(vista);
           crud=new CRUD_Veterinarios();
           crud.InsertarVeterinario(cat);
           ActualizarForma();
       }
        
        if(e.getSource()==vista.btnConsultar){
           String idcat=Mensajes.M4("Ingrese el codigo a buscar: ");
           crud=new CRUD_Veterinarios();
           cat=crud.RecuperarVeterinario(idcat);
           if(cat==null){
               Mensajes.M1("El codigo "+idcat+" no existe en la tabla categorias...");
           }else{
               vista.txtCodigo.setText(cat.getIdVeterinario());
               vista.txtNombres.setText(cat.getNombre());
               vista.txtApellidos.setText(cat.getApellido());
               
               AdministrarClaves ac = new AdministrarClaves();
               AdministrarClaves ac1 = new AdministrarClaves();
               vista.cbxTipoMascota.setSelectedItem(ac.RecuperarNombre(ac.queryTipoMasc, cat.getIdTipoMascota()));
               vista.cbxServicio.setSelectedItem(ac1.RecuperarNombre(ac1.queryServicio, cat.getIdServicios()));
               
               vista.txtSueldo.setText(Double.toString(cat.getSueldo()));
               vista.txtSueldo.requestFocus();
               ProcesosVeterinarios.Estado2(vista);
           }
       }
        
        if(e.getSource()==vista.btnActualizar){
           cat=ProcesosVeterinarios.LeerDatos(vista);
           cat.setIdVeterinario(vista.txtCodigo.getText());
           crud=new CRUD_Veterinarios();
           crud.ActualizarVeterinario(cat);
           ActualizarForma();
       }
        
        if(e.getSource()==vista.btnDeshabilitar){
           int respuesta=Mensajes.M3("confirma!!!", "¿Deseas eliminar el registro(0)...?");
           if(respuesta==0){
               String idcat=vista.txtCodigo.getText();
               crud=new CRUD_Veterinarios();
               crud.InhabilitarVeterinario(idcat);
               ActualizarForma();
           }
       }
        
    }//fin metodo
    
}//fin clase
