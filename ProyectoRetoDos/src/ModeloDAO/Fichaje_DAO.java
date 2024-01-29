package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Conexion.ConexionSGL;
import ModeloDTO.Fichaje_DTO;

public class Fichaje_DAO implements Patron_DAO<Fichaje_DTO> {
    private static final String SQL_INSERT = "INSERT INTO fichaje (dni, horario_ent, horario_sal, total_horas) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM fichaje WHERE dni = ?";
    private static final String SQL_UPDATE = "UPDATE fichaje SET horario_ent = ?, horario_sal = ?, total_horas = ? WHERE dni = ?";
    private static final String SQL_FIND = "SELECT * FROM fichaje WHERE dni = ?";
    private static final String SQL_FINDALL = "SELECT * FROM fichaje";

    ConexionSGL con = ConexionSGL.getInstancia();

    @Override
    public boolean insertar(Fichaje_DTO fichaje) {
        PreparedStatement ps = null;
        try {
            ps = con.getCon().prepareStatement(SQL_INSERT);
            ps.setString(1, fichaje.getDni());
            ps.setTimestamp(2, new java.sql.Timestamp(fichaje.getHorarioEntrada().getTime()));
            ps.setTimestamp(3, new java.sql.Timestamp(fichaje.getHorarioSalida().getTime()));
            ps.setDouble(4, fichaje.getTotalHoras());

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
    public boolean actualizar(Fichaje_DTO fichaje) {
        PreparedStatement ps = null;
        try {
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            ps.setTimestamp(1, new java.sql.Timestamp(fichaje.getHorarioEntrada().getTime()));
            ps.setTimestamp(2, new java.sql.Timestamp(fichaje.getHorarioSalida().getTime()));
            ps.setDouble(3, fichaje.getTotalHoras());
            ps.setString(4, fichaje.getDni());

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
    public Fichaje_DTO buscar(Object pk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.getCon().prepareStatement(SQL_FIND);
            ps.setString(1, (String) pk);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Fichaje_DTO(
                        rs.getString("dni"),
                        rs.getTimestamp("horario_ent"),
                        rs.getTimestamp("horario_sal"),
                        rs.getDouble("total_horas")
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
    public ArrayList<Fichaje_DTO> listarTodos() {
        ArrayList<Fichaje_DTO> fichajes = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.getCon().prepareStatement(SQL_FINDALL);

            rs = ps.executeQuery();

            while (rs.next()) {
                Fichaje_DTO fichaje = new Fichaje_DTO(
                        rs.getString("dni"),
                        rs.getTimestamp("horario_ent"),
                        rs.getTimestamp("horario_sal"),
                        rs.getDouble("total_horas")
                );
                fichajes.add(fichaje);
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
        return fichajes;
    }
}
