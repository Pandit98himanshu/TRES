package com.tres.entity;

import com.tres.compositekey.CompositeKeyRoute;
import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "route")
public class Route {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "train_id")
    private int trainId;
    @Column(name = "station_code")
    private String stationCode;
/*
    @EmbeddedId
    private CompositeKeyRoute id;
*/
    @Column(name = "halt_no")
    private int haltNo;
    @Column(name = "day")
    private int day;
    @Column(name = "arr")
    private Time arr;
    @Column(name = "dep")
    private Time dep;

}
