/**
 * Hérite de la classe abstraite StyleMD et l'implémente. S'occupe de
 * formater un texte pour un Titre1.
 */
public class Titre3 extends StyleMD{

    /**
     * Constructeur par défaut. Place la disposition pour celle
     * d'un bloc.
     */
    public Titre3() {
        super(0);
    }

    @Override
    public String formater(String texte) {
        texte = super.preparationTexte(texte);
        texte = "### " + texte;
        texte = super.dispositionTexte(texte);

        return texte;
    }
}
