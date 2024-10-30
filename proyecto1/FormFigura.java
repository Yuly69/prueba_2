import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormFigura extends JFrame {
    private JTextField baseField, alturaField, radioField, ladoField;
    private DefaultTableModel tableModel;
 
    public FormFigura() {
        //formato general de la ventana
        setTitle("Registro de figuras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
 
        // Crear el formulario de captura
        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        formPanel.add(new JLabel("Base:"));
        baseField = new JTextField();
        formPanel.add(baseField);
 
        formPanel.add(new JLabel("Altura:"));
        alturaField = new JTextField();
        formPanel.add(alturaField);
 
        formPanel.add(new JLabel("Rádio:"));
        radioField = new JTextField();
        formPanel.add(radioField);
 
        formPanel.add(new JLabel("Lado:"));
        ladoField = new JTextField();
        formPanel.add(ladoField);
 
        // Botón para agregar a la tabla
        JButton addButton = new JButton("Agregar circulo");
        formPanel.add(addButton);
        JButton addButton2 = new JButton("Agregar cuadrado");
        formPanel.add(addButton2);
        JButton addButton3 = new JButton("Agregar rectangulo");
        formPanel.add(addButton3);
        JButton addButton4 = new JButton("Agregar triangulo");
        formPanel.add(addButton4);
 
        // Configurar la tabla
        String[] columnNames = {"Base", "Altura", "Radio", "Lado"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
 
        // Añadir acción al botón
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int radio = Integer.parseInt(radioField.getText());
                // Crear un objeto Paciente
                Circulo circulo = new Circulo(radio);     
                // Escribir en el archivo
                System.out.println("Se creó circulo");
                // Limpiar los campos del formulario
                baseField.setText("");
                alturaField.setText("");
                radioField.setText("");
                ladoField.setText("");
            }
        });
        addButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int lado = Integer.parseInt(ladoField.getText());
                // Crear un objeto Paciente
                Cuadrado cuadrado = new Cuadrado(lado);
        
                // Escribir en el archivo
                System.out.println("Se creó cuadrado");
 
                // Limpiar los campos del formulario
                baseField.setText("");
                alturaField.setText("");
                radioField.setText("");
                ladoField.setText("");
            }
        });
        addButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int lado = Integer.parseInt(ladoField.getText());
                int base = Integer.parseInt(ladoField.getText());
                // Crear un objeto Paciente
                Rectangulo rectangulo = new Rectangulo(base, lado);
        
                // Escribir en el archivo
                System.out.println("Se creó rectangulo");
 
                // Limpiar los campos del formulario
                baseField.setText("");
                alturaField.setText("");
                radioField.setText("");
                ladoField.setText("");
            }
        });
        addButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int altura = Integer.parseInt(ladoField.getText());
                int base = Integer.parseInt(ladoField.getText());
                // Crear un objeto Paciente
                TrianguloRectangulo triangulo = new TrianguloRectangulo(base, altura);
        
                // Escribir en el archivo
                System.out.println("Se creó triangulo");
 
                // Limpiar los campos del formulario
                baseField.setText("");
                alturaField.setText("");
                radioField.setText("");
                ladoField.setText("");
            }
        });
        // Disponer los componentes en la ventana
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormFigura().setVisible(true);
            }
        });
    }
}
