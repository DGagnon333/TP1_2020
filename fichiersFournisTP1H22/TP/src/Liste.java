/**
 * Classe qui hérite de la classe StyleMD et s'occupe de formater un texte pour
 * faire des listes numérotées et non numérotées
 *
 * @author Dérick Gagnon
 * Code permanent: GAGD84110109
 * Courriel: ggg991987@ens.uqam.ca
 * Cours: INF2050
 * gr: 20
 * @version 5 Février 2022
 */
public class Liste extends StyleMD {
    private boolean listeNumerotee;
    private final int AJUSTEMENT = 1;

    public Liste(boolean listeNumerotee) {
        super(0);
        this.listeNumerotee = listeNumerotee;
    }


    @Override
    public String formater(String texte) {
        final int LONGUEUR_TEXTE;
        final String POINT = ". ";
        final String ETOILE = "* ";
        int compteur = 1;

        texte = super.preparationTexte(texte);
        LONGUEUR_TEXTE = texte.length();

        if (listeNumerotee) {
            texte = compteur + POINT + texte;
            for (int i = 0; i < LONGUEUR_TEXTE; i++)
                if (texte.charAt(i) == '\n'){
                    compteur++;
                    texte = texte.substring(0, i + AJUSTEMENT) + compteur + POINT + texte.substring(i + AJUSTEMENT);
                }
        } else{
            texte = ETOILE + texte;
            for (int i = 0; i < LONGUEUR_TEXTE; i++)
                if (texte.charAt(i) == '\n')
                    texte = texte.substring(0, i + AJUSTEMENT) + ETOILE + texte.substring(i + AJUSTEMENT);
        }

        texte = super.dispositionTexte(texte);

        return texte;
    }

    public boolean isListeNumerotee(){
        return listeNumerotee;
    }

     public boolean equals(Object autreListe){
        return super.equals(autreListe) && disposition == ((StyleMD)autreListe).getDisposition() && listeNumerotee == ((Liste)autreListe).isListeNumerotee();
     }
}
