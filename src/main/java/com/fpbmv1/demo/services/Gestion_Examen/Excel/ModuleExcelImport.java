package com.fpbmv1.demo.services.Gestion_Examen.Excel;

import com.fpbmv1.demo.entites.Module;

import com.fpbmv1.demo.services.Gestion_Examen.ModuleService;
import com.fpbmv1.demo.services.SemestreService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleExcelImport {
    private ModuleService moduleService;
    private SemestreService semestreService;

    public ModuleExcelImport(ModuleService moduleService, SemestreService semestreService) {
        this.moduleService = moduleService;
        this.semestreService = semestreService;
    }

    public void importToDb(List<MultipartFile> multipartfiles) {
        if (!multipartfiles.isEmpty()) {
            //List<Module> modules = new ArrayList<>();
            List<Module> modules=new ArrayList<>();
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
                        String semestre=row.getCell(5).getStringCellValue();


                        Module module = new Module();
                        module.setName(nom);

                        module.setSemestre(semestreService.getByName(semestre));

                        modules.add(module);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            if (!modules.isEmpty()) {
                // save to database
                moduleService.saveAll(modules);
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
