package com.tres.entity.result;

import lombok.*;

import java.sql.Time;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Result {

    int trainId;
    String trainName;
    String src;
    Time depFromSrc;
    String dest;
    Time arrAtDest;
    int daysRequired;

}
