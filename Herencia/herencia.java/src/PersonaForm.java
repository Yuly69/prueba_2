import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonaForm extends JFrame {
    private JTextField nombreField, edadField, carreraField, ocupacionField, salarioField;
    private DefaultTableModel tableModel;

public PersonaForm() {
    //formato general de la ventana
    setTitle("Registro de Personas");
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

    formPanel.add(new JLabel("Carrera:"));
    carreraField = new JTextField();
    formPanel.add(carreraField);

    formPanel.add(new JLabel("Ocupación:"));
    ocupacionField= new JTextField();
    formPanel.add(ocupacionField);

    formPanel.add(new JLabel("Salario:"));
    salarioField = new JTextField();
    formPanel.add(salarioField);

    // Botón para agregar a la tabla
    JButton addButton = new JButton("Agregar Estudiante");
    formPanel.add(addButton);

    JButton addButton2 = new JButton("Agregar Trabajador");
    formPanel.add(addButton2);

    // Configurar la tabla
    String[] columnNames = {"Nombre", "Edad", "Carrera", "Ocupación", "Salario"};
    tableModel = new DefaultTableModel(columnNames, 0);
    JTable table = new JTable(tableModel);

    // Añadir acción al botón 1111111111111111111
    addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = nombreField.getText();
            int edad = Integer.parseInt(edadField.getText());
            String carrera = carreraField.getText();

            // Crear un objeto Persona
            Persona persona = new Persona(nombre, edad);
            Estudiante estudiante= new Estudiante(nombre, edad, carrera);


            // Agregar los datos a la tabla
            tableModel.addRow(new Object[]{persona.getNombre(), persona.getEdad(), estudiante.gerCarrera()});
            // Escribir en el archivo
            String nombreArchivo = "Estudiante.txt";
            persona.escribirArchivo(nombreArchivo);

            // Limpiar los campos del formulario
            nombreField.setText("");
            edadField.setText("");
            carreraField.setText("");
            ocupacionField.setText("");
            salarioField.setText("");

        }
    });
// Añadir acción al botón 22222222222222222
addButton2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = nombreField.getText();
        int edad = Integer.parseInt(edadField.getText());
        String ocupacion = ocupacionField.getText();
        int salario = Integer.parseInt(salarioField.getText());

        // Crear un objeto Persona
        Persona persona = new Persona(nombre, edad);
        Trabajador trabajador= new Trabajador(ocupacion, salario, nombre, edad);


        // Agregar los datos a la tabla, recuerda que lo que no lee, le poner "" para qe deje el espacio en esa columna
        tableModel.addRow(new Object[]{persona.getNombre(), persona.getEdad(), "", trabajador.getOcupacion(), trabajador.getSalario()});
        // Escribir en el archivo
        String nombreArchivo = "Trabajador.txt";
        persona.escribirArchivo(nombreArchivo);

        // Limpiar los campos del formulario
        nombreField.setText("");
        edadField.setText("");
        carreraField.setText("");
        ocupacionField.setText("");
        salarioField.setText("");

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
            new PersonaForm().setVisible(true);
        }
    });
}
}
