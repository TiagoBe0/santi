/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import tienda.Entidades.Fabricante;
import tienda.Entidades.Producto;
import tienda.Persistencia.EntidadDAOext;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
     
        
        EntidadDAOext e1 = new EntidadDAOext();
        System.out.println("a)");
        System.out.println("");
        e1.listarMascotas();
          System.out.println("b)");
        System.out.println("");
        e1.listarNombrePrecio_Productos();
          System.out.println("c)");
        System.out.println("");
        e1.listarNombrePrecio_Intervalo_Productos();
        System.out.println("d)");
        System.out.println("");
        e1.listarNombrePrecio_Portatiles_Productos();
         System.out.println("e)");
        System.out.println("");
        e1.listarNombrePrecio_Min_Productos();
        
          System.out.println("e)");
          System.out.println("Ingrese codigo(int) , nombre , precio, codigo fabricante(int):");
        System.out.println("");
          EntidadDAOext e2 = new EntidadDAOext();
          Producto p1 = new Producto();
        e2.guardarProducto(p1);
        
           
          System.out.println("f)");
          System.out.println("Ingrese codigo(int) y  nombre del fabricante(int):");
        System.out.println("");
            EntidadDAOext e3 = new EntidadDAOext();
          Fabricante  f1 = new Fabricante();
        e3.guardarFabricante(f1);
            
                  System.out.println("f)");
          System.out.println("Ingrese codigo(int) y  nombre del fabricante(int):");
        System.out.println("");
            
          Producto  p3 = new Producto();
        e1.modificarProducto(p3);

    }
    
}
