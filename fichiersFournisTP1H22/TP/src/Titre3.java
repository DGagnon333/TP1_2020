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
public class Titre3 extends StyleMD{

    /**
     * Constructeur par défaut. Place la disposition pour celle
     * d'un bloc.
     */
    public Titre3() {
        super(0);
    }

    /**
     * Redéfénition de la méthode toString de la classe Object
     * pour un Titre3
     *
     * @param texte le texte à formater
     * @return
     */
    @Override
    public String formater(String texte) {
        texte = super.preparationTexte(texte);
        texte = "### " + texte;
        texte = super.dispositionTexte(texte);

        return texte;
    }
}
