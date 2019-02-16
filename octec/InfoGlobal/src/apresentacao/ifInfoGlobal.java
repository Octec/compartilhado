/*
 * Created by JFormDesigner on Wed Feb 13 10:20:52 BRST 2019
 */

package apresentacao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import net.miginfocom.swing.MigLayout;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author Cleberson Alano
 */
public class ifInfoGlobal extends JFrame {
	public ifInfoGlobal() {
		initComponents();
	}

	private void btGerarRelatorioActionPerformed(ActionEvent e) {
		
        HashMap<String,Object> hm = new HashMap<String,Object>();
        hm.put("info", "testando");
        hm.put("valor", 88);
		
		JasperPrint jp;
		try {
			
	        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream("/apresentacao/jasper/kebe.jasper"));
	        //aqui, como não vais passar parâmetros para dentro do relatório, e porque estou a assumir que não tenhas ligação com base de dados, os dois ultimos parametros são nulos

	         ArrayList<String> lista = new ArrayList();
	         lista.add("1");
	        
	        
	        jp = JasperFillManager.fillReport(jasperReport, hm, new JRBeanCollectionDataSource(lista));
	        //jp = JasperFillManager.fillReport(jasperReport, hm);
	        
			JDialog viewer = new JDialog(new javax.swing.JFrame(),"Visualização de Relatório no novo projeto", true);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			viewer.setSize(screenSize); 
			viewer.setLocation(0,0);

			JasperViewer visor = new JasperViewer(jp,true);
			
			viewer.getContentPane().add(visor.getContentPane());
			viewer.setVisible(true) ; 

		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner non-commercial license
		panel1 = new JPanel();
		btGerarRelatorio = new JButton();

		//======== this ========
		setTitle("Infoglobal");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== panel1 ========
		{
			panel1.setLayout(new MigLayout(
				"insets 0,hidemode 3",
				// columns
				"[22,grow,fill]" +
				"[137,fill]" +
				"[grow,fill]",
				// rows
				"[59,center]" +
				"[81,grow,center]" +
				"[60,center]"));

			//---- btGerarRelatorio ----
			btGerarRelatorio.setText("Gerar relatorio");
			btGerarRelatorio.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btGerarRelatorio.addActionListener(e -> btGerarRelatorioActionPerformed(e));
			panel1.add(btGerarRelatorio, "cell 1 0");
		}
		contentPane.add(panel1, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner non-commercial license
	private JPanel panel1;
	private JButton btGerarRelatorio;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
