package com.fpbmv1.demo.controller.Gestion_Examen;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Filiere;
import com.fpbmv1.demo.entites.Professeur;
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
@CrossOrigin("*")
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private FiliereService filiereService;
    @Autowired
    private EtudiantExcelImport etudiantExcelImport;


    // display list of etudiants
    @GetMapping("/alletudiant")
    public List<Etudiant> getAlletudiant() {

        return etudiantService.getAllStudents();
    }
    @GetMapping("/get/{cine}")
    public Etudiant getEtudiantByCINE(@PathVariable String cine) {
        return etudiantService.getEtudiantByCINE(cine);
    }

    @PostMapping("/saveEtudiant")
    public Etudiant saveEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.saveEtudiant(etudiant);
    }
    @DeleteMapping("/deleteEtudiant/{id}")
    public Etudiant deleteEtudiant(@PathVariable int id) {
        return  etudiantService.deleteEtudiant(id);

    }


    @PutMapping ("/{id}")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable(name = "id") int id) {
        etudiant.setId(id);
        return etudiantService.updateEtudiant(
                etudiant, id
        );
    }
    @DeleteMapping("/deleteAll")
    public Etudiant deleteAll(){
        return  etudiantService.deleteAll();

    }
    @PostMapping(path = "/importtodb")
    public Etudiant importTransactionsFromExcelToDb(@RequestParam("file") List<MultipartFile> file) {
       return etudiantService.importToDb(file);


    }
    @GetMapping("test")
    public List<Etudiant> getEtudiantsByFiliere(){
        return etudiantService.getEtudiantsByFiliere("SEG","S6","M33 :Audit General");
    }


}
