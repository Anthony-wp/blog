package wp.anthony.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Post {
    private int id;
    private static int countPosts = 2;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 500, message = "Title should be between 2 and 500 characters")
    private String title;

    @NotEmpty(message = "Anons should not be empty")
    @Size(min = 10, max = 2000, message = "Anons should be between 10 and 2000 characters")
    private String anons;

    @NotEmpty(message = "Text should not be empty")
    @Size(min = 10, max = 10000, message = "Anons should be between 10 and 10000 characters")
    private String fullText;

    private String theme;
    private Integer views;

    public Post() {
    }

    public Post(int id, String title, String anons, String fullText, String theme) {
        this.id = countPosts++;
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
        this.theme = theme;

    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 500)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "anons", nullable = true, length = 2000)
    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    @Basic
    @Column(name = "full_text", nullable = true, length = 10000)
    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    @Basic
    @Column(name = "theme", nullable = true)
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Basic
    @Column(name = "views", nullable = true)
    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (id != post.id) return false;
        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (anons != null ? !anons.equals(post.anons) : post.anons != null) return false;
        if (fullText != null ? !fullText.equals(post.fullText) : post.fullText != null) return false;
        if (theme != null ? !theme.equals(post.theme) : post.theme != null) return false;
        if (views != null ? !views.equals(post.views) : post.views != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (anons != null ? anons.hashCode() : 0);
        result = 31 * result + (fullText != null ? fullText.hashCode() : 0);
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (views != null ? views.hashCode() : 0);
        return result;
    }
}
