package ModeloDTO;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fichaje_DTO {

	private String dni;
    private Timestamp horarioEntrada;
    private Timestamp horarioSalida;
    private double totalHoras;

    public Fichaje_DTO(String dni, Timestamp horarioEntrada, Timestamp horarioSalida, double totalHoras) {
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

    public Timestamp getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(Timestamp horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public Timestamp getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(Timestamp horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public double getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(double totalHoras) {
        this.totalHoras = totalHoras;
    }
}
