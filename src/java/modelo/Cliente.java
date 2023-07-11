package modelo;

public class Cliente {

    private String codigo;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String password;

    public Cliente() {
    }

    private Cliente(Builder builder) {
        this.codigo = builder.codigo;
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.telefono = builder.telefono;
        this.correo = builder.correo;
        this.password = builder.password;
    }

    // Getters de los atributos de Cliente
    public static class Builder {

        private String codigo;
        private String nombre;
        private String apellido;
        private String telefono;
        private String correo;
        private String password;

        public Builder() {
            // Constructor del builder
        }

        public Builder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder correo(String correo) {
            this.correo = correo;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Cliente build() {
            return new Cliente(this);
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
