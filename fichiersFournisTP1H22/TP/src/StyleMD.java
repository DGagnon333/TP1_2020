/**
 * Classe abstraite gardant la disposition d'un texte et
 * s'assurant que les méthodes qui l'implémentent aient une
 * méthode formater. Peut aussi s'occuper de la préparation de
 * texte et de sa disposition.
 */
public abstract class StyleMD {
    //Constantes
    public final static int BLOC = 0;
    public final static int LIGNE = 1;
    private final String texteNull = "null";

    //Attributs d'instances
    protected int disposition;

    /**
     * Initialise l'attribut d'instance disposition avec la valeur
     * passée en paramètre. 1 pour bloc, 2 pour ligne. Tout autre
     * valeur donnera une disposition bloc.
     * @param disposition
     */
    public StyleMD(int disposition) {
        if (disposition == BLOC || disposition == LIGNE)
            this.disposition = disposition;
        else
            this.disposition = BLOC;
    }

    /**
     * Méthode abstraite qui retournera éventuellement le
     * texte formaté
     * @param texte le texte à formater
     * @return le texte formaté
     */
    public abstract String formater(String texte);

    //Getter
    public int getDisposition() {
        return disposition;
    }

    /**
     * Redéfénition de la méthode equals de la classe Object.
     * Est égal si la dispositino de l'autre style est la même
     * @param autreStyle l'autre style à comparer
     * @return Vrai si la disposition est la même, faux sinon
     */
    @Override
    public boolean equals(Object autreStyle) {
        if (autreStyle != null)
            if (autreStyle.getClass() == this.getClass())
                return ((StyleMD) autreStyle).disposition == disposition;
        return super.equals(autreStyle);
    }

    /**
     * Méthode protégée qui Arrange le texte pour être plus propre. S'il
     * est null, retourne un String "null".
     * @param texte Le texte à préparer
     * @return le texte préparé
     */
    protected String preparationTexte(String texte) {
        if (texte == null)
            texte = texteNull;
        texte = texte.trim();

        return texte;
    }

    /**
     * Méthode protégée qui dispose le texte dépendant d'une disposition
     * pour un bloc ou une ligne.
     * @param texte Le texte à arranger
     * @return le texte arrangé
     */
    protected String dispositionTexte(String texte) {
        if (disposition == BLOC)
            texte = "\n" + texte + "\n";
        else
            texte = texte + "\n";

        return texte;
    }
}
