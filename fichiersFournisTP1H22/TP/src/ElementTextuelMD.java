/**
 * Classe qui formate un texte en style Markdown
 *
 * @author Dérick Gagnon
 * Code permanent: GAGD84110109
 * Courriel: ggg991987@ens.uqam.ca
 * Cours: INF2050
 * gr: 20
 * @version 8 Février 2022
 */
public class ElementTextuelMD {
    //Atributs d'instances
    private  String texte;
    private  StyleMD style;

    /**
     * Constructeur qui initialise les attributs texte et style
     *
     * @param texte le texte à formater
     * @param style le style a utiliser
     * @throws StyleMDInvalideException
     */
    public ElementTextuelMD(String texte, StyleMD style) throws StyleMDInvalideException {
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
     * @param style le style modifier
     */
    public void setStyle(StyleMD style) throws StyleMDInvalideException{
        if(style.equals(null))
            throw new StyleMDInvalideException();

        this.style = style;
    }

    @Override
    /**
     * Retourne le texte formaté
     */
    public String toString() {
        return style.formater(texte);
    }
}
