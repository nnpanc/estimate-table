package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
public class TimeModel {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

    private String checkIn;
    private String checkOut;

    public Date getDate(String date) {
        try {
            return simpleDateFormat.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

}
