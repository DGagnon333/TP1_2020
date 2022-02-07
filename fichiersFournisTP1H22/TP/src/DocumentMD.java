import java.util.ArrayList;

public class DocumentMD {
    private ArrayList<ElementTextureIMD> elements;

    public DocumentMD(){
        elements = new ArrayList<>();
    }

    /**
     * Retourne le nombre d'éléments textuel dans Markdown
     * dans ce doncument.
     * @return
     */
    public int taille(){
        return elements.size();
    }

    /**
     * Cette méthode permet d'ajouter un élément textuel à la fin de la liste d'éléments
     * @param elementTextureIMD
     */
    public void ajouterElementTextuel(ElementTextureIMD elementTextureIMD){
        elements.add(elementTextureIMD);
    }

    public void ajouterElementTextuel(int position, ElementTextureIMD eltTexteMD) throws ElementTextuelMDInvalideException{
        if(eltTexteMD != null && !positionValide(position))
            throw new ElementTextuelMDInvalideException();
        elements.add(position, eltTexteMD);
    }

    public ElementTextureIMD supprimerElementTextuel(int position) throws IndexOutOfBoundsException{
        if(!positionValide(position))
            throw new IndexOutOfBoundsException();
        return elements.remove(position);
    }

    public ElementTextureIMD remplacerElementTetuel(int position, ElementTextureIMD eltTexteMD) throws ElementTextuelMDInvalideException, IndexOutOfBoundsException{
        if(eltTexteMD == null)
            throw new ElementTextuelMDInvalideException();
        if(eltTexteMD != null && positionValide(position))
            throw new IndexOutOfBoundsException();

        ajouterElementTextuel(position, eltTexteMD);

        return supprimerElementTextuel(position + 1);
    }

    public ElementTextureIMD obtenirElementTextuel(int position) throws IndexOutOfBoundsException{
        ElementTextureIMD elementEnlever;
        if(!positionValide(position))
            throw new IndexOutOfBoundsException();

        elementEnlever = supprimerElementTextuel(position);
        elements.add(position, elementEnlever);

        return elementEnlever;
    }

    public void modifierStyle(int position, StyleMD style) throws IndexOutOfBoundsException,StyleMDInvalideException{
        if(!positionValide(position))
            throw new IndexOutOfBoundsException();
        if(positionValide(position) && style == null)
            throw new StyleMDInvalideException();

        obtenirElementTextuel(position).setStyle(style);
    }

    public void modifierStyle(int position, String texte) throws IndexOutOfBoundsException, ElementTextuelMDInvalideException, StyleMDInvalideException{
        if(!positionValide(position))
            throw new IndexOutOfBoundsException();
        if(positionValide(position) && (texte.equals(null) || texte.trim().isEmpty()))
            throw new ElementTextuelMDInvalideException();

        supprimerElementTextuel(position);

        try{
            ajouterElementTextuel(position, new ElementTextureIMD(texte, obtenirElementTextuel(position).getStyle()));
        }catch (StyleMDInvalideException exception){
            throw exception;
        }
    }

    public String obtenirMarkdown(int position) throws IndexOutOfBoundsException{
        if(!positionValide(position))
            throw new IndexOutOfBoundsException();

        return obtenirElementTextuel(position).getTexte();
    }

    public String toString(){
        String texteRetourne = "";

        for(ElementTextureIMD texte : elements)
            texteRetourne += texte.getTexte();

        return texteRetourne;
    }

    private boolean positionValide(int position){
        return position >= 0 && position < taille();
    }
}
