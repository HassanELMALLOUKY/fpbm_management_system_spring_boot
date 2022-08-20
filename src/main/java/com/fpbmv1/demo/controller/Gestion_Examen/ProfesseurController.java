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
@CrossOrigin("*")
@RequestMapping("/professeur")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;
    @Autowired
    private FiliereService filiereService;
    @Autowired
    private EtudiantExcelImport etudiantExcelImport;


    // display list of etudiants
    @GetMapping("/allprofesseur")
    public List<Professeur> getAllprofesseur() {

        return professeurService.getAllProfesseur();
    }



    @PostMapping("/saveProfesseur")
    public Professeur saveProfesseur(@RequestBody Professeur professeur) {
        return professeurService.saveProfesseur(professeur);
    }

    @PutMapping ("/{id}")
    public Professeur updateProfesseur(@RequestBody Professeur professeur, @PathVariable(name = "id") int id) {
        professeur.setId(id);
        return professeurService.updateProfesseur(
                professeur, id
        );
    }

    @DeleteMapping("/deleteProfesseur/{id}")
    public Professeur deleteProfesseur(@PathVariable int id) {
        return  professeurService.deleteProfesseur(id);

    }
    @DeleteMapping("/deleteAll")
    public Professeur deleteAll(){
        return  professeurService.deleteAll();

    }
    @PostMapping(path = "/importToDb")
    public Professeur importTransactionsFromExcelToDb(@RequestParam("file") List<MultipartFile> file) {
        return professeurService.importToDb(file);


    }


}
