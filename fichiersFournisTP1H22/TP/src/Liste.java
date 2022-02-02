public class Liste extends StyleMD {
    private boolean listeNumerotee;
    private final int AJUSTEMENT = 1;

    public Liste(boolean listeNumerotee) {
        super(0);
        this.listeNumerotee = listeNumerotee;
    }

    @Override
    public String formater(String texte) {
        if (listeNumerotee) {
            for (int i = 0; i < texte.length(); i++)
                if (texte.charAt(i) == '\n')
                    texte = texte.substring(0, i) + i + AJUSTEMENT + ". " + texte.substring(i + AJUSTEMENT);
        } else
            for (int i = 0; i < texte.length(); i++)
                if (texte.charAt(i) == '\n')
                    texte = texte.substring(0, i) + "* " + texte.substring(i + AJUSTEMENT);

        super.dispositionTexte(texte);

        return texte;
    }

    public boolean isListeNumerotee(){
        return listeNumerotee;
    }

     public boolean equals(Object autreListe){
        return disposition == ((StyleMD)autreListe).disposition && listeNumerotee == ((Liste)autreListe).listeNumerotee;
     }
}
