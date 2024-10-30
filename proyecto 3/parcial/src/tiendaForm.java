import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tiendaForm extends JFrame {
    private JTextField HamburguesaField, salchipapaField, perroField, gaseosaField, teField, aguaField;
    private DefaultTableModel tableModel;
    private inventario inventarioActual;

    public tiendaForm() {
        // Inicializar inventario
        inventarioActual = new inventario(100, 100, 100, 100, 100, 100); // Ejemplo de inventario inicial

        //formato general de la ventana
        setTitle("Registro de pedido");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Crear el formulario de captura
        JPanel formPanel = new JPanel(new GridLayout(8, 2));
        formPanel.add(new JLabel("Hamburguesas:"));
        HamburguesaField = new JTextField();
        formPanel.add(HamburguesaField);

        formPanel.add(new JLabel("Salchipapa:"));
        salchipapaField = new JTextField();
        formPanel.add(salchipapaField);

        formPanel.add(new JLabel("Perro:"));
        perroField = new JTextField();
        formPanel.add(perroField);

        formPanel.add(new JLabel("Gaseosa:"));
        gaseosaField = new JTextField();
        formPanel.add(gaseosaField);

        formPanel.add(new JLabel("Te:"));
        teField = new JTextField();
        formPanel.add(teField);

        formPanel.add(new JLabel("Agua:"));
        aguaField = new JTextField();
        formPanel.add(aguaField);

        // Botón para agregar a la tabla
        JButton addButton = new JButton("Agregar al carrito");
        formPanel.add(addButton);

        JButton removeButton = new JButton("Quitar del carrito");
        formPanel.add(removeButton);

        JButton buyButton = new JButton("Comprar");  // Nuevo botón "Comprar"
        formPanel.add(buyButton);

        // Configurar la tabla
        String[] columnNames = {"Hamburguesa", "Salchipapa", "Perro", "Gaseosa", "Te", "Agua"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Añadir acción al botón "Agregar al carrito"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hamburguesa = Integer.parseInt(HamburguesaField.getText());
                int salchipapa = Integer.parseInt(salchipapaField.getText());
                int perro = Integer.parseInt(perroField.getText());
                int gaseosa = Integer.parseInt(gaseosaField.getText());
                int te = Integer.parseInt(teField.getText());
                int agua = Integer.parseInt(aguaField.getText());

                // Verificar si hay suficientes productos en el inventario
                if (inventarioActual.reducirHamburguesa(hamburguesa) &&
                    inventarioActual.reducirSalchipapa(salchipapa) &&
                    inventarioActual.reducirPerro(perro) &&
                    inventarioActual.reducirGaseosa(gaseosa) &&
                    inventarioActual.reducirTe(te) &&
                    inventarioActual.reducirAgua(agua)) {
                    
                    // Agregar los datos a la tabla
                    tableModel.addRow(new Object[]{hamburguesa, salchipapa, perro, gaseosa, te, agua});

                    // Limpiar los campos del formulario
                    HamburguesaField.setText("");
                    salchipapaField.setText("");
                    perroField.setText("");
                    gaseosaField.setText("");
                    teField.setText("");
                    aguaField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No hay suficiente inventario para completar el pedido.");
                }
            }
        });

        // Añadir acción al botón "Quitar del carrito"
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow(); // Obtener la fila seleccionada
                if (selectedRow != -1) {
                    // Obtener las cantidades de la fila seleccionada
                    int hamburguesa = (int) tableModel.getValueAt(selectedRow, 0);
                    int salchipapa = (int) tableModel.getValueAt(selectedRow, 1);
                    int perro = (int) tableModel.getValueAt(selectedRow, 2);
                    int gaseosa = (int) tableModel.getValueAt(selectedRow, 3);
                    int te = (int) tableModel.getValueAt(selectedRow, 4);
                    int agua = (int) tableModel.getValueAt(selectedRow, 5);

                    // Aumentar los productos en el inventario
                    inventarioActual.aumentarHamburguesa(hamburguesa);
                    inventarioActual.aumentarSalchipapa(salchipapa);
                    inventarioActual.aumentarPerro(perro);
                    inventarioActual.aumentarGaseosa(gaseosa);
                    inventarioActual.aumentarTe(te);
                    inventarioActual.aumentarAgua(agua);

                    // Eliminar la fila seleccionada
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar.");
                }
            }
        });

        // Añadir acción al botón "Comprar"
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableModel.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "El carrito está vacío. Agrega productos antes de comprar.");
                } else {
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas finalizar la compra?", "Confirmar compra", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        // Limpiar la tabla (finalizar la compra)
                        tableModel.setRowCount(0);
                        JOptionPane.showMessageDialog(null, "¡Compra realizada con éxito!");
                    }
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
                new tiendaForm().setVisible(true);
            }
        });
    }
}
