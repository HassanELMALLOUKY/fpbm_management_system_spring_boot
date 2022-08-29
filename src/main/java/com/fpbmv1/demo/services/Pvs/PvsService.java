package com.fpbmv1.demo.services.Pvs;

import com.fpbmv1.demo.Pvs.Pv;
import com.fpbmv1.demo.entites.*;
import com.fpbmv1.demo.entites.Module;
import com.fpbmv1.demo.models.ExcelPv;
import com.fpbmv1.demo.models.ExtractExcelModel;
import com.fpbmv1.demo.services.Gestion_Examen.*;
import lombok.Data;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Service
public class PvsService {
    private Pv pv;

    private SurveillantService surveillantService;

    private ProfesseurService professeurService;

    private SalleService salleService;

    private ExamenService examenService;

    private EtudiantService etudiantService;

    private FiliereService filiereService;

    private SemestreService semestreService;

    private ModuleService moduleService;

    public PvsService(SurveillantService surveillantService, ProfesseurService professeurService,
                      SalleService salleService,
                      ExamenService examenService, EtudiantService etudiantService,
                      FiliereService filiereService, SemestreService semestreService,
                      ModuleService moduleService) {
        this.surveillantService = surveillantService;
        this.professeurService = professeurService;
        this.salleService = salleService;
        this.examenService = examenService;
        this.etudiantService = etudiantService;
        this.filiereService = filiereService;
        this.semestreService = semestreService;
        this.moduleService = moduleService;
    }

    //Num de la salle
    private int index=0;
    private int indexExcel=0;
    public HashMap<String,List<Pv>> makePv(HashMap<String, List<ExcelPv>> extractExams){

        HashMap<String,List<Pv>> PvCollection = new HashMap<>();
        for(Map.Entry<String, List<ExcelPv>> extractExam : extractExams.entrySet()) {
            String key = extractExam.getKey();
            List<ExcelPv> value = extractExam.getValue();
            System.out.println("début de date et heure : " +key);
            value.forEach(excelPv -> {
                System.out.println("filiere: "+excelPv.getFiliere());
                int nbEtudiantsCourants=0;
                int nbSurveillantsCourants=0;
                Filiere f=filiereService.getFiliereByName(excelPv.getFiliere());
                Semestre s=semestreService.getFiliereByName(excelPv.getSemestre());
                Module m=moduleService.getFiliereByName(excelPv.getModule());

                List<Pv> pvs=new ArrayList<Pv>();
                List<Surveillant> surveillants=surveillantService.getSurveillantNames();
                System.out.println("surv : "+surveillants.size());
                List<Etudiant> etudiants=etudiantService.getEtudiantsByFiliere(f.getName(),s.getName(),m.getName());
                System.out.println("etd : "+etudiants.size());
                //Le nombre d'etudiants qui pas encore affecter à une salle d'examen
                int restEtud=etudiants.size();

                //Le nombre des surveillants qui pas encore affecter à une salle d'examen
                int restSurveillants=surveillants.size();

                while(restEtud>0 && restSurveillants>0 ){
                    List<Salle> salles=salleService.getEmptySalles();


                    //chercher la capacite des salles la plus proche du reste d'etudiants:
                    //Rest.stream().min().get();
                    System.out.println("nb salles:"+salles.size());
                    Pv pv=new Pv();
                    pv.setLocalDateTime(LocalDateTime.now());
                    pv.setLocal(salles.get(index).getName());
                    //pv.setModule(m.getName());
                    //distrubier les etudiants dans les salles disponibles
                    if(restEtud>salles.get(index).getCapaciteEtudiant()){
                        pv.setEtudiants(etudiants.subList(nbEtudiantsCourants,salles.get(index).getCapaciteEtudiant()+nbEtudiantsCourants));
                        nbEtudiantsCourants+=salles.get(index).getCapaciteEtudiant();

                    }else{
                        pv.setEtudiants(etudiants.subList(nbEtudiantsCourants,etudiants.size()));

                    }
                    //metrre la salle occupée
                    salles.get(index).setDisponible(false);
                    //mettre la salle occupée
                    salleService.updateSalle(salles.get(index),salles.get(index).getId());
                    //distrubier les surveillants dans les salles disponibles
                    if(restSurveillants>=salles.get(index).getNombreSurveillant()){
                        pv.setSurveillants(surveillants.subList(nbSurveillantsCourants,salles.get(index).getNombreSurveillant()+nbSurveillantsCourants));
                        nbSurveillantsCourants+=salles.get(index).getNombreSurveillant();
                    }
                    else{
                        pv.setSurveillants(surveillants.subList(nbSurveillantsCourants,surveillants.size()));

                    }

                    restSurveillants-=salles.get(index).getNombreSurveillant();
                    restEtud -=salles.get(index).getCapaciteEtudiant();

                    //index++;

                    pvs.add(pv);




                }
                //si les salles ne sont pas suffisantes
                if(restEtud>0){
                    System.out.println("affecter : "+restEtud+" étudinats à la salle X sont: "+etudiants.subList(nbEtudiantsCourants,etudiants.size()));
                }

                PvCollection.put(excelPv.getModule(),pvs);

            });
            System.out.println("fin de date et heure : " +key);
            salleService.freeSalle();

        }


        return PvCollection;
    }

