package cg.paint.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import cg.paint.comportamento.Transforma;
import cg.paint.controle.ControleDesenhaPoligono;
import cg.paint.controle.ControleDesenhoCircunferencia;
import cg.paint.controle.ControleDesenhoLinha;
import cg.paint.controle.ControleDesenhoQuadrado;
import cg.paint.controle.ControleDesenhoRetangulo;
import cg.paint.controle.ControleSeleciona;
import cg.paint.controle.ControleTransforma;
import cg.paint.util.SuporteLimparTela;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;

public class Paint implements ActionListener {

	private JFrame jFrame = null;  //  @jve:decl-index=0:visual-constraint="-12,0"
	private JPanel jContentPane = null;
	private JToolBar jToolBar_Paint = null;
	private JToggleButton jToggleButton_DesenhaLinha = null;
	private AreaDesenho areaDesenho_Paint = null;
	private JToggleButton jToggleButton_DesenhaRetangulo = null;
	private JToggleButton jToggleButton_DesenhaQuadrado = null;
	private JToggleButton jToggleButton_Selecionar = null;
	private JToggleButton jToggleButton_Abrir = null;
	private JToggleButton jToggleButton_Salvar = null;
	private JFileChooser jFileChooser_Salvar = null;  //  @jve:decl-index=0:visual-constraint="387,615"
	private JButton jButton_Limpar = null;
	private JFileChooser jFileChooser_Abrir = null;
	private JButton jButton_Relatorio = null;
	private JFrame jFrame1_Relatorio = null;  //  @jve:decl-index=0:visual-constraint="52,615"
	private JPanel jContentPane1_Relatorio = null;
	private JToggleButton jToggleButton_Transladar = null;
	private JToggleButton jToggleButton_Rotacionar = null;
	private JToggleButton jToggleButton_MudarEscala = null;
	private JToggleButton jToggleButton_DesenhaCircunferencia = null;
	private JToggleButton jToggleButton_DesenhaElipse = null;
	private JToggleButton jToggleButton_DesenhaPoligonoFechado = null;
	private JToggleButton jToggleButton_Preencher = null;
	private JToolBar jToolBar_Transformar = null;
	private JPanel jPanel_barraferramentas = null;
	private JToolBar jToolBar_outras = null;
	private JToolBar jToolBar_FerramentasDiversas = null;
	private JToggleButton jToggleButton_Grade = null;
	private JToggleButton jToggleButton_Antialiasing = null;
	private JToggleButton jToggleButton_Recorte = null;
	private JToggleButton jToggleButton_ConfiguraPìxel = null;
	private JButton jButton_Conf = null;
	private Configuracao configuracao = null;  //  @jve:decl-index=0:visual-constraint="857,138"
	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setSize(758, 600);
			jFrame.setLocationRelativeTo(null);
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("Paint");
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel_barraferramentas(), BorderLayout.NORTH);
			jContentPane.add(getAreaDesenho_Paint(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jToolBar_Paint	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJToolBar_Paint() {
		if (jToolBar_Paint == null) {
			jToolBar_Paint = new JToolBar();
			jToolBar_Paint.setToolTipText("Ferramentas de desenho");
			jToolBar_Paint.add(getJToggleButton_DesenhaLinha());
			jToolBar_Paint.add(getJToggleButton_DesenhaRetangulo());
			jToolBar_Paint.add(getJToggleButton_DesenhaQuadrado());
			jToolBar_Paint.add(getJToggleButton_DesenhaCircunferencia());
			jToolBar_Paint.add(getJToggleButton_DesenhaElipse());
			jToolBar_Paint.add(getJToggleButton_DesenhaPoligonoFechado());
			jToolBar_Paint.add(getJToggleButton_Selecionar());
			jToolBar_Paint.add(getJToggleButton_Preencher());
			jToolBar_Paint.add(getJButton_Limpar());
		}
		return jToolBar_Paint;
	}

	/**
	 * This method initializes areaDesenho_Paint	
	 * 	
	 * @return lpii.paint.gui.AreaDesenho2	
	 */

	/**
	 * This method initializes jToggleButton_DesenhaLinha	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_DesenhaLinha() {
		if (jToggleButton_DesenhaLinha == null) {
			jToggleButton_DesenhaLinha = new JToggleButton();
			jToggleButton_DesenhaLinha.setIcon(new ImageIcon(getClass().getResource("/icones/linha.gif")));
			jToggleButton_DesenhaLinha.setToolTipText("Desenha reta");
			jToggleButton_DesenhaLinha.addActionListener(this);
		}
		return jToggleButton_DesenhaLinha;
	}

	/**
	 * This method initializes areaDesenho_Paint	
	 * 	
	 * @return lpii.paint.gui.AreaDesenho	
	 */
	private AreaDesenho getAreaDesenho_Paint() {
		if (areaDesenho_Paint == null) {
			areaDesenho_Paint = new AreaDesenho();
			areaDesenho_Paint.montaPainelDesenho();
		}
		return areaDesenho_Paint;
	}

	/**
	 * This method initializes jToggleButton_DesenhaRetangulo	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_DesenhaRetangulo() {
		if (jToggleButton_DesenhaRetangulo == null) {
			jToggleButton_DesenhaRetangulo = new JToggleButton();
			jToggleButton_DesenhaRetangulo.setIcon(new ImageIcon(getClass().getResource("/icones/retangulo.gif")));
			jToggleButton_DesenhaRetangulo.setToolTipText("Desenha retângulo");
			jToggleButton_DesenhaRetangulo.addActionListener(this);
		}
		return jToggleButton_DesenhaRetangulo;
	}

	/**
	 * This method initializes jToggleButton_DesenhaQuadrado	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_DesenhaQuadrado() {
		if (jToggleButton_DesenhaQuadrado == null) {
			jToggleButton_DesenhaQuadrado = new JToggleButton();
			jToggleButton_DesenhaQuadrado.setIcon(new ImageIcon(getClass().getResource("/icones/quadrado.GIF")));
			jToggleButton_DesenhaQuadrado.setToolTipText("Desenha quadrado");
			jToggleButton_DesenhaQuadrado.addActionListener(this);
		}
		return jToggleButton_DesenhaQuadrado;
	}

	/**
	 * This method initializes jToggleButton_Selecionar	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_Selecionar() {
		if (jToggleButton_Selecionar == null) {
			jToggleButton_Selecionar = new JToggleButton();
			jToggleButton_Selecionar.setToolTipText("Selecionar objeto");
			jToggleButton_Selecionar.setIcon(new ImageIcon(getClass().getResource("/icones/selecionar.gif")));
			jToggleButton_Selecionar.addActionListener(this);
		}
		return jToggleButton_Selecionar;
	}

	/**
	 * This method initializes jToggleButton_Abrir	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_Abrir() {
		if (jToggleButton_Abrir == null) {
			jToggleButton_Abrir = new JToggleButton();
			jToggleButton_Abrir.setIcon(new ImageIcon(getClass().getResource("/icones/Abrir.gif")));
			jToggleButton_Abrir.setToolTipText("Abrir");
			jToggleButton_Abrir.addActionListener(this);
		}
		return jToggleButton_Abrir;
	}

	/**
	 * This method initializes jToggleButton_Salvar	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_Salvar() {
		if (jToggleButton_Salvar == null) {
			jToggleButton_Salvar = new JToggleButton();
			jToggleButton_Salvar.setIcon(new ImageIcon(getClass().getResource("/icones/Salvar.gif")));
			jToggleButton_Salvar.setToolTipText("Salvar");
			jToggleButton_Salvar.addActionListener(this);
		}
		return jToggleButton_Salvar;
	}

	/**
	 * This method initializes jFileChooser_Salvar	
	 * 	
	 * @return javax.swing.JFileChooser	
	 */
	private JFileChooser getJFileChooser_Salvar() {
		if (jFileChooser_Salvar == null) {
			jFileChooser_Salvar = new JFileChooser();
		}
		return jFileChooser_Salvar;
	}

	/**
	 * This method initializes jButton_Limpar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Limpar() {
		if (jButton_Limpar == null) {
			jButton_Limpar = new JButton();
			jButton_Limpar.setIcon(new ImageIcon(getClass().getResource("/icones/limpar.gif")));
			jButton_Limpar.setToolTipText("Limpar tela");
			jButton_Limpar.addActionListener(this);
		}
		return jButton_Limpar;
	}

	/**
	 * This method initializes jFileChooser_Abrir	
	 * 	
	 * @return javax.swing.JFileChooser	
	 */
	private JFileChooser getJFileChooser_Abrir() {
		if (jFileChooser_Abrir == null) {
			jFileChooser_Abrir = new JFileChooser();
		}
		return jFileChooser_Abrir;
	}

	/**
	 * This method initializes jButton_Relatorio	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Relatorio() {
		if (jButton_Relatorio == null) {
			jButton_Relatorio = new JButton();
			jButton_Relatorio.setIcon(new ImageIcon(getClass().getResource("/icones/Relatorio.gif")));
			jButton_Relatorio.setToolTipText("Relatórios");
			jButton_Relatorio.addActionListener(this);
		}
		return jButton_Relatorio;
	}

	/**
	 * This method initializes jFrame1_Relatorio	
	 * 	
	 * @return javax.swing.JFrame	
	 */
	private JFrame getJFrame1_Relatorio() {
		if (jFrame1_Relatorio == null) {
			jFrame1_Relatorio = new JFrame();
			jFrame1_Relatorio.setSize(new Dimension(279, 138));
			jFrame1_Relatorio.setTitle("Relatório");
			jFrame1_Relatorio.setContentPane(getJContentPane1_Relatorio());
			jFrame1_Relatorio.setLocationRelativeTo(null);
		}
		return jFrame1_Relatorio;
	}

	/**
	 * This method initializes jContentPane1_Relatorio	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane1_Relatorio() {
		if (jContentPane1_Relatorio == null) {
			jContentPane1_Relatorio = new JPanel();
			jContentPane1_Relatorio.setLayout(new BorderLayout());
		}
		return jContentPane1_Relatorio;
	}

	/**
	 * This method initializes jToggleButton_Transladar	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_Transladar() {
		if (jToggleButton_Transladar == null) {
			jToggleButton_Transladar = new JToggleButton();
			jToggleButton_Transladar.setIcon(new ImageIcon(getClass().getResource("/icones/translada.gif")));
			jToggleButton_Transladar.setToolTipText("Transladar");
			jToggleButton_Transladar.addActionListener(this);
		}
		return jToggleButton_Transladar;
	}

	/**
	 * This method initializes jToggleButton_Rotacionar	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_Rotacionar() {
		if (jToggleButton_Rotacionar == null) {
			jToggleButton_Rotacionar = new JToggleButton();
			jToggleButton_Rotacionar.setIcon(new ImageIcon(getClass().getResource("/icones/rotaciona.gif")));
			jToggleButton_Rotacionar.setToolTipText("Rotacionar");
		}
		return jToggleButton_Rotacionar;
	}

	/**
	 * This method initializes jToggleButton_MudarEscala	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_MudarEscala() {
		if (jToggleButton_MudarEscala == null) {
			jToggleButton_MudarEscala = new JToggleButton();
			jToggleButton_MudarEscala.setToolTipText("Mudar escala");
			jToggleButton_MudarEscala.setIcon(new ImageIcon(getClass().getResource("/icones/escala.gif")));
		}
		return jToggleButton_MudarEscala;
	}

	/**
	 * This method initializes jToggleButton_DesenhaCircunferencia	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_DesenhaCircunferencia() {
		if (jToggleButton_DesenhaCircunferencia == null) {
			jToggleButton_DesenhaCircunferencia = new JToggleButton();
			jToggleButton_DesenhaCircunferencia.setIcon(new ImageIcon(getClass().getResource("/icones/circunf.gif")));
			jToggleButton_DesenhaCircunferencia.setToolTipText("Desenhar circunferência");
			jToggleButton_DesenhaCircunferencia.addActionListener(this);
		}
		return jToggleButton_DesenhaCircunferencia;
	}

	/**
	 * This method initializes jToggleButton_DesenhaElipse	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_DesenhaElipse() {
		if (jToggleButton_DesenhaElipse == null) {
			jToggleButton_DesenhaElipse = new JToggleButton();
			jToggleButton_DesenhaElipse.setIcon(new ImageIcon(getClass().getResource("/icones/elipse.gif")));
			jToggleButton_DesenhaElipse.setToolTipText("Desenhar elipse");
		}
		return jToggleButton_DesenhaElipse;
	}

	/**
	 * This method initializes jToggleButton_DesenhaPoligonoFechado	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_DesenhaPoligonoFechado() {
		if (jToggleButton_DesenhaPoligonoFechado == null) {
			jToggleButton_DesenhaPoligonoFechado = new JToggleButton();
			jToggleButton_DesenhaPoligonoFechado.setIcon(new ImageIcon(getClass().getResource("/icones/poli_fechado.gif")));
			jToggleButton_DesenhaPoligonoFechado.setToolTipText("Desenha polígono fechado");
			jToggleButton_DesenhaPoligonoFechado.addActionListener(this);
		}
		return jToggleButton_DesenhaPoligonoFechado;
	}

	/**
	 * This method initializes jToggleButton_Preencher	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_Preencher() {
		if (jToggleButton_Preencher == null) {
			jToggleButton_Preencher = new JToggleButton();
			jToggleButton_Preencher.setIcon(new ImageIcon(getClass().getResource("/icones/preencher.gif")));
			jToggleButton_Preencher.setToolTipText("Preencher");
		}
		return jToggleButton_Preencher;
	}

	/**
	 * This method initializes jToolBar_Transformar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJToolBar_Transformar() {
		if (jToolBar_Transformar == null) {
			jToolBar_Transformar = new JToolBar();
			jToolBar_Transformar.setToolTipText("Ferramentas de transformação");
			jToolBar_Transformar.add(getJToggleButton_Rotacionar());
			jToolBar_Transformar.add(getJToggleButton_Transladar());
			jToolBar_Transformar.add(getJToggleButton_MudarEscala());
		}
		return jToolBar_Transformar;
	}

	/**
	 * This method initializes jPanel_barraferramentas	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_barraferramentas() {
		if (jPanel_barraferramentas == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			jPanel_barraferramentas = new JPanel();
			jPanel_barraferramentas.setMinimumSize(new Dimension(801, 105));
			jPanel_barraferramentas.setPreferredSize(new Dimension(801, 105));
			jPanel_barraferramentas.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			jPanel_barraferramentas.setLayout(flowLayout);
			jPanel_barraferramentas.add(getJToolBar_Paint(), null);
			jPanel_barraferramentas.add(getJToolBar_Transformar(), null);
			jPanel_barraferramentas.add(getJToolBar_outras(), null);
			jPanel_barraferramentas.add(getJToolBar_FerramentasDiversas(), null);
		}
		return jPanel_barraferramentas;
	}

	/**
	 * This method initializes jToolBar_outras	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJToolBar_outras() {
		if (jToolBar_outras == null) {
			jToolBar_outras = new JToolBar();
			jToolBar_outras.setToolTipText("Ferramentas de arquivo");
			jToolBar_outras.add(getJToggleButton_Salvar());
			jToolBar_outras.add(getJToggleButton_Abrir());
			jToolBar_outras.add(getJButton_Relatorio());
		}
		return jToolBar_outras;
	}

	/**
	 * This method initializes jToolBar_FerramentasDiversas	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJToolBar_FerramentasDiversas() {
		if (jToolBar_FerramentasDiversas == null) {
			jToolBar_FerramentasDiversas = new JToolBar();
			jToolBar_FerramentasDiversas.setToolTipText("Ferramentas diversas");
			jToolBar_FerramentasDiversas.add(getJToggleButton_Grade());
			jToolBar_FerramentasDiversas.add(getJToggleButton_Antialiasing());
			jToolBar_FerramentasDiversas.add(getJToggleButton_Recorte());
			jToolBar_FerramentasDiversas.add(getJToggleButton_ConfiguraPìxel());
			jToolBar_FerramentasDiversas.add(getJButton_Conf());
		}
		return jToolBar_FerramentasDiversas;
	}

	/**
	 * This method initializes jToggleButton_Grade	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_Grade() {
		if (jToggleButton_Grade == null) {
			jToggleButton_Grade = new JToggleButton();
			jToggleButton_Grade.setIcon(new ImageIcon(getClass().getResource("/icones/grade.gif")));
			jToggleButton_Grade.setToolTipText("Ligar/desligar grade");
		}
		return jToggleButton_Grade;
	}

	/**
	 * This method initializes jToggleButton_Antialiasing	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_Antialiasing() {
		if (jToggleButton_Antialiasing == null) {
			jToggleButton_Antialiasing = new JToggleButton();
			jToggleButton_Antialiasing.setIcon(new ImageIcon(getClass().getResource("/icones/antialiasing.gif")));
			jToggleButton_Antialiasing.setToolTipText("Antialiasing");
		}
		return jToggleButton_Antialiasing;
	}

	/**
	 * This method initializes jToggleButton_Recorte	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_Recorte() {
		if (jToggleButton_Recorte == null) {
			jToggleButton_Recorte = new JToggleButton();
			jToggleButton_Recorte.setIcon(new ImageIcon(getClass().getResource("/icones/recorte.gif")));
			jToggleButton_Recorte.setToolTipText("Recortar");
		}
		return jToggleButton_Recorte;
	}

	/**
	 * This method initializes jToggleButton_ConfiguraPìxel	
	 * 	
	 * @return javax.swing.JToggleButton	
	 */
	private JToggleButton getJToggleButton_ConfiguraPìxel() {
		if (jToggleButton_ConfiguraPìxel == null) {
			jToggleButton_ConfiguraPìxel = new JToggleButton();
			jToggleButton_ConfiguraPìxel.setIcon(new ImageIcon(getClass().getResource("/icones/configuraPixel.gif")));
			jToggleButton_ConfiguraPìxel.setToolTipText("Configurar pixel");
		}
		return jToggleButton_ConfiguraPìxel;
	}

	/**
	 * This method initializes jButton_Conf	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton_Conf() {
		if (jButton_Conf == null) {
			jButton_Conf = new JButton();
			jButton_Conf.setIcon(new ImageIcon(getClass().getResource("/icones/janelaConf.gif")));
			jButton_Conf.addActionListener(this);
		}
		return jButton_Conf;
	}

	/**
	 * This method initializes configuracao	
	 * 	
	 * @return cg.paint.gui.Configuracao	
	 */
	private Configuracao getConfiguracao() {
		if (configuracao == null) {
			configuracao = new Configuracao();
		}
		return configuracao;
	}

	/**
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Paint application = new Paint();
				application.getJFrame().setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jToggleButton_DesenhaLinha){
			if (jToggleButton_DesenhaLinha.isSelected()){
				ControleDesenhoLinha.setObtemPontosLinha(true);	// habilita a obtenï¿½ï¿½o de pontos pelo mouse
				ControleDesenhoLinha.setDesenhaLinha(true);	// habilita desenho linha
				System.out.println("Clicou no desenha linha -> HABILITADO!");
			}			
			else {
				ControleDesenhoLinha.setObtemPontosLinha(false);	// desabilita a obtenï¿½ï¿½o de pontos pelo mouse
				ControleDesenhoLinha.setDesenhaLinha(false);	// desabilita desenho linha
				System.out.println("Clicou no desenha linha -> DESABILITADO!");
 			}
		}
		if (e.getSource() == jToggleButton_DesenhaRetangulo){
			if (jToggleButton_DesenhaRetangulo.isSelected()){
				ControleDesenhoRetangulo.setObtemPontosRetangulo(true);
				ControleDesenhoRetangulo.setDesenhaRetangulo(true);	
			}
			else{
				ControleDesenhoRetangulo.setObtemPontosRetangulo(false);
				ControleDesenhoRetangulo.setDesenhaRetangulo(false);
			}
		}
		if (e.getSource() == jToggleButton_DesenhaQuadrado){
			if (jToggleButton_DesenhaQuadrado.isSelected()){
				ControleDesenhoQuadrado.setObtenPontosQuadrado(true);
				ControleDesenhoQuadrado.setDesenhaQuadrado(true);
			}
			else {
				ControleDesenhoQuadrado.setObtenPontosQuadrado(false);
				ControleDesenhoQuadrado.setDesenhaQuadrado(false);
			}
		}
		
		if (e.getSource() == jToggleButton_DesenhaCircunferencia){
			if (jToggleButton_DesenhaCircunferencia.isSelected()){
				ControleDesenhoCircunferencia.setObtemPontosCircunferencia(true);
				ControleDesenhoCircunferencia.setDesenhaCircunferencia(true);
			}
			else {
				ControleDesenhoCircunferencia.setObtemPontosCircunferencia(false);
				ControleDesenhoCircunferencia.setDesenhaCircunferencia(false);
			}
		}
		
		if (e.getSource() == jToggleButton_DesenhaPoligonoFechado){
			if (jToggleButton_DesenhaPoligonoFechado.isSelected()){
				ControleDesenhaPoligono.setObtemPontosPoligono(true);
				ControleDesenhaPoligono.setDesenhaPoligono(true);
			}
			else {
				ControleDesenhaPoligono.setObtemPontosPoligono(false);
				ControleDesenhaPoligono.setDesenhaPoligono(false);				
			}
			
		}
		
		
		if (e.getSource() == jToggleButton_Selecionar){
			if (jToggleButton_Selecionar.isSelected()){
				ControleSeleciona.setSelecaoHabilitada(true);
			}
			else {
				ControleSeleciona.setSelecaoHabilitada(false);
			}
		}
		
		if (e.getSource() == jToggleButton_Transladar){
			if (jToggleButton_Transladar.isSelected()){
				// chama controle de mover
				ControleTransforma.setOperacao(Transforma.TRANSLADA);
				ControleTransforma.setTransforma(true);
			}
			else {
				ControleTransforma.setOperacao(Transforma.LIMPA);
				ControleTransforma.setTransforma(false);
			}
		}
		
		if (e.getSource() == jToggleButton_Salvar){

		}
		
		if (e.getSource() == jButton_Limpar){
			SuporteLimparTela.limparTela(getAreaDesenho_Paint());
		}
		if (e.getSource() == jToggleButton_Abrir){

		}
		
		// código para chamar a janela de relatório
		if (e.getSource() == jButton_Relatorio){

		}
		
		if (e.getSource() == jButton_Conf){
			Configuracao conf = getConfiguracao();
			conf.setAreaDesenho(getAreaDesenho_Paint());			
			conf.setVisible(true);
			conf.setLocationRelativeTo(null);
			
		}
		
	}

}





