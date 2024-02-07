package ModeloDAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Conexion.ConexionSGL;
import ModeloDTO.Fichaje_DTO;

public class Fichaje_DAO implements Patron_DAO<Fichaje_DTO> {
    private static final String SQL_INSERT = "INSERT INTO fichaje (dni, horario_ent, horario_sal, total_horas) VALUES (?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM fichaje WHERE dni = ?";
    private static final String SQL_UPDATE = "UPDATE fichaje SET horario_ent = ?, horario_sal = ?, total_horas = ? WHERE dni = ? AND DATE(horario_ent) = ?";
    private static final String SQL_FIND = "SELECT * FROM fichaje WHERE dni = ?";
    private static final String SQL_FINDALL = "SELECT * FROM fichaje";
    private static final String SQL_FIND_LAST_BY_DNI = "SELECT * FROM fichaje WHERE dni = ? ORDER BY horario_ent DESC LIMIT 1";
    private static final String SQL_FIND_ENTRADA_HOY = "SELECT * FROM fichaje WHERE dni = ? AND DATE(horario_ent) = CURRENT_DATE";
    private static final String SQL_FIND_SALIDA ="SELECT dni, horario_ent, horario_sal, total_horas FROM fichaje "
    		+ "WHERE horario_ent IS NOT NULL AND horario_sal IS NULL";
    ConexionSGL con = ConexionSGL.getInstancia();

    @Override
    public boolean insertar(Fichaje_DTO fichaje) {
        if (existeFichajeEntradaParaHoy(fichaje.getDni())) {
            return false;
        }

        try (PreparedStatement ps = con.getCon().prepareStatement(SQL_INSERT)) {
            ps.setString(1, fichaje.getDni());
            ps.setTimestamp(2, new java.sql.Timestamp(fichaje.getHorarioEntrada().getTime()));

            if (fichaje.getHorarioSalida() != null) {
                ps.setTimestamp(3, new java.sql.Timestamp(fichaje.getHorarioSalida().getTime()));
            } else {
                ps.setNull(3, java.sql.Types.TIMESTAMP);
            }

            ps.setDouble(4, fichaje.getTotalHoras());

            int resultado = ps.executeUpdate();

            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones - puedes mostrar un mensaje de error aquí o lanzar una excepción personalizada si es necesario
            return false;
        }
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

    public boolean actualizar2(Fichaje_DTO fichaje, LocalDate dia) {
        PreparedStatement ps = null;

        try {
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            ps.setTimestamp(1, new java.sql.Timestamp(fichaje.getHorarioEntrada().getTime()));
            ps.setTimestamp(2, new java.sql.Timestamp(fichaje.getHorarioSalida().getTime()));
            ps.setDouble(3, fichaje.getTotalHoras());
            ps.setString(4, fichaje.getDni());
            ps.setDate(5, java.sql.Date.valueOf(dia));

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
    public Fichaje_DTO obtenerUltimoFichajeEntrada(String dni) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.getCon().prepareStatement(SQL_FIND_LAST_BY_DNI);
            ps.setString(1, dni);
            rs = ps.executeQuery();

            while (rs.next()) {
                Timestamp horarioSalida = rs.getTimestamp("horario_sal");
                if (horarioSalida == null) {
                    return new Fichaje_DTO(
                            rs.getString("dni"),
                            rs.getTimestamp("horario_ent"),
                            rs.getTimestamp("horario_sal"),
                            rs.getDouble("total_horas")
                    );
                }
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

    public boolean existeFichajeEntradaParaHoy(String dni) {

        Fichaje_DAO fichajeDAO = new Fichaje_DAO();
        Fichaje_DTO fichajeExistente = fichajeDAO.obtenerFichajeEntradaParaHoy(dni);

        return fichajeExistente != null;
    }
    public Fichaje_DTO obtenerFichajeEntradaParaHoy(String dni) {

        try (PreparedStatement ps = con.getCon().prepareStatement(SQL_FIND_ENTRADA_HOY)) {
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
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
        }
        return null;
    }
    public ArrayList<Fichaje_DTO> obtenerFichajesSinSalida() {
        ArrayList<Fichaje_DTO> fichajes = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.getCon().prepareStatement(SQL_FIND_SALIDA);
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
