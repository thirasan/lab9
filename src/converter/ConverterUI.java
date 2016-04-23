package converter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class ConverterUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;
	private JTextField textField_1;
	private JComboBox comboBox_1;
	private JButton btnConvert;
	private JButton btnClear;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnRightLeft;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterUI frame = new ConverterUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "rawtypes" })
	public ConverterUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		textField = new JTextField("0");
		contentPane.add(textField);
		textField.setColumns(10);

		comboBox = new JComboBox<Unit>();
		Unit[] lengths = UnitConverter.getUnits();
		for( Unit u : lengths) comboBox.addItem(u);
		contentPane.add(comboBox);

		textPane = new JTextPane();
		textPane.setText("=");
		contentPane.add(textPane);

		textField_1 = new JTextField("0");
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		final JComboBox comboBox_1 = new JComboBox<Unit>();
		for( Unit u : lengths) comboBox_1.addItem(u);
		contentPane.add(comboBox_1);

		btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected())
					textField_1.setText(String.valueOf(String.format("%.6f",UnitConverter.convert(Double.parseDouble(textField.getText()),(Unit)comboBox.getSelectedItem(),(Unit)comboBox_1.getSelectedItem()))));
				else if(rdbtnRightLeft.isSelected())
					textField.setText(String.valueOf(String.format("%.6f",UnitConverter.convert(Double.parseDouble(textField_1.getText()),(Unit)comboBox_1.getSelectedItem(),(Unit)comboBox.getSelectedItem()))));
			}
		});
		contentPane.add(btnConvert);

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField.setText("");
			}
		});
		contentPane.add(btnClear);

		rdbtnNewRadioButton = new JRadioButton("Left ->Right");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnRightLeft.setSelected(false);
				textField_1.setEditable(false);
				textField.setEditable(true);
			}
		});
		rdbtnNewRadioButton.setSelected(true);
		textField_1.setEditable(false);
		contentPane.add(rdbtnNewRadioButton);

		rdbtnRightLeft = new JRadioButton("Right -> Left");
		rdbtnRightLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton.setSelected(false);
				textField_1.setEditable(true);
				textField.setEditable(false);
			}
		});
		contentPane.add(rdbtnRightLeft);
		
		textField.addKeyListener( new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
						if(rdbtnNewRadioButton.isSelected())
							textField_1.setText(String.valueOf(String.format("%.6f",UnitConverter.convert(Double.parseDouble(textField.getText()),(Unit)comboBox.getSelectedItem(),(Unit)comboBox_1.getSelectedItem()))));
						else if(rdbtnRightLeft.isSelected())
							textField.setText(String.valueOf(String.format("%.6f",UnitConverter.convert(Double.parseDouble(textField_1.getText()),(Unit)comboBox_1.getSelectedItem(),(Unit)comboBox.getSelectedItem()))));
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		textField_1.addKeyListener( new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
						if(rdbtnNewRadioButton.isSelected())
							textField.setText(String.valueOf(String.format("%.6f",UnitConverter.convert(Double.parseDouble(textField_1.getText()),(Unit)comboBox_1.getSelectedItem(),(Unit)comboBox.getSelectedItem()))));
						else if(rdbtnRightLeft.isSelected())
							textField_1.setText(String.valueOf(String.format("%.6f",UnitConverter.convert(Double.parseDouble(textField.getText()),(Unit)comboBox.getSelectedItem(),(Unit)comboBox_1.getSelectedItem()))));
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
	}

}
