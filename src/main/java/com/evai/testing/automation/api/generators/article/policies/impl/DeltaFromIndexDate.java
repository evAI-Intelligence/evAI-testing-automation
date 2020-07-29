package com.evai.testing.automation.api.generators.article.policies.impl;

import com.evai.testing.automation.api.generators.article.policies.ArticleGeneratorTimestampPolicy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DeltaFromIndexDate implements ArticleGeneratorTimestampPolicy {
    private final static LocalDate start =  LocalDate.of(2020, Month.JANUARY, 01);
    private final static DateTimeFormatter format =  DateTimeFormatter.ISO_DATE;

    @Override
    public Date generatePublishDate(int index) {
        var format = new SimpleDateFormat(DateTimeFormatter.ISO_DATE.toString());
        try {
            return format.parse(start.plusMonths(1).plusDays(index).format(this.format));
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }

    @Override
    public Date generateCreatedDate(int index) {
        var format = new SimpleDateFormat(DateTimeFormatter.ISO_DATE.toString());
        try {
            return format.parse(start.plusDays(index).format(this.format));
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
}
