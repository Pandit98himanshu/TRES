package com.tres.entity;

import com.tres.compositekey.CompositeKeyRoute;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "route")
public class Route {

    @EmbeddedId
    private CompositeKeyRoute id;
    @Column(name = "halt_no")
    private int haltNo;
    @Column(name = "day")
    private int day;
    @Column(name = "arr")
    private Time arr;
    @Column(name = "dep")
    private Time dep;

}
