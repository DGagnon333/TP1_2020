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
