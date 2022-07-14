package manejodeempleadosdeempresa;

import java.util.ArrayList;

/**
 *
 * @author Lu
 */
public class Empleado {
    //declaracion de variables de clase
    private String nombre;
    private int id;
    private String cargo;
    private int edad;
    private double salario;
    
    /**
     * constructor de un empleado que revibe los datos para inicialiar los empleados de una empresa
     * @param nombre
     * @param id
     * @param cargo
     * @param edad
     * @param salario 
     */
    public Empleado(String nombre, int id, String cargo, int edad, double salario)
    {        
        this.nombre = nombre;
        this.id = id;
        this.cargo = cargo;
        this.edad = edad;
        this.salario = salario;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public String getCargo(){
        return cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public double getSalario(){
        return salario;
    }
    
    public void setSalario(double sueldo){
        this.salario = sueldo;
    }
    
    public String toString()
    {
        String dato = "Nombre: " + nombre + "\t" + "ID: " + id + "\t" + "Cargo:" + cargo + "\t" + "Edad: " + edad + "\t" + "Salario: " + salario;
        return dato;
    }
}
