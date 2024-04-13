import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PizzaInterface {
    private JFrame frame;
    private JTextField textFieldNombre;
    private JTextField textFieldTelefono;
    private JTextField textFieldDireccion;
    private JComboBox<String> comboBoxTipoPizza;
    private JComboBox<String> comboBoxTamanoPizza;
    private int entregadoCounter = 0;
    private int pendienteCounter = 0;
    private JLabel labelCounter;
    private DefaultListModel<String> ingresosListModel;
    private JList<String> ingresosList;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PizzaInterface window = new PizzaInterface();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PizzaInterface() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Pizza El Buen Sabor!!!");
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        JLabel labelNombre = new JLabel("Nombre:");
        frame.getContentPane().add(labelNombre);

        textFieldNombre = new JTextField();
        frame.getContentPane().add(textFieldNombre);
        textFieldNombre.setColumns(10);

        JLabel labelTelefono = new JLabel("Telefono:");
        frame.getContentPane().add(labelTelefono);

        textFieldTelefono = new JTextField();
        frame.getContentPane().add(textFieldTelefono);
        textFieldTelefono.setColumns(10);

        JLabel labelDireccion = new JLabel("Dirección:");
        frame.getContentPane().add(labelDireccion);

        textFieldDireccion = new JTextField();
        frame.getContentPane().add(textFieldDireccion);
        textFieldDireccion.setColumns(10);

        JLabel labelTipoPizza = new JLabel("Tipo de Pizza:");
        frame.getContentPane().add(labelTipoPizza);

        String[] tiposPizza = {"Suprema", "Margarita", "Hawaiana" , "Pepperoni" , "Jamon y hongos", "Napolitana" }; // Ejemplo de tipos de pizza
        comboBoxTipoPizza = new JComboBox<>(tiposPizza);
        frame.getContentPane().add(comboBoxTipoPizza);

        JLabel labelTamanoPizza = new JLabel("Tamaño de Pizza:");
        frame.getContentPane().add(labelTamanoPizza);

        String[] tamanosPizza = {"Personal", "Mediana", "Grande", "Pequeña"}; // Ejemplo de tamaños de pizza
        comboBoxTamanoPizza = new JComboBox<>(tamanosPizza);
        frame.getContentPane().add(comboBoxTamanoPizza);

        JButton buttonBuscar = new JButton("Buscar");
        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementa la funcionalidad de búsqueda aquí
            }
        });
        frame.getContentPane().add(buttonBuscar);

        JButton buttonNuevo = new JButton("Nuevo");
        buttonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textFieldNombre.getText();
                String telefono = textFieldTelefono.getText();
                String direccion = textFieldDireccion.getText();
                String tipoPizza = (String) comboBoxTipoPizza.getSelectedItem();
                String tamanoPizza = (String) comboBoxTamanoPizza.getSelectedItem();

                // Agrega el nuevo ingreso a la lista
                ingresosListModel.addElement("Nombre: " + nombre + ", Teléfono: " + telefono + ", Dirección: " + direccion + ", Tipo de Pizza: " + tipoPizza + ", Tamaño de Pizza: " + tamanoPizza);

                // Incrementa el contador de pendientes
                pendienteCounter++;

                // Actualiza el contador en la etiqueta
                updateCounterLabel();

                // Limpia los campos de entrada
                clearInputFields();
            }
        });
        frame.getContentPane().add(buttonNuevo);

        JButton buttonEntregado = new JButton("Entregado");
        buttonEntregado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entregadoCounter++;
                pendienteCounter--;
                updateCounterLabel();
            }
        });
        frame.getContentPane().add(buttonEntregado);

        JButton buttonLimpiar = new JButton("Limpiar");
        buttonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInputFields();
            }
        });
        frame.getContentPane().add(buttonLimpiar);

        ingresosListModel = new DefaultListModel<>();
        ingresosList = new JList<>(ingresosListModel);
        JScrollPane scrollPane = new JScrollPane(ingresosList);
        scrollPane.setPreferredSize(new Dimension(400, 100));
        frame.getContentPane().add(scrollPane);

        labelCounter = new JLabel("Entregados: " + entregadoCounter + ", Pendientes: " + pendienteCounter);
        frame.getContentPane().add(labelCounter);
    }

    private void updateCounterLabel() {
        labelCounter.setText("Entregados: " + entregadoCounter + ", Pendientes: " + pendienteCounter);
    }

    private void clearInputFields() {
        textFieldNombre.setText("");
        textFieldTelefono.setText("");
        textFieldDireccion.setText("");
        comboBoxTipoPizza.setSelectedIndex(0);
        comboBoxTamanoPizza.setSelectedIndex(0);
    }
}
