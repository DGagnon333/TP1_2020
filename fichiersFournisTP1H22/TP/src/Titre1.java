/**
 * Classe qui hérite de StyleMD, formate un texte en Markdown pour un Titre1.
 *
 * @author Dérick Gagnon
 * Code permanent: GAGD84110109
 * Courriel: ggg991987@ens.uqam.ca
 * Cours: INF2050
 * gr: 20
 * @version 4 Février 2022
 */
public class Titre1 extends StyleMD {

    /**
     * Constructeur par défaut. Place la disposition pour celle
     * d'un bloc.
     */
    public Titre1() {
        super(0);
    }

    /**
     * Redéfénition de la méthode toString de la classe Object
     * pour un Titre1
     *
     * @param texte le texte à formater
     * @return
     */
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