    public List<ExcelPv> splitByTimeAndDate(List<ExcelPv> excelPvs, String time, String date){
        List<ExcelPv> result = new ArrayList<>();
        excelPvs.forEach(excelPv ->{

            if(excelPv.getDate().equals(date) && excelPv.getHeure().equals(time)){
                result.add(excelPv);
            }

        });
        return result;
    }
    public Filiere makepv2(String filiere){
        Filiere f=filiereService.getFiliereByName(filiere);
        return f;

    }

    public HashMap<String,List<ExcelPv>> importToDb(List<MultipartFile> multipartfiles) {
        this.indexExcel=0;
        HashMap<String,List<ExcelPv>> extractExams=new HashMap<>();
        List<ExcelPv> excelPvs = new ArrayList<>();
        final int index = 0;
        if (!multipartfiles.isEmpty()) {

            multipartfiles.forEach(multipartfile -> {
                try {
                    XSSFWorkbook workBook = new XSSFWorkbook(multipartfile.getInputStream());

                    XSSFSheet sheet = workBook.getSheetAt(0);
                    // looping through each row
                    for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) ; rowIndex++) {
                        // current row
                        XSSFRow row = sheet.getRow(rowIndex);
                        // skip the first row because it is a header row
                        if (rowIndex == 0) {
                            continue;
                        }
                        String date = row.getCell(0).getStringCellValue();
                        String filiere=row.getCell(1).getStringCellValue();
                        String sem= row.getCell(2).getStringCellValue();
                        String module=row.getCell(3).getStringCellValue();
                        String responsableModule=row.getCell(4).getStringCellValue();
                        String heure=row.getCell(5).getStringCellValue();
                        ExcelPv excelPv=new ExcelPv(date,filiere,sem,module,responsableModule,heure);
                        //System.out.println("excelPv: " + excelPv.toString());
                        excelPvs.add(excelPv);
                        if(rowIndex==sheet.getLastRowNum()){
                            System.out.println("wow");
                            if(date!=sheet.getRow(rowIndex-1).getCell(0).getStringCellValue() ||
                                    heure!=sheet.getRow(rowIndex-1).getCell(5).getStringCellValue()){
                                extractExams.put(date+" "+heure,List.copyOf(excelPvs));
                                break;
                            }
                            break;


                        }

                        if(date!=sheet.getRow(rowIndex+1).getCell(0).getStringCellValue() ||
                                heure!=sheet.getRow(rowIndex+1).getCell(5).getStringCellValue()){
                            extractExams.put(date+" "+heure,List.copyOf(excelPvs));
                            excelPvs.clear();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("finale extractExams size:"+extractExams.size());

        return extractExams;
    }
    public static int getNumberOfNonEmptyCells(XSSFSheet sheet, int columnIndex) {
        int numOfNonEmptyCells = 0;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {
                XSSFCell cell = row.getCell(columnIndex);
                if (cell != null) {
                    numOfNonEmptyCells++;
                }
            }
        }
        return numOfNonEmptyCells;
    }

}
