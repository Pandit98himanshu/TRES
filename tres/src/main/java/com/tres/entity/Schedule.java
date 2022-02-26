package com.tres.entity;

import com.tres.compositekey.CompositeKeySchedule;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "schedule")
public class Schedule {

	/*
	@EmbeddedId
	private CompositeKeySchedule id;
	*/
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "train_id")
	private int trainId;
	@Column(name = "station_code")
	private String stationCode;
	@Column(name = "week_day")
	private String weekDay;

}
