public abstract class StyleMD {
    public final static int BLOC = 0;
    public final static int LIGNE = 1;
    private final String texteNull = "null";

    protected int disposition;

    public StyleMD(int disposition) {
        if (disposition == BLOC || disposition == LIGNE)
            this.disposition = disposition;
        else
            this.disposition = BLOC;
    }


    public abstract String formater(String texte);

    public int getDisposition() {
        return disposition;
    }

    public boolean equals(Object autreStyle) {
        return disposition == ((StyleMD) autreStyle).disposition;
    }

    protected String preparationTexte(String texte) {
        if (texte.equals(null))
            texte = texteNull;
        texte = texte.trim();

        return texte;
    }

    protected String dispositionTexte(String texte) {
        if (disposition == BLOC)
            texte = "\n" + texte + "\n";
        else
            texte = texte + "\n";

        return texte;
    }
}
