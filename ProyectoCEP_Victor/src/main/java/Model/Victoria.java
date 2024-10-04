package Model;

/**
 *
 * @author Víctor
 */
public class Victoria {
    private int id;
    private String circuito;
    private String gp;
    private String equipo;
    private int anio;
    
    public Victoria(){
    }

    public Victoria(int id, String circuito, String gp, String equipo, int anio) {
        this.id = id;
        this.circuito = circuito;
        this.gp = gp;
        this.equipo = equipo;
        this.anio = anio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public String getGp() {
        return gp;
    }

    public void setGp(String gp) {
        this.gp = gp;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    @Override
    public String toString() {
        return "Victoria{" + "id=" + id + ", circuito=" + circuito + ", gp=" + gp + ", equipo=" + equipo + ", anio=" + anio + '}';
    }
    
}
