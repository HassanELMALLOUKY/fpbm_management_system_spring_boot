package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Professeur;
import com.fpbmv1.demo.entites.Professeur;
import com.fpbmv1.demo.repository.ProfesseurRepository;
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
public class ProfesseurService {
    @Autowired
    private ProfesseurRepository professeurRepository;

    public List<Professeur> getAllProfesseur() {
        return professeurRepository.findAll();
    }

    public Professeur getProfesseurById(int id) {

        return professeurRepository.findById(id).get();
    }
    public Professeur updateProfesseur(Professeur professeur, int id) {
        professeur.setId(id);
        return professeurRepository.save(professeur);
    }
    public Professeur saveProfesseur(Professeur professeur) {

        return professeurRepository.save(professeur);
    }

    public Professeur deleteProfesseur(Integer id) {
        professeurRepository.deleteById(id);
      return  null;
    }
    public Professeur deleteAll(){
        professeurRepository.deleteAll();
        return null;
    }

    public void saveAll(List<Professeur> professeurs) {
        professeurRepository.saveAll(professeurs);
    }
    public Professeur importToDb(List<MultipartFile> multipartfiles) {
        if (!multipartfiles.isEmpty()) {
            List<Professeur> professeurs = new ArrayList<>();
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
                        String cine = row.getCell(2).getStringCellValue();
                        String grade = row.getCell(3).getStringCellValue();
                        Date dateNaissance=row.getCell(4).getDateCellValue();

                        Professeur professeur = new Professeur();
                        professeur.setNom(nom);
                        professeur.setPrenom(prenom);
                        professeur.setCINE(cine);
                        professeur.setGrade(grade);
                        professeur.setDateNaissance(dateNaissance);


                        professeurs.add(professeur);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            if (!professeurs.isEmpty()) {
                // save to database
                saveAll(professeurs);
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
