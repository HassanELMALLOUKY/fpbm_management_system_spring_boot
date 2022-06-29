package com.fpbmv1.demo.controller.Gestion_Examen;

import com.fpbmv1.demo.Pvs.Pv;
import com.fpbmv1.demo.entites.*;
import com.fpbmv1.demo.entites.Module;
import com.fpbmv1.demo.services.Gestion_Examen.*;
import com.fpbmv1.demo.services.Pvs.PvsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PvController {
    List<Pv> pvs=new ArrayList<>();
    @Autowired
    private PvsService pvsService;
    @Autowired
    private SalleService salleService;
    @Autowired
    private LocalService localService;
    @Autowired
    private FiliereService filiereService;
    @Autowired
    private SemestreService semestreService;
    @Autowired
    private ModuleService moduleService;
    @GetMapping("/pv")
    public List<Pv> addPvs(){
        Module m=new Module("spring boot");
        //pvs.add(pvsService.makePv(salleService.getSalleById(1),m));
        //pvs.add(pvsService.makePv(salleService.getSalleById(2),m));
        return pvs;
    }
    @GetMapping("/test")
    public List<Pv> test(){
        return pvsService.makePv("ISI","S1","Spring") ;

    }
}
