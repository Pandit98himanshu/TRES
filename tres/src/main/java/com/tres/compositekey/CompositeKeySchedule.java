package com.tres.compositekey;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CompositeKeySchedule implements Serializable {

    @Column(name = "train_id")
    private int trainId;
    @Column(name = "station_code")
    private String stationCode;
    @Column(name = "week_day")
    private String weekDay;

}
