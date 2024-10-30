import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
 
public class PacienteForm extends JFrame {
 
    private JTextField nombreField, edadField, generoField, idField, estaturaField, enfermedadField;
    private DefaultTableModel tableModel;
 
    public PacienteForm() {
        //formato general de la ventana
        setTitle("Registro de Pacientes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
 
        // Crear el formulario de captura
        JPanel formPanel = new JPanel(new GridLayout(7, 2));
        formPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        formPanel.add(nombreField);
 
        formPanel.add(new JLabel("Edad:"));
        edadField = new JTextField();
        formPanel.add(edadField);
 
        formPanel.add(new JLabel("Género:"));
        generoField = new JTextField();
        formPanel.add(generoField);
 
        formPanel.add(new JLabel("Identificación:"));
        idField = new JTextField();
        formPanel.add(idField);
 
        formPanel.add(new JLabel("Estatura:"));
        estaturaField = new JTextField();
        formPanel.add(estaturaField);
 
        formPanel.add(new JLabel("Enfermedad:"));
        enfermedadField = new JTextField();
        formPanel.add(enfermedadField);
 
        // Botón para agregar a la tabla
        JButton addButton = new JButton("Agregar a la Tabla");
        formPanel.add(addButton);
 
        // Configurar la tabla
        String[] columnNames = {"nNombre", "Edad", "Género", "Identificación", "Estatura", "Enfermedad"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
 
        // Añadir acción al botón
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                int edad = Integer.parseInt(edadField.getText());
                String genero = generoField.getText();
                int id = Integer.parseInt(idField.getText());
                float estatura = Float.parseFloat(estaturaField.getText());
                String enfermedad = enfermedadField.getText();
 
                // Crear un objeto Paciente
                Paciente paciente = new Paciente(nombre, edad, genero, id, estatura, enfermedad);
 
 
 
                // Agregar los datos a la tabla
                tableModel.addRow(new Object[]{paciente.getNombre(), paciente.getEdad(), paciente.getGenero(),
                                                paciente.getIdentificacion(), paciente.getEstatura(), paciente.getEnfermedad()});
               
                // Escribir en el archivo
                String nombreArchivo = "historia_clinica.txt";
                paciente.escribirArchivo(nombreArchivo);
 
                // Limpiar los campos del formulario
                nombreField.setText("");
                edadField.setText("");
                generoField.setText("");
                idField.setText("");
                estaturaField.setText("");
                enfermedadField.setText("");
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
                new PacienteForm().setVisible(true);
            }
        });
    }
}
