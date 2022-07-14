package manejodeempleadosdeempresa;

import java.util.ArrayList;
import javax.print.attribute.standard.JobPriority;
import javax.swing.JOptionPane;

/**
 *
 * @author Lu
 */
public class Empresa {
    //declaracion de variables de clase
    private ArrayList<Empleado> empleados;
    
    /**
     * Constructor de la calse
     */
    public Empresa(){
        empleados = new ArrayList<>();
    }
    
    /**
     * Metodo que se utiliza para almacenar un empleado en el ArrayList empleados
     * @param nombre = recibe el nombre del empleado
     * @param id = recibe el id del empleado
     * @param tipoCargo = recibe el cargo del empleado
     * @param edad = recibe la edad del empleado
     * @param salario = recibe el salario del empleado
     * @return = mensasje de confirmacion si el empleado fue almacenado con exito
     */
    public String ingresarEmpleadoEmpresa(String nombre, int id, String tipoCargo, int edad, double salario)
    {
        String mensajeSalida = "";
        empleados.add(new Empleado(nombre, id, tipoCargo, edad, salario));
        mensajeSalida = "se almaceno el empleado " + nombre + "con exito";
        return mensajeSalida;
    }
    
    /**
     * Metodo para mostrar los empleados de la empresa
     * @return los empleados de la empresa con todos sus datos
     */
    public String mostrarEmpleados(){
        String listaEmpleados = "";
        listaEmpleados = "Los empleados de la empresa son:\n";
        for (int i = 0; i <empleados.size(); i++)
        {
            listaEmpleados += empleados.get(i).toString()+"\n";
        }
        return listaEmpleados;
    }
    
    /**
     * Metodo para buscar empleados por cargo
     * @param cargo = recibe cual es el cargo a buscar
     * @return = el nombre y la edad del empleado
     */
    public String buscarCargoEmpleados(String cargo){
        String listaEmpleadosCargo = "";
        listaEmpleadosCargo = "Los empleados con cargo " + cargo + " son:\n";
        for (int i = 0; i <empleados.size(); i++)
        {
            if (empleados.get(i).getCargo().equalsIgnoreCase(cargo)){ //cargo es el dato recibido por parámetro
              listaEmpleadosCargo += (empleados.get(i).getNombre()+ empleados.get(i).getEdad()).toString()+"\n";
            }
        }
        return listaEmpleadosCargo;
    }
    
    /**
     * Metodo para buscar empleados por el nombre
     * @param nombre = recibe el nombre del empleado
     * @return = toda la informacion del empleado que se esta buscando
     */
    public String buscarPorEmpleadosNombre(String nombre){
        String datosEmpleadoNombre = "";
        datosEmpleadoNombre = "La informacion del empleado con nombre " + nombre + " es:\n";
        for (int i = 0; i <empleados.size(); i++)
        {
            if (empleados.get(i).getNombre().equalsIgnoreCase(nombre)){ //cargo es el dato recibido por parámetro
              datosEmpleadoNombre += empleados.get(i).toString();
            }
        }
        return datosEmpleadoNombre;
    }
    
    /**
     * Metodo para buscar empleados por id
     * @param id = recibe el id del empleado
     * @return = toda la informacion del empleado que se esta buscando
     */
    public String buscarPorEmpleadosId(int id){
        String datosEmpleadoID = "";
        datosEmpleadoID = "La informacion del empleado con id: " + id + " solicitado es:\n";
        for (int i = 0; i <empleados.size(); i++)
        {
            if (empleados.get(i).getID() == id){
              datosEmpleadoID += empleados.get(i).toString();
            }
        }
        return datosEmpleadoID;
    }
}
