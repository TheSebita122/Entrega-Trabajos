import java.util.ArrayList;
import java.util.List;

//Patron Prototype

public class Credenciales2 implements Cloneable {
    private String titulo;
    private List<String> campos;

    public Credenciales2(String titulo) {
        this.titulo = titulo;
        this.campos = new ArrayList<>();
    }

    public void personalizar(String titulo, String campo) {
        this.titulo = titulo;
        this.campos.add(campo);
    }

    @Override
    public Credenciales2 clone() {
        try {
            Credenciales2 clon = (Credenciales2) super.clone();
            clon.campos = new ArrayList<>(this.campos); // Clonar lista de campos
            return clon;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void mostrar() {
        System.out.println("Título: " + titulo);
        System.out.println("Campos: " + campos);
        ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
        System.out.println("Idioma: " + config.getIdioma());
        System.out.println("Logo: " + config.getLogo());
    }

    public static void main(String[] args) {
        ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
        config.setIdioma("Inglés");
        config.setLogo("Logo del Evento");


        Credenciales2 credencialBase = new Credenciales2("Credencial Base");
        credencialBase.personalizar("Credencial Base", "Nombre del Asistente");
        credencialBase.personalizar("Credencial Base", "Correo Electrónico");

        Credenciales2 credencialRegistro = credencialBase.clone();
        credencialRegistro.personalizar("Credencial de Registro", "Teléfono de Contacto");

        Credenciales2 credencialEncuesta = credencialBase.clone();
        credencialEncuesta.personalizar("Credencial de Encuesta", "Edad del Asistente");

        System.out.println("Credencial Base:");
        credencialBase.mostrar();

        System.out.println("\nCredencial de Registro:");
        credencialRegistro.mostrar();

        System.out.println("\nCredencial de Encuesta:");
        credencialEncuesta.mostrar();
    }
}

class ConfiguracionGlobal {
    private static ConfiguracionGlobal instancia;
    private String idioma;
    private String logo;

    private ConfiguracionGlobal() {
        this.idioma = "Español";
        this.logo = "Logo por defecto";
    }

    public static ConfiguracionGlobal getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionGlobal();
        }
        return instancia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}