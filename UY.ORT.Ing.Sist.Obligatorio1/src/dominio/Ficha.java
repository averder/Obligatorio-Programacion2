package dominio;

public class Ficha {

    //Atributos
    private Color color;

    public enum Color {

        B,
        N,
        noHay,
        asterisco
    }

    //Metodos de acceso y modificacion
    public Color getColor() {
        return color;
    }

    public void setColor(Color unColor) {
        this.color = unColor;
    }

    //Constructor 
    public Ficha(Color unColor) {
        this.color = unColor;
    }

    @Override
    public String toString() {
        String retorno = " ";
        if (this.getColor().equals(Ficha.Color.B)) {
            retorno = "B";
        }
        if (this.getColor().equals(Ficha.Color.N)) {
            retorno = "N";
        }
        if (this.getColor().equals(Ficha.Color.asterisco)) {
            retorno = "*";
        }
        return retorno;
    }
}
