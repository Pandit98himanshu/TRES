package com.tres.entity;

import com.tres.compositekey.CompositeKeySchedule;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule {

	@EmbeddedId
	private CompositeKeySchedule id;

}
