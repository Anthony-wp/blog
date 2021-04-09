package wp.anthony.dao;

import org.springframework.stereotype.Component;
import wp.anthony.models.Post;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostDAO {

    private static Connection connection;

    static {
        connection = ConnectionManager.getConnection();
    }

    public List<Post> index(){
        List<Post> posts = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM post";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Post post = new Post();

                post.setId(resultSet.getInt("id"));
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("title"));
                post.setTitle(resultSet.getString("title"));
                post.setAnons(resultSet.getString("anons"));
                post.setFull_text(resultSet.getString("full_text"));
                post.setTheme(resultSet.getString("theme"));
                post.setViews(resultSet.getInt("views"));

                posts.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(posts);
        return posts;
    }


}
