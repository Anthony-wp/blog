package wp.anthony.dao;

import org.springframework.stereotype.Component;
import wp.anthony.models.Post;

import java.sql.*;
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
                post.setTitle(resultSet.getString("title"));
                post.setAnons(resultSet.getString("anons"));
                post.setFullText(resultSet.getString("full_text"));
                post.setTheme(resultSet.getString("theme"));
                post.setViews(resultSet.getInt("views"));

                posts.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return posts;
    }

    public List<Post> showByType(String type){
        List<Post> posts = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM post WHERE theme=?");
            preparedStatement.setString(1, type);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Post post = new Post();

                post.setId(resultSet.getInt("id"));
                post.setTitle(resultSet.getString("title"));
                post.setAnons(resultSet.getString("anons"));
                post.setFullText(resultSet.getString("full_text"));
                post.setTheme(resultSet.getString("theme"));
                post.setViews(resultSet.getInt("views"));

                posts.add(post);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return posts;

    }

    public void save(Post post) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Post VALUES(?, ?, ?, ?, ?, 0)");

            preparedStatement.setInt(1, post.getId());
            preparedStatement.setString(2, post.getTitle());
            preparedStatement.setString(3, post.getAnons());
            preparedStatement.setString(4, post.getFullText());
            preparedStatement.setString(5, post.getTheme());


            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
