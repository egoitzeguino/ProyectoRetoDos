package ModeloDTO;

import java.util.Date;

public class Fichaje_DTO {

    private String dni;
    private Date horarioEntrada;
    private Date horarioSalida;
    private double totalHoras;

    /**
     * @param dni
     * @param horarioEntrada
     * @param horarioSalida
     * @param totalHoras
     */
    public Fichaje_DTO(String dni, Date horarioEntrada, Date horarioSalida, double totalHoras) {
        super();
        this.dni = dni;
        this.horarioEntrada = horarioEntrada;
        this.horarioSalida = horarioSalida;
        this.totalHoras = totalHoras;
    }

    public Fichaje_DTO() {
        // TODO Auto-generated constructor stub
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Date horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Date getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(Date horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public double getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(double totalHoras) {
        this.totalHoras = totalHoras;
    }
}
