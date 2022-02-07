public class ElementTextureIMD {
    private  String texte;
    private  StyleMD style;

    public ElementTextureIMD(String texte, StyleMD style) throws StyleMDInvalideException {
        if(texte.equals(null) || texte.trim().isEmpty())
            if(style.equals(null))
                throw new StyleMDInvalideException();

        this.texte = texte;
        this.style = style;
    }

    //---GETTERS---\\
    public String getTexte(){
        return texte;
    }

    public StyleMD getStyle(){
        return style;
    }

    /**
     * Permet de modifier le style
     * @param style le style modié
     */
    public void setStyle(StyleMD style) throws StyleMDInvalideException{
        if(style.equals(null))
            throw new StyleMDInvalideException();

        this.style = style;
    }

    @Override
    /**
     * Retourne le texte formater de cet ElementTextureIMD formaté selone le style
     * de cet ElementTextureIMD
     */
    public String toString() {
        return style.formater(texte);
    }
}
