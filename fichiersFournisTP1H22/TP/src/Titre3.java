public class Titre3 extends StyleMD{
    public Titre3() {
        super(0);
    }

    @Override
    public String formater(String texte) {
        super.preparationTexte(texte);
        texte = "### " + texte;
        texte = super.dispositionTexte(texte);

        return texte;
    }
}
