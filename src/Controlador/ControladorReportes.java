package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Vista.*;
import Procesos.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ControladorReportes implements ActionListener{
    FrmGraficos vista;
    CRUD_Reportes crud;

    public ControladorReportes(FrmGraficos f15) {
        vista=f15;
        ActualizarForma();
        Procesos.ProcesosReportes.Presentacion(f15);
    }//fin constructor
    
    void ActualizarForma(){
         crud = new CRUD_Reportes();
         // Obtener los datos de las consultas para cada gráfico
         DefaultPieDataset pieDataset = crud.obtenerDistribucionTiposMascotas();
         DefaultCategoryDataset barDataset = crud.obtenerNumeroMascotasPorDueno();
         //DefaultCategoryDataset lineDataset = crud.obtenerDistribucionEdadMascotas();
         DefaultCategoryDataset lineDataset = crud.obtenerNumeroVisitasPorMes();
         DefaultPieDataset ageDataset = crud.obtenerDistribucionEdadMascotas2();
         
         // Crear los gráficos correspondientes
        JFreeChart pieChart = ChartFactory.createPieChart(
            "Distribución de Tipos de Mascotas", pieDataset, true, true, false
        );
        JFreeChart barChart = ChartFactory.createBarChart(
            "Número de Mascotas por Dueño", "Dueño", "Cantidad de Mascotas", barDataset
        );
        JFreeChart lineChart = ChartFactory.createLineChart(
            "Número Citas por Mes", "Mes", "Cantidad de Citas", lineDataset
        );
        JFreeChart ageChart = ChartFactory.createPieChart(
            "Distribución de Edad de Mascotas", ageDataset, true, true, false
        );

        // Crear los paneles de los gráficos
        ChartPanel pieChartPanel = new ChartPanel(pieChart);
        pieChartPanel.setPreferredSize(new java.awt.Dimension(360, 270));
        ChartPanel barChartPanel = new ChartPanel(barChart);
        barChartPanel.setPreferredSize(new java.awt.Dimension(360, 270));
        ChartPanel lineChartPanel = new ChartPanel(lineChart);
        lineChartPanel.setPreferredSize(new java.awt.Dimension(360, 270));
        ChartPanel ageChartPanel = new ChartPanel(ageChart);
        ageChartPanel.setPreferredSize(new java.awt.Dimension(360, 270));

        // Limpiar los paneles y agregar los gráficos
        vista.pnlGrafico.removeAll();
        vista.pnlGrafico.add(pieChartPanel, BorderLayout.CENTER);
        vista.pnlGrafico.revalidate();
        vista.pnlGrafico.repaint();

        vista.pnlGrafico1.removeAll();
        vista.pnlGrafico1.add(barChartPanel, BorderLayout.CENTER);
        vista.pnlGrafico1.revalidate();
        vista.pnlGrafico1.repaint();

        vista.pnlGrafico2.removeAll();
        vista.pnlGrafico2.add(lineChartPanel, BorderLayout.CENTER);
        vista.pnlGrafico2.revalidate();
        vista.pnlGrafico2.repaint();

        vista.pnlGrafico3.removeAll();
        vista.pnlGrafico3.add(ageChartPanel, BorderLayout.CENTER);
        vista.pnlGrafico3.revalidate();
        vista.pnlGrafico3.repaint();
         
         
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
    }//fin metodo
    
}//fin clase
