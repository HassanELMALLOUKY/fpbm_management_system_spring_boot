package com.fpbmv1.demo.entites;

import com.fpbmv1.demo.models.ExcelPv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data@NoArgsConstructor
@AllArgsConstructor
public class ExtractExams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String key;
    @OneToMany
    private List<ExcelPv> excelPvList;
}
