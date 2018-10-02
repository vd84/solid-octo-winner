package sample;

public class RangedGearSetup {

    private String helm;
    private String necklase;
    private String quiver;
    private String torso;
    private String legs;
    private String gloves;
    private String boots;
    private String cape;


    public RangedGearSetup(String helm, String necklase, String quiver, String torso, String legs, String gloves, String boots, String cape) {
        this.helm = helm;
        this.necklase = necklase;
        this.quiver = quiver;
        this.torso = torso;
        this.legs = legs;
        this.gloves = gloves;
        this.boots = boots;
        this.cape = cape;
    }

    public String getHelm() {
        return helm;
    }

    public String getNecklase() {
        return necklase;
    }

    public String getQuiver() {
        return quiver;
    }

    public String getTorso() {
        return torso;
    }

    public String getLegs() {
        return legs;
    }

    public String getGloves() {
        return gloves;
    }

    public String getBoots() {
        return boots;
    }

    public String getCape() {
        return cape;
    }


    @Override
    public String toString() {
        return
                "helm='" + helm + '\'' +
                ", necklase='" + necklase + '\'' +
                ", quiver='" + quiver + '\'' +
                ", torso='" + torso + '\'' +
                ", legs='" + legs + '\'' +
                ", gloves='" + gloves + '\'' +
                ", boots='" + boots + '\'' +
                ", cape='" + cape + '\'' +
                '}';
    }
}
