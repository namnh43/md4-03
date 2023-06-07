package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IProductService;
import service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService<Product> productService = new ProductService();
    @GetMapping
    public String index(Model model) {
        model.addAttribute("list", productService.findAll());
        return "index";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        productService.removeById(id);
        redirect.addFlashAttribute("success","Delete OK");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        return null;
    }

}
