


package tienda.Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import tienda.Entidades.Fabricante;
import tienda.Entidades.Producto;


public final class EntidadDAOext extends DAO {

    Scanner sc = new Scanner(System.in);
    
    public Collection<Producto> listarMascotas() throws Exception {
        try {
            conectarBase();
            String sql = "SELECT * FROM producto ";
            consultarBase(sql);
          Producto mascota = null;
            Collection<Producto> mascotas = new ArrayList();
            while (resultado.next()) {
                mascota = new Producto();
                mascota.setCodigo(resultado.getInt(1));
                mascota.setNombre(resultado.getString(2));
               
               
                
                mascotas.add(mascota);
                System.out.println(mascota.getNombre());
            }
            desconectarBase();
            return mascotas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
    
    
    
     public Collection<Producto> listarNombrePrecio_Productos() throws Exception {
        try {
            conectarBase();
            String sql = "SELECT nombre,precio FROM producto ";
            consultarBase(sql);
          Producto mascota = null;
            Collection<Producto> mascotas = new ArrayList();
            while (resultado.next()) {
                mascota = new Producto();
                mascota.setNombre(resultado.getString(1));
                mascota.setPrecio(resultado.getInt(2));
                
               
               
                
                mascotas.add(mascota);
                System.out.println(mascota.getNombre()+"     ;    " + mascota.getPrecio());
            }
            desconectarBase();
            return mascotas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
     
          public Collection<Producto> listarNombrePrecio_Intervalo_Productos() throws Exception {
        try {
            conectarBase();
            String sql = "SELECT nombre,precio from  producto where precio>=120 and precio<=202 ";
            consultarBase(sql);
          Producto mascota = null;
            Collection<Producto> mascotas = new ArrayList();
            while (resultado.next()) {
                mascota = new Producto();
                mascota.setNombre(resultado.getString(1));
                mascota.setPrecio(resultado.getInt(2));
                
               
               
                
                mascotas.add(mascota);
                System.out.println(mascota.getNombre()+"     ;    " + mascota.getPrecio());
            }
            desconectarBase();
            return mascotas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
          public Collection<Producto> listarNombrePrecio_Portatiles_Productos() throws Exception {
        try {
            conectarBase();
            String sql = "SELECT nombre from  producto where nombre='Portátil' ";
            consultarBase(sql);
          Producto mascota = null;
            Collection<Producto> mascotas = new ArrayList();
            while (resultado.next()) {
                mascota = new Producto();
                mascota.setNombre(resultado.getString(1));
                mascota.setPrecio(resultado.getInt(2));
                
               
               
                
                mascotas.add(mascota);
                System.out.println(mascota.getNombre()+"     ;    " + mascota.getPrecio());
            }
            desconectarBase();
            return mascotas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
     public Collection<Producto> listarNombrePrecio_Min_Productos() throws Exception {
        try {
            conectarBase();
            String sql = "select nombre, min(precio) from producto;";
            consultarBase(sql);
          Producto mascota = null;
            Collection<Producto> mascotas = new ArrayList();
            while (resultado.next()) {
                mascota = new Producto();
                mascota.setNombre(resultado.getString(1));
                mascota.setPrecio(resultado.getInt(2));
                
               
               
                
                mascotas.add(mascota);
                System.out.println(mascota.getNombre()+"     ;    " + mascota.getPrecio());
            }
            desconectarBase();
            return mascotas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
          
     
 public void guardarProducto(Producto mascota) throws Exception {
        try {
                        conectarBase();
            if (mascota == null) {
                
                
                throw new Exception("Ingresar el nombre del producto");
            }
            mascota.setCodigo(sc.nextInt());
            mascota.setNombre(sc.next());
            mascota.setPrecio(sc.nextDouble());
            mascota.setCodigoFabricante(sc.nextInt());
            
            String sql = "INSERT INTO Producto(codigo, nombre, precio,codigo_fabricante) "
                    + "VALUES ( " + mascota.getCodigo() + " , '"  + mascota.getNombre() + "' ," + mascota.getPrecio() + "  , " + mascota.getCodigoFabricante()+");";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
   public void guardarFabricante(Fabricante mascota) throws Exception {
        try {
                        conectarBase();
            if (mascota == null) {
                
                
                throw new Exception("Ingresar el nombre y codigo del fabricante");
            }
            mascota.setCodigo(sc.nextInt());
            mascota.setNombre(sc.next());
            
            String sql = "INSERT INTO fabricante(codigo, nombre) "
                    + "VALUES ( " + mascota.getCodigo() + " , '"  + mascota.getNombre() + "');";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
   
   
   public void modificarProducto(Producto mascota) throws Exception {
        try {
            if (mascota == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
                
            }
            System.out.println("Codigo del producto que desea modificar:");
            mascota.setCodigo(sc.nextInt());
            System.out.println("Ingrese el nuevo precio del producto:");
            mascota.setPrecio(sc.nextDouble());
            
            String sql = "UPDATE producto SET "
                     + "  precio = " + mascota.getPrecio()
                    + " WHERE codigo = " + mascota.getCodigo() ;
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
}
