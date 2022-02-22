package com.tres.compositekey;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CompositeKeyRoute {

    @Column(name = "train_id")
    private int trainId;
    @Column(name = "station_code")
    private String stationCode;

}
