public class Titre1 extends StyleMD {

    public Titre1() {
        super(0);
    }

    @Override
    public String formater(String texte) {
        texte = texte.trim();
        for (int i = 0; i < texte.length(); i++)
            texte += "=";
        texte = super.dispositionTexte(texte);

        return texte;
    }
}