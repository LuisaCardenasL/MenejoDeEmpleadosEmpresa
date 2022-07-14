package manejodeempleadosdeempresa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Lu
 */
public class GUIEmpresa extends JFrame{

    //componentes de la GUI
    private JPanel pDatos, pEste, pBotones, pCentro;
    private JTextField tfNombre, tfID, tfEdad, tfSueldo;
    private JTextArea area;
    private JScrollPane barrasDesplazamiento;
    private JButton bIngreso, bMostrar, bBuscarCargo, bBuscarEmpleado;
    private JLabel lImagen, lNombre, lID, lCargo, lEdad, lSueldo, lResultado;
    private JComboBox<String> cbColecciones;
    private ManejaEventos evento;
    
    public GUIEmpresa() {
        initComponents();
        //configuracion del frame
        setTitle("Manejo de Empleados de Empresa");
        pack(); // se ajusta al tamaño de los componentes
        //setSize(1000, 700);
        setResizable(false); // define si el usuario puede reajustar el tamaño
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        
        //labels
        lNombre = new JLabel("Nombre:");
        lID = new JLabel("Id:");
        lCargo = new JLabel("Cargo:");
        lEdad = new JLabel("Edad:");
        lSueldo = new JLabel("Sueldo");
        lImagen = new JLabel(new ImageIcon("src/imagenes/trabajadorP.png"));
        
        //Botones
        bIngreso = new JButton("Ingresar Empleado");
        bMostrar = new JButton("Mostrar Empleados");
        bBuscarCargo = new JButton("Buscar por Cargo");
        bBuscarEmpleado = new JButton("Buscar por Empleado");
        
        //JTextField
        tfNombre = new JTextField();
        tfID = new JTextField();
        tfEdad = new JTextField();
        tfSueldo = new JTextField();
        
        //Colecciones
        String[] tiposC = {"Seleccione una opcion", "Operario","Conductor","Administrativo","Jefe de Personal"};
        cbColecciones = new JComboBox<>(tiposC);
        
        //JTextArea
        area = new JTextArea(10,50);
        barrasDesplazamiento = new JScrollPane(area);
        
        //escuchas
        ManejaEventos evento = new ManejaEventos();
        bIngreso.addActionListener(evento);
        bMostrar.addActionListener(evento);
        bBuscarCargo.addActionListener(evento);
        bBuscarEmpleado.addActionListener(evento);
        tfNombre.addFocusListener(evento);
        
        //Paneles
        pDatos = new JPanel(new GridLayout(5,2));
        pEste = new JPanel(new BorderLayout());
        pBotones = new JPanel(new GridLayout(2,2));
        pCentro = new JPanel(new GridLayout(1,2));
     
        pDatos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE,3),"Datos del Trabajador"));
        
        pDatos.add(lNombre);
        pDatos.add(tfNombre);
        pDatos.add(lID);
        pDatos.add(tfID);
        pDatos.add(lCargo);
        pDatos.add(cbColecciones);
        pDatos.add(lEdad);
        pDatos.add(tfEdad);
        pDatos.add(lSueldo);
        pDatos.add(tfSueldo);
        
        pBotones.add(bIngreso);
        pBotones.add(bMostrar);
        pBotones.add(bBuscarCargo);
        pBotones.add(bBuscarEmpleado);
        
        pEste.add(pBotones);
        pEste.add(lImagen);
        pEste.add(pBotones, BorderLayout.NORTH);
        pEste.add(lImagen, BorderLayout.CENTER);
        
        pCentro.add(barrasDesplazamiento);
        pCentro.add(pEste);
        
        //adicionando paneles al frame
        add(pDatos, BorderLayout.NORTH);
        add(barrasDesplazamiento, BorderLayout.WEST);
        add(pEste, BorderLayout.EAST);
       }
    
    public void borrarCampos(){
        tfNombre.setText("");
        tfID.setText("");
        tfEdad.setText("");
        tfSueldo.setText("");
    }
    
    public boolean verificarVacio (String dato){
        return dato.trim().equals("");
    }
    
    class ManejaEventos implements ActionListener, FocusListener{

        Empresa empresa;
        
        public ManejaEventos()
        {
            empresa = new Empresa();
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            int bandera = 0;
            if(ae.getSource() == bIngreso)
            {
                String nombre = "", cargo = "";
                int edad = 0, id = 0;
                double salario = 0;
                
                try{
                    nombre = tfNombre.getText();
                    id = Integer.parseInt(tfID.getText());
                    cargo = cbColecciones.getSelectedItem().toString();
                    edad = Integer.parseInt(tfEdad.getText());
                    salario = Double.parseDouble(tfSueldo.getText());
                    if (verificarVacio(nombre) || cargo.equals("Seleccione una opcion") ){
                        area.setText("los datos no estan completos hay campos vacios");
                        bandera++;
                    }
                    
                } catch (NumberFormatException nf){
                    area.setText("Datos numericos invalidos");
                    bandera++;
                }
                
                if(bandera == 0){
                    area.setText(empresa.ingresarEmpleadoEmpresa(nombre, id, cargo, edad, salario));
                    borrarCampos();
                }
                       
            }
            
            if(ae.getSource() == bMostrar)
            {
                area.setText(empresa.mostrarEmpleados());
            } 
            
            if (ae.getSource() == bBuscarCargo){
                area.setText(empresa.buscarCargoEmpleados(cbColecciones.getSelectedItem().toString()));
            } 
            
            if (ae.getSource() == bBuscarEmpleado){
                
                String nombre = "";
                int id = 0;
                try {
                    nombre = tfNombre.getText();
                    id = Integer.parseInt(tfID.getText());
                    if (verificarVacio(nombre)){
                    area.setText("los datos no estan completos hay campos vacios");
                    bandera++;
                    }
                } catch (NumberFormatException e) {
                    area.setText("Recuerde que debe llenar el nombre o el ID para realizar la busqueda");
                    bandera += 2;
                } 
                
                if(bandera == 2){
                    area.setText(empresa.buscarPorEmpleadosNombre(tfNombre.getText()));
                } if(bandera == 1){
                    area.setText(empresa.buscarPorEmpleadosId(Integer.parseInt(tfID.getText())));
                } else {
                    tfNombre.setBorder(BorderFactory.createLineBorder(Color.RED));
                    tfID.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
         }

        @Override
        public void focusGained(FocusEvent e) {
            if (e.getSource() == tfNombre){
                borrarCampos();
                area.setText("");
                tfNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                tfID.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
        
    }
}
