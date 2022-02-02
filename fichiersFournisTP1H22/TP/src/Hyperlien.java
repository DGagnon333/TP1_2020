public class Hyperlien extends StyleMD {
    private String url;
    public static final String URL_DEFAUT = "http://localhost";

    public Hyperlien(String url, int disposition) {
        super(disposition);

        if (url == null || url.trim().length() == 0)
            this.url = URL_DEFAUT;
        else
            this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String formater(String texte) {
        texte = super.preparationTexte(texte);
        texte = "[" + texte + "](" + url + ")";
        texte = super.dispositionTexte(texte);
        return texte;
    }

    public boolean equals(Object autreHyperlien) {
        return super.equals(autreHyperlien) && disposition == ((StyleMD) autreHyperlien).getDisposition() && url == ((Hyperlien) autreHyperlien).getUrl();
    }
}
