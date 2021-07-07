
package supermercadosanchez;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SuperMercadoSanchez {
    static Scanner entrada = new Scanner( System.in );
    static ArrayList<Producto> arrayProductos = new ArrayList();
    
    public static void agregar(){
        boolean band = true;
        String nombre;
        Double precio;

        while(band == true){

            System.out.println("\nAgregue el Producto");
            System.out.print("Digite el Nombre del Producto: ");
            nombre = entrada.next();
            System.out.print("Digite el precio del Producto: ");
            precio = entrada.nextDouble();
            
            Producto productos = new Producto();
            productos.setNombre(nombre);
            productos.setPrice(precio);
            
            arrayProductos.add(productos);
            
            System.out.print("Desea Crear Otro Producto? (true/false): ");
            band = entrada.nextBoolean();
            
        }
    }
    
    public static void mostrar(){
        
        String pSelect;
        Double subtotal = 0.0,total;
        boolean salir = true;
        Producto pro = new Producto();
        System.out.println("\n\nLista de Productos");
        for(int i=0; i < arrayProductos.size();i++){
            System.out.println(arrayProductos.get(i));
        }
        
        while(salir){
            
            System.out.println("Digite el Producto que Desea Llevar: ");
            pSelect = entrada.next();

            for(int i=0; i < arrayProductos.size();i++){
                if(arrayProductos.get(i).nombre.equalsIgnoreCase(pSelect)){
                    subtotal = subtotal + arrayProductos.get(i).price;
                }
            }

            System.out.println("Desea Llevar otro Producto? true/false");
            salir = entrada.nextBoolean();
        }
        
        System.out.println("Subtotal a Pagar: "+ subtotal);
        
        total = pro.calcularMontoTotal(subtotal);
        System.out.println("Total a pagar con Descuento si Aplico: "+ total);
    }

    public static void main(String[] args) {

        int opc;
        boolean salir = false;
        while(!salir){
            
            System.out.println("\n\nSupermercados Sanchez");
            System.out.println("1. Agregar Productos");
            System.out.println("2. Realizar Compras");
            System.out.println("3. Salir");

            try{  
                System.out.print("Digite una Opción: ");
                opc = entrada.nextInt();
                switch(opc){
                
                    case 1: agregar();
                    break;
                    case 2: mostrar();
                    break;
                    case 3: salir = true; 
                    break;
                    default: 
                        System.out.println("Las opciones son entre 1 y 3");
                }
            }catch(InputMismatchException e){
                System.out.print("Debes Digitar un numero");
                entrada.next();
            } 
        }     
    } 
}
