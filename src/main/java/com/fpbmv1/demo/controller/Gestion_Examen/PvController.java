package com.fpbmv1.demo.controller.Gestion_Examen;

import com.fpbmv1.demo.Pvs.Pv;
import com.fpbmv1.demo.entites.*;
import com.fpbmv1.demo.entites.Module;
import com.fpbmv1.demo.models.ExcelPv;
import com.fpbmv1.demo.models.SurveillantsNameModel;
import com.fpbmv1.demo.services.Gestion_Examen.*;
import com.fpbmv1.demo.services.Pvs.PvsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PvController {
    List<Pv> pvs=new ArrayList<>();
    
    private PvsService pvsService;
    
    private SalleService salleService;
    
    private LocalService localService;
    
    private FiliereService filiereService;
    
    private SemestreService semestreService;
    
    private ModuleService moduleService;
    
    private SurveillantService surveillantService;

    public PvController(PvsService pvsService, SalleService salleService, LocalService localService, FiliereService filiereService, SemestreService semestreService, ModuleService moduleService, SurveillantService surveillantService) {
        this.pvsService = pvsService;
        this.salleService = salleService;
        this.localService = localService;
        this.filiereService = filiereService;
        this.semestreService = semestreService;
        this.moduleService = moduleService;
        this.surveillantService = surveillantService;
    }

    @GetMapping("/findEmptySalle")
    public List<Salle> findEmptySalle() {
        return salleService.getEmptySalles();
    }
    @GetMapping("/pv")
    public List<Pv> addPvs(){
        Module m=new Module("spring boot");
        //pvs.add(pvsService.makePv(salleService.getSalleById(1),m));
        //pvs.add(pvsService.makePv(salleService.getSalleById(2),m));
        return pvs;
    }
    /*@GetMapping("/test/filiere={f}&semestre={semestre}&module={module}")
    public List<Pv> test(@PathVariable  String semestre, @PathVariable String module,@PathVariable(value = "f") String filiere){
        return pvsService.makePv(filiere,semestre,module) ;

    }*/

    @PostMapping(path = "/examCalender")
    public HashMap<String,List<Pv>> importTransactionsFromExcelToDb(@RequestParam("file") List<MultipartFile> file) {
         return pvsService.makePv(pvsService.importToDb(file));

       // return pvsService.makePv(extractExams);


    }
    @GetMapping("/surveillants")
    public List<Surveillant> survei(){
        return surveillantService.getSurveillantNames();
    }

    @GetMapping("/free")
    public void getFreeSalles(){
        salleService.freeSalle();
    }

}
