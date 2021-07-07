
package supermercadosanchez;

public class Producto {
    public String nombre;
    public Double price;

    public Producto(String nombre, Double price) {
        this.nombre = nombre;
        this.price = price;
    }
    
    public Producto(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Double calcularMontoTotal(Double subtotal){
        Double total;
        
        if(subtotal > 5000.00){
            total = subtotal - (subtotal * 0.30);
        } else if(subtotal <= 5000 && subtotal > 3000 ){
            total = subtotal - (subtotal * 0.20);
        } else if(subtotal <= 3000 && subtotal > 1000 ){
            total = subtotal - (subtotal * 0.10);
        } else{
            total = subtotal;
        }

        return total;
    }

     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();                                                                   
        sb.append("\nNombre: ");
        sb.append(nombre);
        sb.append("\nPrecio: ");
        sb.append(price);   
        return sb.toString();
    }
    
}
