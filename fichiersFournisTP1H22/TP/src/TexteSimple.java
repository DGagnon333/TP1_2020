/**
 * Classe abstraite gardant la disposition d'un texte et
 * s'assurant que les méthodes qui l'implémentent aient une
 * méthode formater. Peut aussi s'occuper de la préparation de
 * texte et de sa disposition.
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
