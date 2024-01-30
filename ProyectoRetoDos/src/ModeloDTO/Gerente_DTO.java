package ModeloDTO;

public class Gerente_DTO {

    private String dni;
    private String usuario;
    private String contrasena;

    /**
     * @param dni
     * @param usuario
     * @param contrasena
     */
    public Gerente_DTO(String dni, String usuario, String contrasena) {
        super();
        this.dni = dni;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Gerente_DTO() {
        // TODO Auto-generated constructor stub
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}