package entidades;

public class Bota {


    private String propulsorR;
    private String propulsorL;

    public Bota(String propulsorR, String propulsorL) {
        this.propulsorR = propulsorR;
        this.propulsorL = propulsorL;
    }

    public String getPropulsorR() {
        return propulsorR;
    }

    public void setPropulsorR(String propulsorR) {
        this.propulsorR = propulsorR;
    }

    public String getPropulsorL() {
        return propulsorL;
    }

    public void setPropulsorL(String propulsorL) {
        this.propulsorL = propulsorL;
    }
}
