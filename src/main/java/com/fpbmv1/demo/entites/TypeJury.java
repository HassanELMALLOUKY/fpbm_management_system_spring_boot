package com.fpbmv1.demo.entites;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class TypeJury {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
    @OneToMany(mappedBy = "typeJury")
    private Collection<Jury> juries;

    public TypeJury(String role, Collection<Jury> juries) {
        this.role = role;
        this.juries = juries;
    }
}
