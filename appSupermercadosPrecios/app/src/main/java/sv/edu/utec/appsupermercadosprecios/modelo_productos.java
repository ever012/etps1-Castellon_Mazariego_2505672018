package sv.edu.utec.appsupermercadosprecios;

public class modelo_productos {
    private String NombreProducto;
    private int ImgProducto;
    private String PrecioProducto;

    public String getNombreProducto() {
        return NombreProducto;
    }

    public int getImgProducto() {
        return ImgProducto;
    }



    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public void setImgProducto(int imgProducto) {
        ImgProducto = imgProducto;
    }


    public String getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        PrecioProducto = precioProducto;
    }
}
