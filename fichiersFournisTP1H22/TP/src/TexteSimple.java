public class TexteSimple extends StyleMD {
    private  final int AJUSTEMENT = 1;

    public TexteSimple(int disposition) {
        super(disposition);
    }

    public String formater(String texte) {
        super.preparationTexte(texte);
        for (int i = 0; i < texte.length(); i++)
            if (texte.charAt(i) == '\n')
                texte = texte.substring(0, i - AJUSTEMENT) + "<br/>" + texte.substring(i + AJUSTEMENT);
        super.dispositionTexte(texte);

        return texte;
    }
}
