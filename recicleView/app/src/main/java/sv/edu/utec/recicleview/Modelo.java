package sv.edu.utec.recicleview;

import android.graphics.drawable.Drawable;

public class Modelo {

    private String NombrePeli;
    private String GeneroPeli;
    private String DirectorPeli;
    private String AnioPeli;
    private int ImgPeli;
    private String DuracionPeli;
    private String FechaPeli;
private double clasificar;


    public String getNombrePeli() {
        return NombrePeli;
    }

    public String getGeneroPeli() {
        return GeneroPeli;
    }

    public String getDirectorPeli() {
        return DirectorPeli;
    }

    public String getAnioPeli() {
        return AnioPeli;
    }

    public int getImgPeli() {
        return ImgPeli;
    }

    public String getDuracionPeli() {
        return DuracionPeli;
    }

    public String getFechaPeli() {
        return FechaPeli;
    }

    public double getClasificar() {
        return clasificar;
    }

    public void setNombrePeli(String nombrePeli) {
        NombrePeli = nombrePeli;
    }

    public void setGeneroPeli(String generoPeli) {
        GeneroPeli = generoPeli;
    }

    public void setDirectorPeli(String directorPeli) {
        DirectorPeli = directorPeli;
    }

    public void setAnioPeli(String anioPeli) {
        AnioPeli = anioPeli;
    }

    public void setImgPeli(int imgPeli) {
        ImgPeli = imgPeli;
    }

    public void setDuracionPeli(String duracionPeli) {
        DuracionPeli = duracionPeli;
    }

    public void setFechaPeli(String fechaPeli) {
        FechaPeli = fechaPeli;
    }

    public void setClasificar(double clasificar) {
        this.clasificar = clasificar;
    }
}

