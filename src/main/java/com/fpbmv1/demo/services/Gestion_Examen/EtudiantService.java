package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Professeur;
import com.fpbmv1.demo.repository.EtudiantRepository;
import com.fpbmv1.demo.entites.Etudiant;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EtudiantService{
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private FiliereService filiereService;

    public List<Etudiant> getAllStudents() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(long id) {

        return etudiantRepository.findById(id).get();
    }
    public Etudiant getEtudiantByCINE(String cine) {

        return etudiantRepository.getEtudiantsByCINE(cine);
    }

    public Etudiant saveEtudiant(Etudiant etudiant) {

        return etudiantRepository.save(etudiant);
    }

    public Etudiant deleteEtudiant(long id) {
        etudiantRepository.deleteById(id);
    return null;
    }
    public Etudiant deleteAll(){
        etudiantRepository.deleteAll();
        return null;
    }

    public void saveAll(List<Etudiant> etudiants) {
        etudiantRepository.saveAll(etudiants);
    }
   public List<Etudiant> getEtudiantsByFiliere(String f,String s,String m){
        return etudiantRepository.getEtudiantsByFiliere(f,s,m);
    }
    public Etudiant updateEtudiant(Etudiant etudiant, int id) {
        etudiant.setId(id);
        return etudiantRepository.save(etudiant);
    }
    public Etudiant importToDb(List<MultipartFile> multipartfiles) {
        if (!multipartfiles.isEmpty()) {
            List<Etudiant> etudiants = new ArrayList<>();
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
                        String nom = row.getCell(0).getStringCellValue();
                        String prenom = row.getCell(1).getStringCellValue();
                        String CINE = row.getCell(2).getStringCellValue();
                        long appoge= (long) row.getCell(3).getNumericCellValue();
                        String cne = row.getCell(4).getStringCellValue();
                        String filiere=row.getCell(5).getStringCellValue();
                        Date dateN=row.getCell(6).getDateCellValue();

                        Etudiant etudiant = new Etudiant();
                        etudiant.setNom(nom);
                        etudiant.setPrenom(prenom);
                        etudiant.setCne(cne);
                        etudiant.setCINE(CINE);
                        etudiant.setAppogee(appoge);
                        etudiant.setDateNaissance(dateN);
                        etudiant.setFiliere(filiereService.getFiliereByName(filiere));

                        etudiants.add(etudiant);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            if (!etudiants.isEmpty()) {
                // save to database
               saveAll(etudiants);
            }
        }
        return null;
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
