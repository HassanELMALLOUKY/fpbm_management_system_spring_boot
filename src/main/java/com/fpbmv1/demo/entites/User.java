package com.fpbmv1.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String username;
    private String password;
    @ManyToMany()
    private Collection<Role> roles=new ArrayList<>();
}
