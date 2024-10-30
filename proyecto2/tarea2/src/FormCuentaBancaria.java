import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class FormCuentaBancaria extends JFrame {
    private JTextField nombreField, apellidoField, numeroField, tipoField;
    private DefaultTableModel tableModel;
    private JComboBox<String> tipoCuentaBox;
 
 
public FormCuentaBancaria() {
    //formato general de la ventana
    setTitle("Cuenta Bancaria");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 400);
    setLocationRelativeTo(null);
 
    // Crear el formulario de captura
    JPanel formPanel = new JPanel(new GridLayout(8, 2));
    formPanel.add(new JLabel("Nombre del titular:"));
    nombreField = new JTextField();
    formPanel.add(nombreField);
 
    formPanel.add(new JLabel("Apellido:"));
    apellidoField = new JTextField();
    formPanel.add(apellidoField);
 
    formPanel.add(new JLabel("Número de cuenta:"));
    numeroField = new JTextField();
    formPanel.add(numeroField);
 
    formPanel.add(new JLabel("Tipo de cuenta:"));
    String[] tipos = {"AHORROS", "CORRIENTE"}; // Opciones para el JComboBox
    tipoCuentaBox = new JComboBox<>(tipos); // Crear el JComboBox con opciones
    formPanel.add(tipoCuentaBox);
   
 
     
    // Botón para agregar a la tabla
    JButton addButton1 = new JButton("Crear cuenta");
    formPanel.add(addButton1);
 
    JButton addButton2 = new JButton("Consultar saldo");
    formPanel.add(addButton2);
 
    JButton addButton3 = new JButton("Agregar al saldo");
    formPanel.add(addButton3);
 
    JButton addButton4 = new JButton("Retirar del saldo");
    formPanel.add(addButton4);
 
    JButton transferButton = new JButton("Transferir");
    formPanel.add(transferButton);
 
    // Configurar la tabla
    String[] columnNames = {"Nombre", "Apellido", "Numero de cuenta", "Tipo de cuenta", "Saldo"};
    tableModel = new DefaultTableModel(columnNames, 0);
    JTable table = new JTable(tableModel);
 
    // Añade esto en tu constructor después de crear la tabla
table.getSelectionModel().addListSelectionListener(event -> {
    int selectedRow = table.getSelectedRow();
    if (selectedRow != -1) { // Asegúrate de que haya una fila seleccionada
        nombreField.setText(tableModel.getValueAt(selectedRow, 0).toString());
        apellidoField.setText(tableModel.getValueAt(selectedRow, 1).toString());
        numeroField.setText(tableModel.getValueAt(selectedRow, 2).toString());
        tipoField.setText(tableModel.getValueAt(selectedRow, 3).toString());
    }
});
transferButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int cuentaOrigen = table.getSelectedRow(); // Obtener la fila seleccionada (cuenta de origen)
       
        if (cuentaOrigen == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta de origen en la tabla.");
            return;
        }
       
        // Pedir al usuario que seleccione la cuenta de destino
        String numeroCuentaDestino = JOptionPane.showInputDialog("Ingrese el número de cuenta de destino:");
       
        if (numeroCuentaDestino == null || numeroCuentaDestino.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número de cuenta de destino.");
            return;
        }
       
        // Buscar la cuenta de destino en la tabla
        int cuentaDestino = -1;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 2).equals(numeroCuentaDestino)) {
                cuentaDestino = i;
                break;
            }
        }
 
        if (cuentaDestino == -1) {
            JOptionPane.showMessageDialog(null, "Cuenta de destino no encontrada.");
            return;
        }
       
        // Pedir la cantidad a transferir
        try {
            float cantidadTransferir = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad a transferir:"));
           
            // Verificar si la cuenta de origen tiene saldo suficiente
            float saldoOrigen = Float.parseFloat(tableModel.getValueAt(cuentaOrigen, 4).toString());
            if (cantidadTransferir > saldoOrigen) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente en la cuenta de origen.");
                return;
            }
 
            // Realizar la transferencia: restar de origen y sumar a destino
            float saldoDestino = Float.parseFloat(tableModel.getValueAt(cuentaDestino, 4).toString());
            tableModel.setValueAt(saldoOrigen - cantidadTransferir, cuentaOrigen, 4);
            tableModel.setValueAt(saldoDestino + cantidadTransferir, cuentaDestino, 4);
 
            JOptionPane.showMessageDialog(null, "Transferencia realizada con éxito.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida.");
        }
    }
});
    // Añadir acción al botón 1111111111111111111 (Consultar datos)
    addButton1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = nombreField.getText();
            String apellido = apellidoField.getText();
            String numero_Cuenta = numeroField.getText();
            String tipo_cuenta = tipoCuentaBox.getSelectedItem().toString(); // Obtener el tipo desde el JComboBox
            float saldo = 0; // Inicializar saldo en 0 por defecto
 
            if (nombre.isEmpty() || apellido.isEmpty() || numero_Cuenta.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                return;
            }
 
            // Crear un objeto cuentaBancaria
            cuentaBancaria cuenta_b = new cuentaBancaria(nombre, apellido, numero_Cuenta, tipo_cuenta, saldo);
 
            // Agregar los datos a la tabla
            tableModel.addRow(new Object[]{cuenta_b.getNombre(), cuenta_b.getApellido(), cuenta_b.getNumeroCuenta(), cuenta_b.getTipoCuenta(), cuenta_b.getSaldo()});
 
            // Limpiar los campos de texto después de agregar los datos
            nombreField.setText("");
            apellidoField.setText("");
            numeroField.setText("");
            tipoCuentaBox.setSelectedIndex(0); // Reiniciar la selección del combo box
        }
    });
