package cz.czechitas.java2webapps.ukol6.Controller;

import cz.czechitas.java2webapps.ukol6.Repository.VizitkaRepository;
import cz.czechitas.java2webapps.ukol6.entity.Vizitka;

import jakarta.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@Controller
public class VizitkaController {
    private VizitkaRepository vizitkaRepository;

    public VizitkaController(VizitkaRepository vizitkaRepository) {
        this.vizitkaRepository = vizitkaRepository;
    }

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {

        //prázdné textové řetězce nahradit null hodnotou
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView modelAndView = new ModelAndView("seznam");
        modelAndView.addObject("seznam", vizitkaRepository.findAll());
        return modelAndView;
    }

    @GetMapping("detail/{id}")
    public Object detail(@PathVariable int id) {
        ModelAndView detail = new ModelAndView("vizitka");
        Optional<Vizitka> vizitkaOptional = vizitkaRepository.findById(id);
        if (vizitkaOptional.isPresent()) {
            detail.addObject("vizitka", vizitkaOptional.get());
            return detail;
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nova")
    public ModelAndView nova() {
        ModelAndView nova = new ModelAndView("formular")
                .addObject("vizitka", new Vizitka())
                .addObject("nova", true);
        return nova;
    }

    @PostMapping("/nova")
    public ModelAndView nova(@Valid @ModelAttribute("vizitka") Vizitka vizitka, BindingResult bindingResult) {
        ModelAndView nova = new ModelAndView("formular")
                .addObject("vizitka", vizitka);

        if (bindingResult.hasErrors()) {
            nova.addObject("nova", true);
            return nova;
        }

        vizitkaRepository.save(vizitka);
        nova.addObject("seznam", vizitkaRepository.findAll());
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/smazat")
    public String smazat(int id) {
        vizitkaRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/upravit")
    public ModelAndView upravit(int id) {
        ModelAndView modelAndView = new ModelAndView("/formular")
                .addObject("vizitka", vizitkaRepository.findById(id).get())
                .addObject("nova", false);
        return modelAndView;
    }

    @PostMapping("/upravit")
    public ModelAndView ulozitUpravy(@Valid @ModelAttribute("vizitka") Vizitka vizitka, BindingResult bindingResult){
        return nova(vizitka, bindingResult);
    }


}