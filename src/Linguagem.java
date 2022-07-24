public class Linguagem {

    private String name;
    private String urlImage;
    private int ranking;

    public Linguagem(String name, String urlImage, int ranking) {
        this.name = name;
        this.urlImage = urlImage;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public String getUrlImage() {
        return urlImage;
    }
    
    public int getRanking() {
        return ranking;
    }

}