// Añadir acción al botón 22222222222222222 (Consultar saldo)
addButton2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow(); // Obtener la fila seleccionada
        if (selectedRow != -1) { // Verificar si hay una fila seleccionada
            // Obtener el saldo de la fila seleccionada
            float saldoActual = Float.parseFloat(tableModel.getValueAt(selectedRow, 4).toString());
            JOptionPane.showMessageDialog(null, "Saldo de la cuenta: " + saldoActual);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta en la tabla.");
        }
    }
});
 
 
// Añadir acción al botón 333333333333333333333 (Agregar al saldo)
// Añadir acción al botón 333333333333333333333 (Agregar al saldo)
addButton3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow(); // Obtener la fila seleccionada
        if (selectedRow != -1) { // Verificar si hay una fila seleccionada
            try {
                // Ingresar la cantidad y convertirla a número
                float cantidad = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad a agregar:"));
               
                // Obtener el saldo actual de la fila seleccionada
                float saldoActual = Float.parseFloat(tableModel.getValueAt(selectedRow, 4).toString());
               
                // Actualizar el saldo sumándole la cantidad ingresada
                tableModel.setValueAt(saldoActual + cantidad, selectedRow, 4);
               
                JOptionPane.showMessageDialog(null, "Saldo actualizado.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Cantidad no válida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta en la tabla.");
        }
    }
});
 
 
// Añadir acción al botón 444444444444444444444444 (Retirar del saldo)
addButton4.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow(); // Obtener la fila seleccionada
        if (selectedRow != -1) { // Verificar si hay una fila seleccionada
            try {
                // Pedir al usuario que ingrese la cantidad a retirar
                float cantidad = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad a retirar:"));
               
                // Obtener el saldo actual de la fila seleccionada
                float saldoActual = Float.parseFloat(tableModel.getValueAt(selectedRow, 4).toString());
               
                // Verificar si hay suficiente saldo para retirar
                if (cantidad > saldoActual) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                } else {
                    // Actualizar el saldo restando la cantidad retirada
                    tableModel.setValueAt(saldoActual - cantidad, selectedRow, 4);
                    JOptionPane.showMessageDialog(null, "Saldo actualizado.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Cantidad no válida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una cuenta en la tabla.");
        }
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
            new FormCuentaBancaria().setVisible(true);
        }
    });
}
}
 

 