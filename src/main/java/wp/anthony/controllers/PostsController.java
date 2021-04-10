package wp.anthony.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wp.anthony.dao.PostDAO;

@Controller
public class PostsController {

    private PostDAO postDAO;

    @Autowired
    public PostsController(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @GetMapping("/{type}")
    public String showByType(@PathVariable("type") String type, Model model){
        model.addAttribute("posts", postDAO.showByType(type));
        return "posts";
    }

}
