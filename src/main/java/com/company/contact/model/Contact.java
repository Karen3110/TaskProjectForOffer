package com.company.contact.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @ToString.Exclude
//    @OneToMany
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Phone> phones;
}
