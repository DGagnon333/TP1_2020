public class Emphase extends StyleMD{
    public Emphase(){
        super(1);
    }

    public String formater(String texte){
        final String ETOILES = "**";
        texte = super.preparationTexte(texte);
        texte = ETOILES + texte + ETOILES;
        texte = super.dispositionTexte(texte);

        return texte;
    }
}
