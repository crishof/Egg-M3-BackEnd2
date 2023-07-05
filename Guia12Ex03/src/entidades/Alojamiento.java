package entidades;

public class Alojamiento {

    private String name;
    private String address;
    private String location;
    private String gerente;

    public Alojamiento() {
    }

    public Alojamiento(String name, String address, String location, String gerente) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.gerente = gerente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Alojamiento:  " + name + "\n address: " + address + "\n location: " + location + "\n gerente: " + gerente;
    }
}
