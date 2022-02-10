import java.util.ArrayList;

/**
 * Classe qui créer un document Markdown à partir d'une liste d'ÉlémentTextuelMD.
 *
 * @author Dérick Gagnon
 * Code permanent: GAGD84110109
 * Courriel: ggg991987@ens.uqam.ca
 * Cours: INF2050
 * gr: 20
 * @version 8 Février 2022
 */
public class DocumentMD {
    //attributs d'instance
    private ArrayList<ElementTextuelMD> elements;

    /**
     * Constructeur par défaut qui instancie la liste elements.
     */
    public DocumentMD(){
        elements = new ArrayList<ElementTextuelMD>();
    }

    /**
     * Retourne le nombre d'ElementsTextuelsMD dans ce doncument.
     *
     * @return retourne la taille de la liste elements
     */
    public int taille(){
        return elements.size();
    }

    /**
     * Cette méthode permet d'ajouter un élément textuel à la fin de la liste d'éléments
     *
     * @param elementTextuelMD l'ElementTextuelMD à ajouter
     */
    public void ajouterElementTextuel(ElementTextuelMD elementTextuelMD){
        elements.add(elementTextuelMD);
    }

    /**
     * Permet d'ajouter un élément à la liste d'éléments à la position voulue
     *
     * @param position la position dans la liste d'éléments
     * @param eltTexteMD l'éléments à ajouter dans la liste
     * @throws ElementTextuelMDInvalideException
     */
    public void ajouterElementTextuel(int position, ElementTextuelMD eltTexteMD) throws ElementTextuelMDInvalideException{
        if(eltTexteMD != null && !positionValide(position))
            throw new ElementTextuelMDInvalideException();
        elements.add(position, eltTexteMD);
    }

    /**
     * Permet de supprimer un ElementTextuelMD de la liste d'éléments à la position voulue
     *
     * @param position la position dans la liste d'éléments
     * @return l'éléments qui a été enlevé
     * @throws IndexOutOfBoundsException
     */
    public ElementTextuelMD supprimerElementTextuel(int position) throws IndexOutOfBoundsException{
        if(!positionValide(position))
            throw new IndexOutOfBoundsException();
        return elements.remove(position);
    }

    /**
     * Remplace un élément da la liste d'éléments à la position voulue
     *
     * @param position la position dans la liste
     * @param eltTexteMD l'ElementTextuelMD à ajouter
     * @return retourne l'élément qui a été remplacé
     * @throws ElementTextuelMDInvalideException
     * @throws IndexOutOfBoundsException
     */
    public ElementTextuelMD remplacerElementTextuel(int position, ElementTextuelMD eltTexteMD) throws ElementTextuelMDInvalideException, IndexOutOfBoundsException{
        if(eltTexteMD == null)
            throw new ElementTextuelMDInvalideException();
        if(eltTexteMD != null && !positionValide(position))
            throw new IndexOutOfBoundsException();

        ajouterElementTextuel(position, eltTexteMD);

        return supprimerElementTextuel(position + 1);
    }

    /**
     * Permet d'obtenir un élément à la position souhaité de la liste d'ElementTextuelMD
     *
     * @param position la position dans la liste d'éléments
     * @return l'ElementTextuelMD dans la liste
     * @throws IndexOutOfBoundsException
     */
    public ElementTextuelMD obtenirElementTextuel(int position) throws IndexOutOfBoundsException{
        ElementTextuelMD elementEnlever;
        if(!positionValide(position))
            throw new IndexOutOfBoundsException();

        elementEnlever = supprimerElementTextuel(position);
        elements.add(position, elementEnlever);

        return elementEnlever;
    }

    /**
     * Permet de modifier le style d'un ElementTextuelMD de la liste
     *
     * @param position la position dans la liste
     * @param style le nouveau style
     * @throws IndexOutOfBoundsException
     * @throws StyleMDInvalideException
     */
    public void modifierStyle(int position, StyleMD style) throws IndexOutOfBoundsException,StyleMDInvalideException{
        if(!positionValide(position))
            throw new IndexOutOfBoundsException();
        if(positionValide(position) && style == null)
            throw new StyleMDInvalideException();

        obtenirElementTextuel(position).setStyle(style);
    }

    /**
     * Permet de modifier le style d'un ElementTextuelMD de la liste
     *
     * @param position la position dans la liste
     * @param texte le nouveau texte
     * @throws IndexOutOfBoundsException
     * @throws ElementTextuelMDInvalideException
     * @throws StyleMDInvalideException
     */
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

    /**
     * Permet d'obtenir le texte d'un ElementTextuelMD à la position souhaitée
     * @param position la position dans la liste
     * @return retourne le texte de l'ElementTextuelMD
     * @throws IndexOutOfBoundsException
     */
    public String obtenirMarkdown(int position) throws IndexOutOfBoundsException{
        if(!positionValide(position))
            throw new IndexOutOfBoundsException();

        return obtenirElementTextuel(position).getTexte();
    }

    @Override
    /**
     * Redéfénition de la méthode toString de la classe Object. Retourne le texte en markdown de
     * tous les éléments de la liste
     */
    public String toString(){
        String texteRetourne = "";

        for(ElementTextuelMD texte : elements)
            texteRetourne += texte.toString();

        return texteRetourne;
    }

    /**
     * Regarde si une position est valide. Une position valide est plus grande ou égal à 0 et
     * plus petite que la taille de la liste.
     * @param position
     * @return
     */
    private boolean positionValide(int position){
        return !(position < 0 && position >= taille());
    }
}
