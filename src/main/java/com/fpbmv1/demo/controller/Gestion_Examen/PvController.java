package com.fpbmv1.demo.controller.Gestion_Examen;

import com.fpbmv1.demo.Pvs.Pv1;
import com.fpbmv1.demo.dto.PvEtudiant;
import com.fpbmv1.demo.entites.*;
import com.fpbmv1.demo.entites.Module;
import com.fpbmv1.demo.models.Ord;
import com.fpbmv1.demo.services.Gestion_Examen.*;
import com.fpbmv1.demo.services.Pvs.PvsService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PvController {
    List<Pv1> pvs=new ArrayList<>();
    
    private PvsService pvsService;
    
    private SalleService salleService;
    
    private LocalService localService;
    
    private FiliereService filiereService;
    
    private SemestreService semestreService;
    
    private ModuleService moduleService;
    
    private SurveillantService surveillantService;

    private PvService pvService;

    private OrdreService ordreService;

    public PvController(@Lazy PvsService pvsService, SalleService salleService, LocalService localService, FiliereService filiereService, SemestreService semestreService, ModuleService moduleService, SurveillantService surveillantService, PvService pvService, PvService pvService1, OrdreService ordreService) {
        this.pvsService = pvsService;
        this.salleService = salleService;
        this.localService = localService;
        this.filiereService = filiereService;
        this.semestreService = semestreService;
        this.moduleService = moduleService;
        this.surveillantService = surveillantService;
        this.pvService = pvService1;
        this.ordreService= ordreService;
    }

    @GetMapping("/findEmptySalle")
    public List<Salle> findEmptySalle() {
        return salleService.getEmptySalles();
    }
    @GetMapping("/pv")
    public List<Pv1> addPvs(){
        Module m=new Module("spring boot");
        //pvs.add(pvsService.makePv(salleService.getSalleById(1),m));
        //pvs.add(pvsService.makePv(salleService.getSalleById(2),m));
        return pvs;
    }
    @GetMapping("/pvs")
    public List<Pv> geAllpvs(){
     return   pvService.getAllPvs();

    }


    @PostMapping(path = "/examCalender")
    public void importTransactionsFromExcelToDb(@RequestParam("file") List<MultipartFile> file) {
        HashMap<String,List<Pv>> PvCollection = new HashMap<>();
         PvCollection= pvsService.makePv(pvsService.importToDb(file));
    }
    @GetMapping("/surveillants")
    public List<Surveillant> survei(){
        return surveillantService.getSurveillantNames();
    }
    @GetMapping("/module/{nom}")
    public Module getmodule(@PathVariable String nom){
        return moduleService.getFiliereByName(nom);
    }

    @GetMapping("/free")
    public List<Salle> getFreeSalles(){

        return salleService.getEmptySalles();
    }
    @GetMapping("/pv/{cine}")
    public List<PvEtudiant> getPvsWithCINE(@PathVariable String cine){
        return pvService.getPvsWithCINE(cine);
    }

    @PostMapping("/pvById/{id}")
    public Pv getPvById(@PathVariable long id){
        return pvService.getPvById(id);
    }

    @GetMapping("/ordre/{etudiant}/{pv}")
    public Pv getOrdreByEtudiantAndPv(@PathVariable String etudiant, @PathVariable String pv){
        return ordreService.getOrdreByEtudiantAndPv(Integer.parseInt(etudiant), Integer.parseInt(pv));
    }
    @GetMapping("/ordre/{etudiant}")
    public List<Ordre> getOrdreByEtudiant(@PathVariable Etudiant etudiant){
        return ordreService.getOrdreList(etudiant);
    }
    @GetMapping("/ordre1/{id}")
    public List<Etudiant> getOrdreByEtudiant(@PathVariable String id){
        return ordreService.getOrdreList1(id);
    }

}
