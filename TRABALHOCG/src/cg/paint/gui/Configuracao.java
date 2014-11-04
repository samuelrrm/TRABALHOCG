package cg.paint.gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import cg.paint.util.TamanhoPixel;

public class Configuracao extends JFrame implements ActionListener, ItemListener{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel_EscolheCores = null;
	private JRadioButton jRadioButton_CINZA_010 = null;
	private JRadioButton jRadioButton_CINZA_050 = null;
	private JRadioButton jRadioButton_CINZA_125 = null;
	private JRadioButton jRadioButton_CINZA_250 = null;
	private JPanel jPanel_Pixel = null;
	private JRadioButton jRadioButton_PixelPequeno = null;
	private JRadioButton jRadioButton_PixelMedio = null;
	private JRadioButton jRadioButton_PixelGrande = null;
	private JPanel jPanel_Caneta = null;
	private JRadioButton jRadioButton_EspessuraFina = null;
	private JRadioButton jRadioButton_EspessuraMedio = null;
	private JRadioButton jRadioButton_EspessuraGrande = null;
	private JLabel jLabel_CorPixel = null;
	private JLabel jLabel_TamanhoPixel = null;
	private JLabel jLabel_TamanhoCaneta = null;
	private JButton jButton_OK = null;
	private ButtonGroup buttonGroup_CorPixel = null;  //  @jve:decl-index=0:visual-constraint="737,90"
	private ButtonGroup buttonGroup_TamanhoPixel = null;  //  @jve:decl-index=0:visual-constraint="767,163"
	private ButtonGroup buttonGroup_TamanhoCaneta = null;  //  @jve:decl-index=0:visual-constraint="824,234"
	private AreaDesenho areaDesenho = null;
	/**
	 * This is the default constructor
	 */
	public Configuracao() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(513, 199);
		this.setContentPane(getJContentPane());
		this.setTitle("Configurador");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel_TamanhoCaneta = new JLabel();
			jLabel_TamanhoCaneta.setBounds(new Rectangle(329, 1, 165, 25));
			jLabel_TamanhoCaneta.setText("Tamanho da caneta");
			jLabel_TamanhoPixel = new JLabel();
			jLabel_TamanhoPixel.setBounds(new Rectangle(164, 1, 165, 25));
			jLabel_TamanhoPixel.setText("Tamanho do pixel");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel_EscolheCores(), null);
			jContentPane.add(getJPanel_Pixel(), null);
			jContentPane.add(getJPanel_Caneta(), null);
			jContentPane.add(jLabel_CorPixel, null);
			jContentPane.add(jLabel_TamanhoPixel, null);
			jContentPane.add(jLabel_TamanhoCaneta, null);
			jContentPane.add(getJButton_OK(), null);
			getButtonGroup_TamanhoPixel();
			getButtonGroup_CorPixel();
			getButtonGroup_TamanhoCaneta();
			
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel_EscolheCores	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_EscolheCores() {
		if (jPanel_EscolheCores == null) {
			jLabel_CorPixel = new JLabel();
			jLabel_CorPixel.setText("Cor do pixel");
			jLabel_CorPixel.setBounds(new Rectangle(-1, 1, 165, 25));
			jPanel_EscolheCores = new JPanel();
			jPanel_EscolheCores.setLayout(new BoxLayout(getJPanel_EscolheCores(), BoxLayout.Y_AXIS));
			jPanel_EscolheCores.setBounds(new Rectangle(-1, 26, 165, 100));
			jPanel_EscolheCores.add(getJRadioButton_CINZA_010(), null);
			jPanel_EscolheCores.add(getJRadioButton_CINZA_050(), null);
			jPanel_EscolheCores.add(getJRadioButton_CINZA_125(), null);
			jPanel_EscolheCores.add(getJRadioButton_CINZA_250(), null);
		}
		return jPanel_EscolheCores;
	}

	/**
	 * This method initializes jRadioButton_CINZA_010	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_CINZA_010() {
		if (jRadioButton_CINZA_010 == null) {
			jRadioButton_CINZA_010 = new JRadioButton();
			jRadioButton_CINZA_010.setText("Cinza claro (10/255)");
			jRadioButton_CINZA_010.addItemListener(this);
//			jRadioButton_CINZA_010.setSelected(true);
		}
		return jRadioButton_CINZA_010;
	}

	/**
	 * This method initializes jRadioButton_CINZA_050	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_CINZA_050() {
		if (jRadioButton_CINZA_050 == null) {
			jRadioButton_CINZA_050 = new JRadioButton();
			jRadioButton_CINZA_050.setText("Cinza médio (50/255)");
			jRadioButton_CINZA_050.addItemListener(this);
		}
		return jRadioButton_CINZA_050;
	}

	/**
	 * This method initializes jRadioButton_CINZA_125	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_CINZA_125() {
		if (jRadioButton_CINZA_125 == null) {
			jRadioButton_CINZA_125 = new JRadioButton();
			jRadioButton_CINZA_125.setText("Cinza forte (125/255)");
			jRadioButton_CINZA_125.addItemListener(this);			
		}
		return jRadioButton_CINZA_125;
	}

	/**
	 * This method initializes jRadioButton_CINZA_250	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_CINZA_250() {
		if (jRadioButton_CINZA_250 == null) {
			jRadioButton_CINZA_250 = new JRadioButton();
			jRadioButton_CINZA_250.setText("Cinza escuro (250/255)");
			jRadioButton_CINZA_250.addItemListener(this);			
		}
		return jRadioButton_CINZA_250;
	}

	/**
	 * This method initializes jPanel_Pixel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Pixel() {
		if (jPanel_Pixel == null) {
			jPanel_Pixel = new JPanel();
			jPanel_Pixel.setLayout(new BoxLayout(getJPanel_Pixel(), BoxLayout.Y_AXIS));
			jPanel_Pixel.setBounds(new Rectangle(164, 26, 165, 100));
			jPanel_Pixel.add(getJRadioButton_PixelPequeno(), null);
			jPanel_Pixel.add(getJRadioButton_PixelMedio(), null);
			jPanel_Pixel.add(getJRadioButton_PixelGrande(), null);
		}
		return jPanel_Pixel;
	}

	/**
	 * This method initializes jRadioButton_PixelPequeno	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_PixelPequeno() {
		if (jRadioButton_PixelPequeno == null) {
			jRadioButton_PixelPequeno = new JRadioButton();
			jRadioButton_PixelPequeno.setText("Pequeno");
			jRadioButton_PixelPequeno.addItemListener(this);			
		}
		return jRadioButton_PixelPequeno;
	}

	/**
	 * This method initializes jRadioButton_PixelMedio	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_PixelMedio() {
		if (jRadioButton_PixelMedio == null) {
			jRadioButton_PixelMedio = new JRadioButton();
			jRadioButton_PixelMedio.setText("Médio");
			jRadioButton_PixelMedio.addItemListener(this);	
//			jRadioButton_PixelMedio.setSelected(true);
		}
		return jRadioButton_PixelMedio;
	}

	/**
	 * This method initializes jRadioButton_PixelGrande	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_PixelGrande() {
		if (jRadioButton_PixelGrande == null) {
			jRadioButton_PixelGrande = new JRadioButton();
			jRadioButton_PixelGrande.setText("Grande");
			jRadioButton_PixelGrande.addItemListener(this);
		}
		return jRadioButton_PixelGrande;
	}

	/**
	 * This method initializes jPanel_Caneta	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Caneta() {
		if (jPanel_Caneta == null) {
			jPanel_Caneta = new JPanel();
			jPanel_Caneta.setLayout(new BoxLayout(getJPanel_Caneta(), BoxLayout.Y_AXIS));
			jPanel_Caneta.setBounds(new Rectangle(329, 26, 165, 100));
			jPanel_Caneta.add(getJRadioButton_EspessuraFina(), null);
			jPanel_Caneta.add(getJRadioButton_EspessuraMedio(), null);
			jPanel_Caneta.add(getJRadioButton_EspessuraGrande(), null);
		}
		return jPanel_Caneta;
	}

	/**
	 * This method initializes jRadioButton_EspessuraFina	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_EspessuraFina() {
		if (jRadioButton_EspessuraFina == null) {
			jRadioButton_EspessuraFina = new JRadioButton();
			jRadioButton_EspessuraFina.setText("Pequeno");
			jRadioButton_EspessuraFina.addItemListener(this);
		}
		return jRadioButton_EspessuraFina;
	}

	/**
	 * This method initializes jRadioButton_EspessuraMedio	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_EspessuraMedio() {
		if (jRadioButton_EspessuraMedio == null) {
			jRadioButton_EspessuraMedio = new JRadioButton();
			jRadioButton_EspessuraMedio.setText("Médio");
			jRadioButton_EspessuraMedio.addItemListener(this);
			jRadioButton_EspessuraMedio.setSelected(true);
		}
		return jRadioButton_EspessuraMedio;
	}

	/**
	 * This method initializes jRadioButton_EspessuraGrande	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton_EspessuraGrande() {
		if (jRadioButton_EspessuraGrande == null) {
			jRadioButton_EspessuraGrande = new JRadioButton();
			jRadioButton_EspessuraGrande.setText("Grande");
			jRadioButton_EspessuraGrande.addItemListener(this);
		}
		return jRadioButton_EspessuraGrande;
	}

	/**
	 * This method initializes jButton_OK	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_OK() {
		if (jButton_OK == null) {
			jButton_OK = new JButton();
			jButton_OK.setBounds(new Rectangle(202, 131, 80, 25));
			jButton_OK.setText("Ok");
			jButton_OK.addActionListener(this);
		}
		return jButton_OK;
	}

	/**
	 * This method initializes buttonGroup_CorPixel	
	 * 	
	 * @return javax.swing.ButtonGroup	
	 */
	private ButtonGroup getButtonGroup_CorPixel() {
		if (buttonGroup_CorPixel == null) {
			buttonGroup_CorPixel = new ButtonGroup();
			buttonGroup_CorPixel.add(jRadioButton_CINZA_010);
			buttonGroup_CorPixel.add(jRadioButton_CINZA_050);
			buttonGroup_CorPixel.add(jRadioButton_CINZA_125);
			buttonGroup_CorPixel.add(jRadioButton_CINZA_250);
		}
		return buttonGroup_CorPixel;
	}

	/**
	 * This method initializes buttonGroup_TamanhoPixel	
	 * 	
	 * @return javax.swing.ButtonGroup	
	 */
	private ButtonGroup getButtonGroup_TamanhoPixel() {
		if (buttonGroup_TamanhoPixel == null) {
			buttonGroup_TamanhoPixel = new ButtonGroup();
			buttonGroup_TamanhoPixel.add(jRadioButton_PixelPequeno);
			buttonGroup_TamanhoPixel.add(jRadioButton_PixelMedio);
			buttonGroup_TamanhoPixel.add(jRadioButton_PixelGrande);
		}
		return buttonGroup_TamanhoPixel;
	}

	/**
	 * This method initializes buttonGroup_TamanhoCaneta	
	 * 	
	 * @return javax.swing.ButtonGroup	
	 */
	private ButtonGroup getButtonGroup_TamanhoCaneta() {
		if (buttonGroup_TamanhoCaneta == null) {
			buttonGroup_TamanhoCaneta = new ButtonGroup();
			buttonGroup_TamanhoCaneta.add(jRadioButton_EspessuraFina);
			buttonGroup_TamanhoCaneta.add(jRadioButton_EspessuraMedio);
			buttonGroup_TamanhoCaneta.add(jRadioButton_EspessuraGrande);			
		}
		return buttonGroup_TamanhoCaneta;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		areaDesenho.repaint();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
//		// TODO Auto-generated method stub
		if (e.getSource() == getJRadioButton_PixelPequeno()){
			areaDesenho.getCaneta().setTamanhoPixel(TamanhoPixel.PEQUENO.getValue());
		}
		if (e.getSource() == getJRadioButton_PixelMedio()){
			areaDesenho.getCaneta().setTamanhoPixel(TamanhoPixel.MEDIO.getValue());
		}
		if (e.getSource() == getJRadioButton_PixelGrande()){
			areaDesenho.getCaneta().setTamanhoPixel(TamanhoPixel.GRANDE.getValue());
		}
//		if (e.getSource()==getJRadioButton_CINZA_010()())
//			tipoRelatorio = "ordemDesenho";
//		if (e.getSource()==getJRadioButton_OrdemAlfabetica())
//			tipoRelatorio = "ordemAlfabetica";
//		if (e.getSource()==getJRadioButton_OrdemArea())
//			tipoRelatorio = "ordemArea";
//		if (e.getSource()==getJRadioButton_OrdemPerimetro())
//			tipoRelatorio = "ordemPerimetro";	
	}
	// TODO Auto-generated method stub

	public AreaDesenho getAreaDesenho() {
		return areaDesenho;
	}

	public void setAreaDesenho(AreaDesenho areaDesenho) {
		this.areaDesenho = areaDesenho;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
