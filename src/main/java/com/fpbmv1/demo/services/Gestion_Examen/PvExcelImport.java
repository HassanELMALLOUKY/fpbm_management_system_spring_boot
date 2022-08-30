package com.fpbmv1.demo.services.Gestion_Examen;

import com.fpbmv1.demo.entites.Etudiant;
import com.fpbmv1.demo.entites.Pv;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PvExcelImport {
    private EtudiantService etudiantService;
    private FiliereService filiereService;
    private PvService pvService;

    public PvExcelImport(EtudiantService etudiantService, FiliereService filiereService,PvService pvService) {
        this.etudiantService = etudiantService;
        this.filiereService = filiereService;
        this.pvService=pvService;
    }

  /*  public void importToDb(List<MultipartFile> multipartfiles) {
        List<Pv> pvs=new ArrayList<>();
        if (!multipartfiles.isEmpty()) {
            multipartfiles.forEach(multipartfile -> {
                try {
                    XSSFWorkbook workBook = new XSSFWorkbook(multipartfile.getInputStream());

                    XSSFSheet sheet = workBook.getSheetAt(0);
                    //sheet.removeMergedRegion(0);
                    // looping through each row
                    for (int rowIndex = 0; rowIndex < getNumberOfNonEmptyCells(sheet, 0) ; rowIndex++) {
                        // current row
                        XSSFRow row = sheet.getRow(rowIndex);
                        // skip the first row because it is a header row
                        if (rowIndex == 0) {
                            continue;
                        }
                        Date date = row.getCell(0).getDateCellValue();
                        String filiere=row.getCell(3).getStringCellValue();
                        String semestre = row.getCell(2).getStringCellValue();
                        String module = row.getCell(1).getStringCellValue();
                        String responsable = row.getCell(4).getStringCellValue();
                        String heure = row.getCell(5).getStringCellValue();
                        Pv pv=new Pv(date,filiere,semestre,module,responsable,heure);
                        pvs.add(pv);


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


        }
        pvService.saveAll(pvs);

    }*/


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
