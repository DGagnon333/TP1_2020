public abstract class StyleMD {
    public final static int BLOC = 0;
    public final static int LIGNE = 1;
    private final String texteNull = "null";

    protected int disposition;

    public StyleMD(int disposition) {
        if (disposition != BLOC || disposition != LIGNE)
            this.disposition = disposition;
        else
            this.disposition = BLOC;
    }


    public abstract String formater(String texte);

    public int getDisposition() {
        return disposition;
    }

    public boolean equals(Object autreStyle) {
        return disposition == ((StyleMD)autreStyle).disposition;
    }

    protected String dispositionTexte(String texte){
        texte = texte.trim();
        if(texte.equals(null))
            texte = texteNull;
        else if(disposition == BLOC)
            texte = "\n" + texte + "\n";
        else if(disposition == LIGNE)
            texte = texte + "\n";
        return texte;
    }
}
