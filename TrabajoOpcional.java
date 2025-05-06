import java.util.ArrayList;
import java.util.List;

public class TrabajoOpcional {

    // Clase Singleton 
    public static class ConfiguracionGlobal {
        private static ConfiguracionGlobal instancia;
        private String idioma;
        private String logo;

        private ConfiguracionGlobal() {
            this.idioma = "Español";
            this.logo = "Logo por defecto";
        }

        // Método para obtener la instancia única
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

    public static class FormularioContacto implements Cloneable {
        private String titulo;
        private List<String> campos;

        public FormularioContacto(String titulo) {
            this.titulo = titulo;
            this.campos = new ArrayList<>();
        }

        public void personalizar(String titulo, String campo) {
            this.titulo = titulo;
            this.campos.add(campo);
        }

        @Override
        public FormularioContacto clone() {
            try {
                FormularioContacto clon = (FormularioContacto) super.clone();
                clon.campos = new ArrayList<>(this.campos);
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
    }

    public static void main(String[] args) {

        ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
        config.setIdioma("Inglés");
        config.setLogo("Logo personalizado");

        // Crear formulario base
        FormularioContacto formularioBase = new FormularioContacto("Formulario Base");
        formularioBase.personalizar("Formulario Base", "Nombre");
        formularioBase.personalizar("Formulario Base", "Correo");

        // Clonar y personalizar formularios
        FormularioContacto formulario1 = formularioBase.clone();
        formulario1.personalizar("Formulario de Registro", "Teléfono");

        FormularioContacto formulario2 = formularioBase.clone();
        formulario2.personalizar("Formulario de Encuesta", "Edad");

        // Mostrar formularios
        System.out.println("Formulario Base:");
        formularioBase.mostrar();

        System.out.println("\nFormulario 1:");
        formulario1.mostrar();

        System.out.println("\nFormulario 2:");
        formulario2.mostrar();
    }
}
