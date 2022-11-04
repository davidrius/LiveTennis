package com.david.livetennis.ui.ranks;

public class RankingATP {

    private String name;
    private String age;
    private int rank;
    private String livePoints;
    private String pointsDifference;
    private String id;

    private String birthDate;
    private String birthPlace;
    private String coach;
    private String flagCode;
    private String image;
    private String playStyle;
    private String prizeMoneyCarrer;
    private String prizeMoney2022;
    private String titlesCarrer;
    private String titles2022;
    private String height;
    private String weight;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public int getRank() {return rank;}
    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getLivePoints() {
        return livePoints;
    }
    public void setLivePoints(String livePoints) {
        this.livePoints = livePoints;
    }

    public String getPointsDifference() {
        return pointsDifference;
    }
    public void setPointsDifference(String pointsDifference) {this.pointsDifference = pointsDifference;}

    public String getId() {
        return id;
    }
    public void setId(String id) {this.id = id;}

    public String getBirthPlace() {
        return birthPlace;
    }
    public void setBirthPlace(String birthPlace) {this.birthPlace = birthPlace;}

    public String getCoach() {
        return coach;
    }
    public void setCoach(String coach) {this.coach = coach;}



    public String toString() {
        return
                        name + '\'' +
                        age + '\'' +
                        rank + '\'' +
                        livePoints + '\'' +
                        pointsDifference + '\'' +
                        birthPlace + '\'' +
                        coach + '\''
                ;
    }



}
