package wp.anthony.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import wp.anthony.dao.PostDAO;
import wp.anthony.models.Post;

import javax.validation.Valid;

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


    @GetMapping("/new")
    public String newPost(Model model){
        model.addAttribute("post", new Post());

        return "post-add";
    }

    @PostMapping()
    public String create(@ModelAttribute("post") @Valid Post post, BindingResult bindingResult){

        if (bindingResult.hasErrors())
            return "post-add";

        postDAO.save(post);
        return "redirect:/";
    }

}
