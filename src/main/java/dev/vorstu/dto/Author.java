package dev.vorstu.dto;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Author {

    public Author(){};

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;




}
