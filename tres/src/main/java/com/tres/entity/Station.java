package com.tres.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "station")
public class Station {

	@Id
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;

}
