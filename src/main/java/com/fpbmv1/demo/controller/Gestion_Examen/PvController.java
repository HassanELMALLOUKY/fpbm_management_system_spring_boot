package com.fpbmv1.demo.controller.Gestion_Examen;

import com.fpbmv1.demo.Pvs.Pv1;
import com.fpbmv1.demo.dto.PvEtudiant;
import com.fpbmv1.demo.entites.*;
import com.fpbmv1.demo.entites.Module;
import com.fpbmv1.demo.services.Gestion_Examen.*;
import com.fpbmv1.demo.services.Pvs.PvsService;
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

    public PvController(PvsService pvsService, SalleService salleService, LocalService localService, FiliereService filiereService, SemestreService semestreService, ModuleService moduleService, SurveillantService surveillantService, PvService pvService, PvService pvService1) {
        this.pvsService = pvsService;
        this.salleService = salleService;
        this.localService = localService;
        this.filiereService = filiereService;
        this.semestreService = semestreService;
        this.moduleService = moduleService;
        this.surveillantService = surveillantService;
        this.pvService = pvService1;
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
    public HashMap<String,List<Pv>> importTransactionsFromExcelToDb(@RequestParam("file") List<MultipartFile> file) {
        HashMap<String,List<Pv>> PvCollection = new HashMap<>();
         PvCollection= pvsService.makePv(pvsService.importToDb(file));
         pvService.savePvs(PvCollection);
         return  PvCollection;

       // return pvsService.makePv(extractExams);


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


}
