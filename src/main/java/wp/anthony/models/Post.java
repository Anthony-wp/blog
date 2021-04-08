package wp.anthony.models;

public class Post {

    private int id;

    private String title;
    private String anons;
    private String full_text;
    private String theme;

    private int views;


    public Post(int id, String title, String anons, String full_text, String theme, int views) {
        this.id = id;
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
        this.theme = theme;
        this.views = views;
    }
    public Post(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
