package com.david.livetennis.ui.calendar;

public class TorneosATP {

    private String name;
    private String location;
    private String date;
    private String prizeMoney;

    public String getNameTournament() {
        return name;
    }
    public void setNameTournament(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getPrizeMoney() {
        return prizeMoney;
    }
    public void setPrizeMoney(String prizeMoney) {
        this.prizeMoney = prizeMoney;
    }


    public String toString() {
        return
                        name + '\'' +
                        location + '\'' +
                        date + '\'' +
                        prizeMoney + '\''
                ;
    }

}
