public class Producto {

    int idProducto;
    String nomProducto;
    String categoria;
    double precio;
    int cantDisponible;

    public Producto (int idProducto, String nomProducto, String categoria, double precio, int cantDisponible){
        this.idProducto = idProducto;
        this.nomProducto = nomProducto;
        this.categoria = categoria;
        this.precio = precio;
        this.cantDisponible = cantDisponible;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantDisponible() {
        return cantDisponible;
    }

    public void setCantDisponible(int cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    public String toString() {
        return "Producto [ID Producto=" + idProducto + ", Nombre Producto=" + nomProducto +
                ", Categoría=" + categoria + ", Precio=" + precio +
                ", Cantidad Disponible=" + cantDisponible + "]";
    }
}
