package dev.vorstu.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Entity
@Table(name="Genres")
@Getter
@Setter
public class Genre {
    public Genre(){};
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long genre_id;

    private String genre_name;
    public Long get_genre_Id(){return genre_id;}
    public void set_genre_Id(Long genre_id){this.genre_id = genre_id;}
    public String get_genre_name(){
        return genre_name;
    }
    public void set_genre_name(String genre_name) {
        this.genre_name = genre_name;
    }
}
