package com.fpbmv1.demo.controller.Gestion_Examen;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.services.Gestion_Examen.EtudiantExcelImport;
import com.fpbmv1.demo.services.Gestion_Examen.Excel.ModuleExcelImport;
import com.fpbmv1.demo.services.Gestion_Examen.LocalService;
import com.fpbmv1.demo.services.Gestion_Examen.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/module")
public class ModuleController {


    private ModuleExcelImport moduleExcelImport;

    private ModuleService moduleService;
    private LocalService localService;

    public ModuleController(ModuleExcelImport moduleExcelImport, ModuleService moduleService, LocalService localService) {
        this.moduleExcelImport = moduleExcelImport;
        this.moduleService = moduleService;
        this.localService=localService;
    }

    @GetMapping()
    public String viewHomePage(Model model) {
        model.addAttribute("listModules", moduleService.getAllModules());
        return "Module/index";
    }
    @PostMapping(path = "/import-to-db")
    public String importTransactionsFromExcelToDb(@RequestParam("file") List<MultipartFile> file) {
        moduleExcelImport.importToDb(file);
        return "redirect:/Module";

    }
    @GetMapping("/test")
    public List<Etudiant> test(){
        return localService.findAllEtudiantByFiliere();
    }
}
