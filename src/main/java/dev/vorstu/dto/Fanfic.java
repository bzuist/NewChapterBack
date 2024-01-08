package dev.vorstu.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Fanfics")
@Getter
@Setter
public class Fanfic {

    public Fanfic(){};
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String authorName;

    private String genre;

    private String description;

    private String text;
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {return description;};
    public void setDescription(String description) {
        this.description = description;
    }

    public  String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column (name="image")
    @CollectionTable(name="fanfic_images")
    @ElementCollection
    private List<String> images;
}

