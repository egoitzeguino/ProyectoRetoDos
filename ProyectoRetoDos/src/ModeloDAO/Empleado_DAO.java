package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.ConexionSGL;
import ModeloDTO.Empleado_DTO;

public class Empleado_DAO implements Patron_DAO<Empleado_DTO> {
    private static final String SQL_INSERT = "INSERT INTO empleado (dni, nombre_emp, apel_emp, antiguedad, salario, cant_comandas, cant_cocteles, tipo_emp) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE dni = ?";
    private static final String SQL_UPDATE = "UPDATE empleado SET nombre_emp = ?, apel_emp = ?, antiguedad = ?, salario = ?, cant_comandas = ?, cant_cocteles = ?, tipo_emp = ? WHERE dni = ?";
    private static final String SQL_FIND = "SELECT * FROM empleado WHERE dni = ?";
    private static final String SQL_FINDALL = "SELECT * FROM empleado";

    ConexionSGL con = ConexionSGL.getInstancia();

    @Override
    public boolean insertar(Empleado_DTO empleado) {
        PreparedStatement ps = null;
        try {
            ps = con.getCon().prepareStatement(SQL_INSERT);
            ps.setString(1, empleado.getDni());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellido());
            ps.setDate(4, empleado.getAntiguedad());
            ps.setDouble(5, empleado.getSalario());
            ps.setInt(6, empleado.getCantComandas());
            ps.setInt(7, empleado.getCantCocteles());
            ps.setString(8, empleado.getTipoEmpleado());

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
    public boolean actualizar(Empleado_DTO empleado) {
        PreparedStatement ps = null;
        try {
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setDate(3, empleado.getAntiguedad());
            ps.setDouble(4, empleado.getSalario());
            ps.setInt(5, empleado.getCantComandas());
            ps.setInt(6, empleado.getCantCocteles());
            ps.setString(7, empleado.getTipoEmpleado());
            ps.setString(8, empleado.getDni());

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
    public Empleado_DTO buscar(Object pk) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.getCon().prepareStatement(SQL_FIND);
            ps.setString(1, (String) pk);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Empleado_DTO(
                        rs.getString("dni"),
                        rs.getString("nombre_emp"),
                        rs.getString("apel_emp"),
                        rs.getDate("antiguedad"),
                        rs.getDouble("salario"),
                        rs.getInt("cant_comandas"),
                        rs.getInt("cant_cocteles"),
                        rs.getString("tipo_emp")
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
    public ArrayList<Empleado_DTO> listarTodos() {
        ArrayList<Empleado_DTO> empleados = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.getCon().prepareStatement(SQL_FINDALL);

            rs = ps.executeQuery();

            while (rs.next()) {
                Empleado_DTO empleado = new Empleado_DTO(
                        rs.getString("dni"),
                        rs.getString("nombre_emp"),
                        rs.getString("apel_emp"),
                        rs.getDate("antiguedad"),
                        rs.getDouble("salario"),
                        rs.getInt("cant_comandas"),
                        rs.getInt("cant_cocteles"),
                        rs.getString("tipo_emp")
                );
                empleados.add(empleado);
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
        return empleados;
    }
    public ArrayList<Empleado_DTO> listarTodos2(String tipoEmpleado) {
        ArrayList<Empleado_DTO> empleados = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL_FIND_BY_TYPE = "SELECT * FROM empleado WHERE tipo_emp = ?";

        try {
            ps = con.getCon().prepareStatement(tipoEmpleado != null ? SQL_FIND_BY_TYPE : SQL_FINDALL);

            // Set the parameter if tipoEmpleado is provided
            if (tipoEmpleado != null) {
                ps.setString(1, tipoEmpleado);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                Empleado_DTO empleado = new Empleado_DTO(
                		rs.getString("dni"),
                        rs.getString("nombre_emp"),
                        rs.getString("apel_emp"),
                        rs.getDate("antiguedad"),
                        rs.getDouble("salario"),
                        rs.getInt("cant_comandas"),
                        rs.getInt("cant_cocteles"),
                        rs.getString("tipo_emp")
                );
                empleados.add(empleado);
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
        return empleados;
    }

    
}
