import java.util.List;

import models.Libro;
import querys.LibroBD;


public class TestMySQL {
    
    public static void main(String[] args) {
        // Consultas consulta1 = new Consultas();
        // Insert insertar = new Insert();
        // Update actualizar = new Update();
        // Delete borrar = new Delete();
        LibroBD consulta1 = new LibroBD();
        // Libro libro = new Libro();

        // consulta1.borrarRegistro("958-682-455-1", 1);
        List<Libro> lista = consulta1.consultarTodo();
        for (Libro lib : lista) {
            System.out.println(lib);
        }

        // // ----INSERTAR----
        // int registrosInsertados;
        // libro.setISBN("9586824551");
        // libro.setEdicion(1);
        // libro.setFechaPublicacion(2001);
        // libro.setTitulo("Auditoria informatica");
        // libro.setNombreAutor("Mario Gerardo");
        // libro.setPrimerApellidoAutor("Piattini");
        // libro.setSegundoApellidoAutor("Veltherius");
        // libro.setPaginas(74);
        // libro.setCategoria("TI");
        // libro.setEditorial("Alfaomega ra-ma");

        // registrosInsertados = consulta1.nuevoRegistro(libro);
        // System.out.println(registrosInsertados);

        // libro = consulta1.buscarLibro("9586824551", 1);
        // System.out.println(libro);
        
        // System.out.println("------------------------------");
        // insertar.nuevoRegistro("9786075413754", 1, 2023, "Fisco Agenda 2023", "Ediciones Fiscales ISEF",
        // "", "",386, "Fiscal", "Editorial ISEF");
        // consulta1.consultarTodo();
        // System.out.println("------------------------------");
        // insertar.nuevoRegistro("0071344446", 1, 2000, 
        // "Building data mining", "Alex ", 
        // "Berson", "", 510, 
        // "TI", "Mcgraw-hill");
        // actualizar.actualizarRegistro(1, "Pedro", "Perez", "pperez@mail.com", "5512661945");
        // borrar.borrarRegistro("0071344446​", 1);
        // consulta1.consultarTodo();
        //'﻿958-682-455-1​', '1', '2001', 'Auditoria informatica​', 'Mario Gerardo', 'Piattini', 'Veltherius', '74', 'TI', 'Alfaomega ra-ma​\r'
//'84-315-2213-5', '1', '1998', 'Cancer', 'Constanza', 'Caraglio', '', '160', 'Esoterismo', 'Editorial de vecchi'

    }
}
