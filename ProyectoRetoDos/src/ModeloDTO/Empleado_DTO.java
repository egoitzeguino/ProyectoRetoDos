package ModeloDTO;

import java.sql.Date;

public class Empleado_DTO {

    private String dni;
    private String nombre;
    private String apellido;
    private Date antiguedad;
    private double salario;
    private int cantComandas;
    private int cantCocteles;
    private String tipoEmpleado;

    /**
     * @param dni
     * @param nombre
     * @param apellido
     * @param antiguedad
     * @param salario
     * @param cantComandas
     * @param cantCocteles
     * @param tipoEmpleado
     */
    public Empleado_DTO(String dni, String nombre, String apellido, Date antiguedad,
                         double salario, int cantComandas, int cantCocteles, String tipoEmpleado) {
        super();
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.antiguedad = antiguedad;
        this.salario = salario;
        this.cantComandas = cantComandas;
        this.cantCocteles = cantCocteles;
        this.tipoEmpleado = tipoEmpleado;
    }

    public Empleado_DTO() {
        // TODO Auto-generated constructor stub
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Date antiguedad) {
        this.antiguedad = antiguedad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getCantComandas() {
        return cantComandas;
    }

    public void setCantComandas(int cantComandas) {
        this.cantComandas = cantComandas;
    }

    public int getCantCocteles() {
        return cantCocteles;
    }

    public void setCantCocteles(int cantCocteles) {
        this.cantCocteles = cantCocteles;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
}
