/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author cuent
 */
public class FormularioMenu extends javax.swing.JFrame {

    /**
     * Creates new form FormularioMenu
     */
    public FormularioMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jdpnContenedor = new javax.swing.JDesktopPane();
        btnConfiguracion = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mitemMantenimientoDueño = new javax.swing.JMenuItem();
        mitemMantenimientoMascota = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mitemMantenimientoCitas = new javax.swing.JMenuItem();
        mitemListarCitas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mitemImprimirCarnet = new javax.swing.JMenuItem();
        mitemListarCarnet = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mitemListarTicket = new javax.swing.JMenuItem();
        mitemListarRecibo = new javax.swing.JMenuItem();
        jMenuConfiguracion = new javax.swing.JMenu();
        mitemTurnosCita = new javax.swing.JMenuItem();
        mitemMantenimientoVeterinarios = new javax.swing.JMenuItem();
        mitemMantenimientoServicioMascotas = new javax.swing.JMenuItem();
        mitemMantenimientoTiposMascota = new javax.swing.JMenuItem();
        jAdministracion = new javax.swing.JMenu();
        mitemMantenimientoUsuarios = new javax.swing.JMenuItem();
        mitemVeterinaria = new javax.swing.JMenuItem();
        jReportes = new javax.swing.JMenu();
        mitemReportesGraficos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdpnContenedor.setBackground(new java.awt.Color(255, 255, 204));

        btnConfiguracion.setBackground(new java.awt.Color(204, 255, 204));
        btnConfiguracion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfiguracion.setText("Configuracion");
        btnConfiguracion.setFocusable(false);

        jdpnContenedor.setLayer(btnConfiguracion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpnContenedorLayout = new javax.swing.GroupLayout(jdpnContenedor);
        jdpnContenedor.setLayout(jdpnContenedorLayout);
        jdpnContenedorLayout.setHorizontalGroup(
            jdpnContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jdpnContenedorLayout.createSequentialGroup()
                .addGap(0, 668, Short.MAX_VALUE)
                .addComponent(btnConfiguracion))
        );
        jdpnContenedorLayout.setVerticalGroup(
            jdpnContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpnContenedorLayout.createSequentialGroup()
                .addComponent(btnConfiguracion)
                .addGap(0, 468, Short.MAX_VALUE))
        );

        jMenu1.setText("Registrar");

        mitemMantenimientoDueño.setText("Mantenimiento Dueño");
        jMenu1.add(mitemMantenimientoDueño);

        mitemMantenimientoMascota.setText("Mantenimiento Mascotas");
        jMenu1.add(mitemMantenimientoMascota);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Citas");

        mitemMantenimientoCitas.setText("Mantenimiento Citas");
        jMenu2.add(mitemMantenimientoCitas);

        mitemListarCitas.setText("Listar Citas");
        jMenu2.add(mitemListarCitas);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Generar");

        mitemImprimirCarnet.setText("Imprimir Carnet");
        jMenu3.add(mitemImprimirCarnet);

        mitemListarCarnet.setText("Listar Carnet");
        jMenu3.add(mitemListarCarnet);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Recibos");

        mitemListarTicket.setText("Listar Ticket");
        jMenu4.add(mitemListarTicket);

        mitemListarRecibo.setText("Listar Recibo");
        jMenu4.add(mitemListarRecibo);

        jMenuBar1.add(jMenu4);

        jMenuConfiguracion.setText("Configuracion");

        mitemTurnosCita.setText("Turnos de Cita");
        jMenuConfiguracion.add(mitemTurnosCita);

        mitemMantenimientoVeterinarios.setText("Mantenimiento Veterinarios");
        mitemMantenimientoVeterinarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitemMantenimientoVeterinariosActionPerformed(evt);
            }
        });
        jMenuConfiguracion.add(mitemMantenimientoVeterinarios);

        mitemMantenimientoServicioMascotas.setText("Mantenimiento Servicio a Mascotas");
        jMenuConfiguracion.add(mitemMantenimientoServicioMascotas);

        mitemMantenimientoTiposMascota.setText("Mantenimiento Tipos Mascotas");
        jMenuConfiguracion.add(mitemMantenimientoTiposMascota);

        jMenuBar1.add(jMenuConfiguracion);

        jAdministracion.setText("Administracion");

        mitemMantenimientoUsuarios.setText("Mantenimiento Usuarios");
        jAdministracion.add(mitemMantenimientoUsuarios);

        mitemVeterinaria.setText("Nuestra Empresa");
        jAdministracion.add(mitemVeterinaria);

        jMenuBar1.add(jAdministracion);

        jReportes.setText("Reportes");

        mitemReportesGraficos.setText("Reportes Gráficos");
        jReportes.add(mitemReportesGraficos);

        jMenuBar1.add(jReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpnContenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpnContenedor)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitemMantenimientoVeterinariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitemMantenimientoVeterinariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mitemMantenimientoVeterinariosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnConfiguracion;
    public javax.swing.JMenu jAdministracion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenu jMenuConfiguracion;
    private javax.swing.JPopupMenu jPopupMenu1;
    public javax.swing.JMenu jReportes;
    public javax.swing.JDesktopPane jdpnContenedor;
    public javax.swing.JMenuItem mitemImprimirCarnet;
    public javax.swing.JMenuItem mitemListarCarnet;
    public javax.swing.JMenuItem mitemListarCitas;
    public javax.swing.JMenuItem mitemListarRecibo;
    public javax.swing.JMenuItem mitemListarTicket;
    public javax.swing.JMenuItem mitemMantenimientoCitas;
    public javax.swing.JMenuItem mitemMantenimientoDueño;
    public javax.swing.JMenuItem mitemMantenimientoMascota;
    public javax.swing.JMenuItem mitemMantenimientoServicioMascotas;
    public javax.swing.JMenuItem mitemMantenimientoTiposMascota;
    public javax.swing.JMenuItem mitemMantenimientoUsuarios;
    public javax.swing.JMenuItem mitemMantenimientoVeterinarios;
    public javax.swing.JMenuItem mitemReportesGraficos;
    public javax.swing.JMenuItem mitemTurnosCita;
    public javax.swing.JMenuItem mitemVeterinaria;
    // End of variables declaration//GEN-END:variables
}
