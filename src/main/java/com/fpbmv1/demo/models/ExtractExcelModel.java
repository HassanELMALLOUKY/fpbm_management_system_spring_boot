package com.fpbmv1.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtractExcelModel {
    private String key;
    private List<ExcelPv> value;
}
