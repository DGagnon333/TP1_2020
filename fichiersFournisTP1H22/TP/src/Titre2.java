public class Titre2 extends StyleMD{
    public Titre2() {
        super(0);
    }

    @Override
    public String formater(String texte) {
        super.preparationTexte(texte);
        for (int i = 0; i < texte.length(); i++)
            texte += "-";
        texte = super.dispositionTexte(texte);

        return texte;
    }
}
