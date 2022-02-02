public class Emphase extends StyleMD{
    public Emphase(){
        super(1);
    }

    public String formater(String texte){
        super.preparationTexte(texte);
        texte = "** " + texte + " **";
        super.dispositionTexte(texte);

        return texte;
    }
}
