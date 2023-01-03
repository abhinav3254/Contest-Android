package com.example.kontests;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Pojo {
    public String name;
    public String url;
    public String start_time;
    public String end_time;
    public String duration;
    public String site;
    public String in_24_hours;
    public String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getIn_24_hours() {
        return in_24_hours;
    }

    public void setIn_24_hours(String in_24_hours) {
        this.in_24_hours = in_24_hours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
