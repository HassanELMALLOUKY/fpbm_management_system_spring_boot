package com.fpbmv1.demo.controller.Gestion_Examen;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Professeur;
import com.fpbmv1.demo.services.Gestion_Examen.EtudiantExcelImport;
import com.fpbmv1.demo.services.Gestion_Examen.ProfesseurService;
import com.fpbmv1.demo.services.Gestion_Examen.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/professeur")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;
    @Autowired
    private FiliereService filiereService;
    @Autowired
    private EtudiantExcelImport etudiantExcelImport;


    // display list of etudiants
    @GetMapping()
    public List<Professeur> viewHomePage(Model model) {
        /*model.addAttribute("listProfesseurs", professeurService.getAllStudents());
        return "Professeur/index";*/
        return professeurService.getAllStudents();
    }

    @GetMapping("/home")
    public String home() {
        return "Home";
    }

    @GetMapping("/showNewProfesseurForm")
    public String showNewProfesseurForm(Model model) {
        // create model attribute to bind form data
        Professeur professeur = new Professeur();
        model.addAttribute("professeur", professeur);
        return "Professeur/new_etudiant";
    }

    @PostMapping("/saveProfesseur")
    public String saveProfesseur(@ModelAttribute("etudiant") Professeur professeur) {
        //etudiant.setFiliere(filiereService.getFiliereByName(nameF));
        // save etudiant to database
        professeurService.saveProfesseur(professeur);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        // get etudiant from the service
        Professeur professeur = professeurService.getProfesseurById(id);

        // set etudiant as a model attribute to pre-populate the form
        model.addAttribute("professeur", professeur);

        return "Professeur/update_etudiant";
    }

    @GetMapping("/deleteProfesseur/{id}")
    public String deleteProfesseur(@PathVariable(value = "id") int id) {

        // call delete etudiant method 
        this.professeurService.deleteProfesseur(id);
        return "redirect:/";
    }

    @GetMapping("/deleteAll")
    public String deleteAll() {
        this.professeurService.deleteAll();
        return "redirect:/";
    }

    @PostMapping(path = "/import-to-db")
    public String importTransactionsFromExcelToDb(@RequestParam("file") List<MultipartFile> file) {
        etudiantExcelImport.importToDb(file);
        return "redirect:/";

    }

}
