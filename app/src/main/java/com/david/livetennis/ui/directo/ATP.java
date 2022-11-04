package com.david.livetennis.ui.directo;

public class ATP {

    private String surface;
    private String jugadorLocal;
    private String jugadorVisitante;
    private String tournament;
    private String ronda;
    private String nombreJugador;
    private String edadJugador;

    //juegos de set para cada jugador
    private String set1P1;
    private String set1P2;
    private String set2P1;
    private String set2P2;
    private String set3P1;
    private String set3P2;
    private String set4P1;
    private String set4P2;
    private String set5P1;
    private String set5P2;

    //Set totales conseguidos para cada jugador
    private int totalSetsP1;
    private int totalSetsP2;

    //marcador dentro del juego
    private String actualScoreP1;
    private String actualScoreP2;

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getRonda() {
        return ronda;
    }

    public void setRonda(String ronda) {
        this.ronda = ronda;
    }

    public String getJugadorLocal() {
        return jugadorLocal;
    }

    public void setJugadorLocal(String jugadorLocal) {
        this.jugadorLocal = jugadorLocal;
    }

    public String getJugadorVisitante() {
        return jugadorVisitante;
    }

    public void setJugadorVisitante(String jugadorVisitante) {
        this.jugadorVisitante = jugadorVisitante;
    }


    //-------------------------- Rankings -------------------------------------


    public String getNombreJugador(){ return nombreJugador; }
    public void setNombreJugador(String nombreJugador) {this.nombreJugador = nombreJugador;}

    public String getEdadJugador(){ return edadJugador; }
    public void setEdadJugador(String edadJugador) {this.edadJugador = edadJugador;}








    //--------------------------- Partidos Directo -----------------------------

    //juegos por set para cada jugador

    public String getSet1P1() {
        return set1P1;
    }
    public void setSet1P1(String set1P1) {
        this.set1P1 = set1P1;
    }
    public String getSet1P2() {return set1P2;}
    public void setSet1P2(String set1P2) {
        this.set1P2 = set1P2;
    }
    public String getSet2P1() {return set2P1;}
    public void setSet2P1(String set2P1) {
        this.set2P1 = set2P1;
    }
    public String getSet2P2() {
        return set2P2;
    }
    public void setSet2P2(String set2P2) {
        this.set2P2 = set2P2;
    }
    public String getSet3P1() {return set3P1;}
    public void setSet3P1(String set3P1) {
        this.set3P1 = set3P1;
    }
    public String getSet3P2() {
        return set3P2;
    }
    public void setSet3P2(String set3P2) {
        this.set3P2 = set3P2;
    }
    public String getSet4P1() {return set4P1;}
    public void setSet4P1(String set4P1) {
        this.set4P1 = set4P1;
    }
    public String getSet4P2() {
        return set4P2;
    }
    public void setSet4P2(String set4P2) {
        this.set4P2 = set4P2;
    }
    public String getSet5P1() {return set5P1;}
    public void setSet5P1(String set5P1) {this.set5P1 = set5P1;}
    public String getSet5P2() {
        return set5P2;
    }
    public void setSet5P2(String set5P2) {
        this.set5P2 = set5P2;
    }


    //Set totales conseguidos para cada jugador

    public int getTotalSetsP1() {
        return totalSetsP1;
    }
    public void setTotalSetsP1(int totalSetsP1) {
        this.totalSetsP1 = totalSetsP1;
    }
    public int getTotalSetsP2() {
        return totalSetsP2;
    }
    public void setTotalSetsP2(int totalSetsP2) {
        this.totalSetsP2 = totalSetsP2;
    }


    //marcador dentro del juego

    public String getActualScoreP1() {
        return actualScoreP1;
    }
    public void setActualScoreP1(String actualScoreP1) {this.actualScoreP1 = actualScoreP1;}
    public String getActualScoreP2() {
        return actualScoreP2;
    }
    public void setActualScoreP2(String actualScoreP2) {this.actualScoreP2 = actualScoreP2;}



    @Override
    public String toString() {
        return
                    jugadorLocal + '\'' +
                    jugadorVisitante + '\'' +
                    set1P1 + '\'' +
                    set1P2 + '\'' +
                    set2P1 + '\'' +
                    set2P2 + '\'' +
                    set3P1 + '\'' +
                    set3P2 + '\''

                ;

        /*

         return "EVENTO DIRECTO{" +
                    "Jugador Local = '" + jugadorLocal + '\'' +
                    "Jugador Visitante = '" + jugadorVisitante + '\'' +
                    "Set1 P1 = '" + set1P1 + '\'' +
                    "Set1 P2 = '" + set1P2 + '\'' +
                    "Set2 P1 = '" + set2P1 + '\'' +
                    "Set2 P2 = '" + set2P2 + '\'' +
                    "Score '" + jugadorLocal + " = " + actualScoreP1 + '\'' +
                    "Score '" + jugadorVisitante + " = " + actualScoreP2 + '\'' +
                    "Torneo = '" + tournament + '\'' +
                    "Ronda = '" + ronda + '\'' +
                    "Superficie = '" + surface + '\'' +
                '}';


        */


                /*"RANKINGS TOP 10{" +
                    "Nombre = '" + nombreJugador + '\'' +
                    "Edad = '" + edadJugador + '\'' +
                '}';*/

    }
}
