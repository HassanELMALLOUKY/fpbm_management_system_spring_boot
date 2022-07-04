package com.fpbmv1.demo.controller.Gestion_Examen;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Filiere;
import com.fpbmv1.demo.services.Gestion_Examen.EtudiantExcelImport;
import com.fpbmv1.demo.services.Gestion_Examen.EtudiantService;
import com.fpbmv1.demo.services.Gestion_Examen.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private FiliereService filiereService;
    @Autowired
    private EtudiantExcelImport etudiantExcelImport;


    // display list of etudiants
    @GetMapping("/all")
    public String viewHomePage(Model model) {
        model.addAttribute("listEtudiants", etudiantService.getAllStudents());
        return "Etudiant/index";
    }
    @GetMapping()
    public String home(){
        return "Home";
    }

    @GetMapping("/showNewEtudiantForm")
    public String showNewEtudiantForm(Model model) {
        // create model attribute to bind form data
        Etudiant etudiant = new Etudiant();
        //Filiere filiere = new Filiere();
        model.addAttribute("filieres",filiereService.getAllFiliere());
        model.addAttribute("etudiant", etudiant);
        return "Etudiant/new_etudiant";
    }

    @PostMapping("/saveEtudiant")
    public String saveEtudiant(@ModelAttribute("etudiant") Etudiant etudiant) {
        //etudiant.setFiliere(filiereService.getFiliereByName(nameF));
        // save etudiant to database
        etudiantService.saveEtudiant(etudiant);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        // get etudiant from the service
        Etudiant etudiant = etudiantService.getEtudiantById(id);

        // set etudiant as a model attribute to pre-populate the form
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("filieres",filiereService.getAllFiliere());

        return "Etudiant/update_etudiant";
    }

    @GetMapping("/deleteEtudiant/{ID}")
    public String deleteEtudiant(@PathVariable(value = "ID") int id) {

        // call delete etudiant method 
        this.etudiantService.deleteEtudiant(id);
        return "redirect:/";
    }
    @GetMapping("/deleteAll")
    public String deleteAll(){
        this.etudiantService.deleteAll();
        return "redirect:/";
    }
    @PostMapping(path = "/import-to-db")
    public String importTransactionsFromExcelToDb(@RequestParam("file") List<MultipartFile> file) {
        etudiantExcelImport.importToDb(file);
        return "redirect:/";

    }
    @GetMapping("test")
    public List<Etudiant> getEtudiantsByFiliere(){
        return etudiantService.getEtudiantsByFiliere("ISI","S1","Spring");
    }

}
