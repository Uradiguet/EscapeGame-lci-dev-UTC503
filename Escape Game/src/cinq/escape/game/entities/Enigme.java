package cinq.escape.game.entities;

public class Enigme{
    private String titre;
    private String description;
    private String codeSolution;
    private boolean resolue;


    public Enigme(){
        this("", "", "");
    }


    public Enigme(
        String titre,
        String description,
        String codeSolution
    ){
        this.titre = titre;
        this.description = description;
        this.codeSolution = codeSolution;
    }

    public boolean resoudre(String tentative){
        return this.resolue=tentative.trim().equalsIgnoreCase(codeSolution);
    }

    @Override
    public String toString(){
        return titre+"\n"+description;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null||!(obj instanceof Enigme)) {
            return false;
        }
        Enigme autreEnigme = (Enigme) obj;
        return this.titre==autreEnigme.titre && this.description==autreEnigme.description;
    }




}