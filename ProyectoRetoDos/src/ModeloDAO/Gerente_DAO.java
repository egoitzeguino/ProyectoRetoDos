package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.ConexionSGL;
import ModeloDTO.Empleado_DTO;
import ModeloDTO.Gerente_DTO;

public class Gerente_DAO implements Patron_DAO<Gerente_DTO> {
    private static final String SQL_INSERT = "INSERT INTO gerente (dniFk, usuario, contrasena) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM gerente WHERE dniFk = ?";
    private static final String SQL_UPDATE = "UPDATE gerente SET usuario = ?, contrasena = ? WHERE dniFk = ?";
    private static final String SQL_FIND = "SELECT * FROM gerente WHERE dniFk = ?";
    private static final String SQL_FINDALL = "SELECT * FROM gerente";
    private static final String SQL_FIND_BY_USERNAME = "SELECT * FROM gerente WHERE usuario = ?";

    ConexionSGL con = ConexionSGL.getInstancia();

    @Override
    public boolean insertar(Gerente_DTO gerente) {
        PreparedStatement ps = null;
        try {
            ps = con.getCon().prepareStatement(SQL_INSERT);
            ps.setString(1, gerente.getDni());
            ps.setString(2, gerente.getUsuario());
            ps.setString(3, gerente.getContrasena());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean borrar(Object pk) {
        PreparedStatement ps = null;
        try {
            ps = con.getCon().prepareStatement(SQL_DELETE);
            ps.setString(1, (String) pk);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean actualizar(Gerente_DTO gerente) {
        PreparedStatement ps = null;
        try {
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            ps.setString(1, gerente.getUsuario());
            ps.setString(2, gerente.getContrasena());
            ps.setString(3, gerente.getDni());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Gerente_DTO buscar(Object pk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.getCon().prepareStatement(SQL_FIND);
            ps.setString(1, (String) pk);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Gerente_DTO(
                        rs.getString("dniFk"),
                        rs.getString("usuario"),
                        rs.getString("contrasena")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ArrayList<Gerente_DTO> listarTodos() {
        ArrayList<Gerente_DTO> gerentes = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.getCon().prepareStatement(SQL_FINDALL);

            rs = ps.executeQuery();

            while (rs.next()) {
                Gerente_DTO gerente = new Gerente_DTO(
                        rs.getString("dniFk"),
                        rs.getString("usuario"),
                        rs.getString("contrasena")
                );
                gerentes.add(gerente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return gerentes;
    }
    public Gerente_DTO buscarPorUsuario(String usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.getCon().prepareStatement(SQL_FIND_BY_USERNAME);
            ps.setString(1, usuario);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Gerente_DTO(
                        rs.getString("dniFk"),
                        rs.getString("usuario"),
                        rs.getString("contrasena")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}