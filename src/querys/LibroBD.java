package querys;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.Conexion;
import models.Libro;

public class LibroBD extends Conexion {

    public int nuevoRegistro(Libro libro) {
        int registrosInsertados = 0;

        try {
            getConexion();
            
            String query = "INSERT INTO libros (ISBN, Edicion, FechaPublicacion, Titulo, "+
                           "NombreAutor, PrimerApellidoAutor, SegundoApellidoAutor, Paginas, "+
                           "Categoria, Editorial)"+
                           "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, libro.getISBN());
            preparedStatement.setInt(2, libro.getEdicion());
            preparedStatement.setInt(3, libro.getFechaPublicacion());
            preparedStatement.setString(4, libro.getTitulo());
            preparedStatement.setString(5, libro.getNombreAutor());
            preparedStatement.setString(6, libro.getPrimerApellidoAutor());
            preparedStatement.setString(7, libro.getSegundoApellidoAutor());
            preparedStatement.setInt(8, libro.getPaginas());
            preparedStatement.setString(9, libro.getCategoria());
            preparedStatement.setString(10, libro.getEditorial());
            
            registrosInsertados = preparedStatement.executeUpdate();

            preparedStatement.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println("Excepcion generica----->"+e);
        }

        return registrosInsertados;
    }

    public int actualizarRegistro(Libro libro) {
        int registrosActualizados = 0;

        try {
            getConexion();
            
            String query = "UPDATE libros " 
                          +"SET FechaPublicacion = ?, Titulo = ?, NombreAutor = ?,"
                          +"PrimerApellidoAutor = ?, SegundoApellidoAutor = ?, Paginas = ?,"+
                          "Categoria = ?, Editorial = ?)"
                          +"WHERE ISBN = ? AND Edicion = ?;";
            
            PreparedStatement preparedStatement = con.prepareStatement(query);

            
            preparedStatement.setInt(1, libro.getFechaPublicacion());
            preparedStatement.setString(2, libro.getTitulo());
            preparedStatement.setString(3, libro.getNombreAutor());
            preparedStatement.setString(4, libro.getPrimerApellidoAutor());
            preparedStatement.setString(5, libro.getSegundoApellidoAutor());
            preparedStatement.setInt(6, libro.getPaginas());
            preparedStatement.setString(7, libro.getCategoria());
            preparedStatement.setString(8, libro.getEditorial());
            preparedStatement.setString(9, libro.getISBN());
            preparedStatement.setInt(10, libro.getEdicion());
            
            registrosActualizados = preparedStatement.executeUpdate();

            preparedStatement.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println("Excepcion generica----->"+e);
        }

        return registrosActualizados;
    }

    public int borrarRegistro(String ISBN, int edicion) {
        int registrosActualizados = 0;

        try {
            getConexion();
            
            String query = "DELETE FROM libros WHERE ISBN = ? AND Edicion = ?;";
            
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, ISBN);
            preparedStatement.setInt(2, edicion);
            
            registrosActualizados =  preparedStatement.executeUpdate();

            preparedStatement.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println("Excepcion generica----->"+e);
        }

        return registrosActualizados;
    }

    public Libro buscarLibro(String ISBN, int edicion) {
        Libro libro = null;

        try {
            getConexion();
            String query = "SELECT * FROM libros WHERE ISBN = ? AND Edicion = ?";

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, ISBN);
            preparedStatement.setInt(2, edicion);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                libro = new Libro();
                libro.setISBN(rs.getString("ISBN"));
                libro.setEdicion(rs.getInt("Edicion"));
                libro.setFechaPublicacion(rs.getInt("FechaPublicacion"));
                libro.setTitulo(rs.getString("Titulo"));
                libro.setNombreAutor(rs.getString("NombreAutor"));
                libro.setPrimerApellidoAutor(rs.getString("PrimerApellidoAutor"));
                libro.setSegundoApellidoAutor(rs.getString("SegundoApellidoAutor"));
                libro.setPaginas(rs.getInt("Paginas"));
                libro.setCategoria(rs.getString("Categoria"));
                libro.setEditorial(rs.getString("Editorial"));
            }
        
            preparedStatement.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println("Excepcion generica----->"+e);
        }

        return libro;
    }
    
    public List<Libro> consultarTodo() {
        List<Libro> listaLibros = new ArrayList<>();

        try {
            
            getConexion();

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM libros");
        
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setISBN(rs.getString("ISBN"));
                libro.setEdicion(rs.getInt("Edicion"));
                libro.setFechaPublicacion(rs.getInt("FechaPublicacion"));
                libro.setTitulo(rs.getString("Titulo"));
                libro.setNombreAutor(rs.getString("NombreAutor"));
                libro.setPrimerApellidoAutor(rs.getString("PrimerApellidoAutor"));
                libro.setSegundoApellidoAutor(rs.getString("SegundoApellidoAutor"));
                libro.setPaginas(rs.getInt("Paginas"));
                libro.setCategoria(rs.getString("Categoria"));
                libro.setEditorial(rs.getString("Editorial"));

                listaLibros.add(libro);
            }
        
            rs.close();
            statement.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Excepcion tipo SQL----->"+e);
        } catch (Exception e) {
            System.out.println("Excepcion generica----->"+e);
        }


        return listaLibros;
    }

    

}
