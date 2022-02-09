import java.util.ArrayList;

public class DocumentMD {
    private ArrayList<ElementTextuelMD> elements;

    public DocumentMD(){
        elements = new ArrayList<ElementTextuelMD>();
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
     * @param elementTextuelMD
     */
    public void ajouterElementTextuel(ElementTextuelMD elementTextuelMD){
        elements.add(elementTextuelMD);
    }

    public void ajouterElementTextuel(int position, ElementTextuelMD eltTexteMD) throws ElementTextuelMDInvalideException{
        if(eltTexteMD != null && !positionValide(position))
            throw new ElementTextuelMDInvalideException();
        elements.add(position, eltTexteMD);
    }

    public ElementTextuelMD supprimerElementTextuel(int position) throws IndexOutOfBoundsException{
        if(!positionValide(position))
            throw new IndexOutOfBoundsException();
        return elements.remove(position);
    }

    public ElementTextuelMD remplacerElementTextuel(int position, ElementTextuelMD eltTexteMD) throws ElementTextuelMDInvalideException, IndexOutOfBoundsException{
        if(eltTexteMD == null)
            throw new ElementTextuelMDInvalideException();
        if(eltTexteMD != null && !positionValide(position))
            throw new IndexOutOfBoundsException();

        ajouterElementTextuel(position, eltTexteMD);

        return supprimerElementTextuel(position + 1);
    }

    public ElementTextuelMD obtenirElementTextuel(int position) throws IndexOutOfBoundsException{
        ElementTextuelMD elementEnlever;
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

    public void modifierTexte(int position, String texte) throws IndexOutOfBoundsException, ElementTextuelMDInvalideException, StyleMDInvalideException{
        if(!positionValide(position))
            throw new IndexOutOfBoundsException();
        if(positionValide(position) && (texte.equals(null) || texte.trim().isEmpty()))
            throw new ElementTextuelMDInvalideException();

        supprimerElementTextuel(position);

        try{
            ajouterElementTextuel(position, new ElementTextuelMD(texte, obtenirElementTextuel(position).getStyle()));
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

        for(ElementTextuelMD texte : elements)
            texteRetourne += texte.toString();

        return texteRetourne;
    }

    private boolean positionValide(int position){
        return !(position < 0 && position >= taille());
    }
}
