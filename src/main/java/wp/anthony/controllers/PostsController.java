package wp.anthony.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wp.anthony.dao.PostDAO;

@Controller
public class PostsController {

    private PostDAO postDAO;

    @Autowired
    public PostsController(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @GetMapping("posts")
    public String index(Model model){
        model.addAttribute("posts", postDAO.index());
        return "posts";
    }
}
