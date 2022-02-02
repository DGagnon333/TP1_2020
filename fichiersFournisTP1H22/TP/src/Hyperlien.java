public class Hyperlien extends StyleMD{
    private String url;

    public Hyperlien(String url, int disposition){
        super(disposition);

        if(url.equals(null) || url.trim().length() == 0)
            this.url = "http://localhost";

        this.url = url;
    }

    public String getUrl(){
        return url;
    }

    public String formater(String texte){
        return "[" + texte + "] (" + url + ")" ;
    }

    public boolean equals(Object autreHyperlien){
        return disposition == ((StyleMD)autreHyperlien).getDisposition() && url == ((Hyperlien)autreHyperlien).getUrl();
    }
}
