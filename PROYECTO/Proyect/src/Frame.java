import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import TimSort.Timesort;

public class Frame extends JFrame {

    final private Font mainFont = new Font("Arial", Font.BOLD, 18);
    int[] al = new int[5];
    static String Archivo;

    public Frame() {
        inicializar();
    }

    public void inicializar() {
        JLabel lbSeleccionarArchivo = new JLabel("Seleccione el archivo");
        lbSeleccionarArchivo.setFont(mainFont);
        JLabel lbSeleccionarMetodo = new JLabel("Seleccionar Método");
        lbSeleccionarMetodo.setFont(mainFont);
        JButton importButton = new JButton("Importar Archivo");
        importButton.setFont(mainFont);
        String[] items = { " Ascendente", " Descendente" };
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setFont(mainFont);
        JLabel lbSeleccionarAlgoritmo = new JLabel("Seleccionar Algoritmo");
        lbSeleccionarAlgoritmo.setFont(mainFont);
        String[] items2 = { " Quick Sort", " Merge Sort", " TimSort" };
        JComboBox<String> comboBox2 = new JComboBox<>(items2);
        comboBox2.setFont(mainFont);
        JButton importButton3 = new JButton("Ordenar Archivo");
        importButton3.setFont(mainFont);
        JButton importButton2 = new JButton("Guardar Archivo");
        importButton2.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 5, 5));
        formPanel.add(lbSeleccionarArchivo);
        formPanel.add(importButton);
        formPanel.add(lbSeleccionarMetodo);
        formPanel.add(comboBox);
        formPanel.add(lbSeleccionarAlgoritmo);
        formPanel.add(comboBox2);
        formPanel.add(importButton3);
        formPanel.add(importButton2);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.add(formPanel, BorderLayout.CENTER);

        add(mainPanel);
        setTitle("Herramienta de Ordenamiento");
        setSize(500, 400);
        setMinimumSize(new java.awt.Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
                    Archivo = selectedFile.getAbsolutePath();
                }
            }
        });

        importButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeerArchivo leer = new LeerArchivo();
                leer.lectura(Archivo, al);
                if (comboBox.getSelectedItem().toString().equals(" Ascendente")) {
                    if (comboBox2.getSelectedItem().toString().equals(" Quick Sort")) {
                        QuickSortA qsA = new QuickSortA();
                        qsA.quicksort(al, 0, al.length - 1);
                        Imprimir imp = new Imprimir();
                        imp.imprimir(al);
                    }
                    if (comboBox2.getSelectedItem().toString().equals(" Merge Sort")) {
                        Merge mrg = new Merge();
                        mrg.mergeSort(al);
                        Imprimir imp = new Imprimir();
                        imp.imprimir(al);
                    }
                    if (comboBox2.getSelectedItem().toString().equals(" TimSort")) {
                        boolean ascendente = comboBox.getSelectedItem().toString().equals(" Ascendente");
                        int[] sortedArray = Timesort.timesort(al.clone(), ascendente);
                        Imprimir imp = new Imprimir();
                        imp.imprimir(sortedArray);
                    }
                } else if (comboBox.getSelectedItem().toString().equals(" Descendente")) {
                    if (comboBox2.getSelectedItem().toString().equals(" Quick Sort")) {
                        QuickSortD qsD = new QuickSortD();
                        qsD.quicksort(al, 0, al.length - 1);
                        Imprimir imp = new Imprimir();
                        imp.imprimir(al);
                    }
                }
                JOptionPane.showMessageDialog(null, comboBox2.getSelectedItem().toString());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Frame();
            }
        });
    }
}
