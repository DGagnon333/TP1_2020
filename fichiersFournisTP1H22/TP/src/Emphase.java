/**
 * Classe qui hérite de StyleMD et formate un texte en le mettant en emphase
 *
 * @author Dérick Gagnon
 * Code permanent: GAGD84110109
 * Courriel: ggg991987@ens.uqam.ca
 * Cours: INF2050
 * gr: 20
 * @version 5 Février 2022
 */
public class Emphase extends StyleMD{
    public Emphase(){
        super(1);
    }

    public String formater(String texte){
        final String ETOILES = "**";
        texte = super.preparationTexte(texte);
        texte = ETOILES + texte + ETOILES;
        texte = super.dispositionTexte(texte);

        return texte;
    }
}
