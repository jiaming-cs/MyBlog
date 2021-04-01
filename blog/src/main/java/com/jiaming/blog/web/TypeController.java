package com.jiaming.blog.web;

import javax.validation.Valid;

import com.jiaming.blog.po.Type;
import com.jiaming.blog.service.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    private TypeService typeService = new TypeService();

    @GetMapping("/types")
    public String types(@PageableDefault(direction = Direction.DESC) Pageable pageable, Model model){

        model.addAttribute("page", typeService.getTypeList(pageable));

        return "/admin/types";
    }



    @GetMapping("/types/add-type")
    public String addType(){
        return "/admin/add-type";
    }
    
    @GetMapping("/types/{id}/delete")
    public String deleteType(@PathVariable Long id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("flag", true);
        redirectAttributes.addFlashAttribute("message", "Successfully deleted type!");
        typeService.deleteType(id);
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/edit")
    public String editType(@PathVariable Long id, Model model){
        model.addAttribute("type", typeService.getType(id));
        return "/admin/add-type";
    }

    @PostMapping("/types")
    public String postType(@Valid Type type, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("flag", false);
            model.addAttribute("message", "Type name must be specified!");
            return "/admin/add-type";
        }
        Type t = typeService.getTypeByName(type.getName());
        if (t != null){ // Find Duplicat Type
            redirectAttributes.addFlashAttribute("flag", false);
            redirectAttributes.addFlashAttribute("message", "Can not add duplicated type!");
        }else{
            t = typeService.saveType(type);
            if (t == null){
                redirectAttributes.addFlashAttribute("flag", false);
                redirectAttributes.addFlashAttribute("message", "Type name must be specified!");
            }
            else {
                redirectAttributes.addFlashAttribute("flag", true);
                redirectAttributes.addFlashAttribute("message", String.format("Successfully added type: %s!", t.getName()));
            }
        }
        
        return "redirect:/admin/types";
    }

}
