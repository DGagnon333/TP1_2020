public class TexteSimple extends StyleMD {
    private  final int AJUSTEMENT = 1;

    public TexteSimple(int disposition) {
        super(disposition);
    }

    @Override
    public String formater(String texte) {
        final int LONGUEUR_TEXTE;
        texte = super.preparationTexte(texte);
        LONGUEUR_TEXTE = texte.length();
        for (int i = 0; i < LONGUEUR_TEXTE; i++)
            if (texte.charAt(i) == '\n')
            texte = texte.substring(0, i) + "<br/>" + texte.substring(i + AJUSTEMENT);
        texte = super.dispositionTexte(texte);

        return texte;
    }
}
