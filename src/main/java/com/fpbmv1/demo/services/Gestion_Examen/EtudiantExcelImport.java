package com.fpbmv1.demo.services.Gestion_Examen;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fpbmv1.demo.entites.Etudiant;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EtudiantExcelImport {
    private EtudiantService etudiantService;
    private FiliereService filiereService;

    public EtudiantExcelImport(EtudiantService etudiantService, FiliereService filiereService) {
        this.etudiantService = etudiantService;
        this.filiereService = filiereService;
    }

    public void importToDb(List<MultipartFile> multipartfiles) {
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
                etudiantService.saveAll(etudiants);
            }
        }
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
