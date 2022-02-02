public class Titre1 extends StyleMD {

    public Titre1() {
        super(0);
    }

    @Override
    public String formater(String texte) {
        final int AJUSTEMENT = 1;
        final int LONGUEUR_TEXTE;
        texte = super.preparationTexte(texte) + "\n";
        LONGUEUR_TEXTE = texte.length() - AJUSTEMENT;
        for (int i = 0; i < LONGUEUR_TEXTE; i++)
            texte += "=";
        texte = super.dispositionTexte(texte);

        return texte;
    }
}
