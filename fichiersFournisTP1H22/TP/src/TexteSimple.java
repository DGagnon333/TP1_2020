/**
 * Classe qui formate un texte en Markdown.
 *
 * @author Dérick Gagnon
 * Code permanent: GAGD84110109
 * Courriel: ggg991987@ens.uqam.ca
 * Cours: INF2050
 * gr: 20
 * @version 5 Février 2022
 */
public class TexteSimple extends StyleMD {
    private  final int AJUSTEMENT = 1;

    public TexteSimple(int disposition) {
        super(disposition);
    }

    /**
     * Redéfénition de la méthode formater dans la classe StyleMD. Formate un texte simple
     *
     * @param texte le texte à formater
     * @return le texte formaté
     */
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
