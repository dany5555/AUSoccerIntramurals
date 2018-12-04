package com.ausoccer.ausoccerintramurals;

public class SquadModel {

    private String firstName, lastName, country, position, weight, height, team, pictureUrl, playerUid;
    private int age, number, matchesPlayed, goalsScored, assists, shotsOnTarget, shotsOffTarget, fouls, redCards, yellowCards;

    public SquadModel() {

    }

    public SquadModel(String firstName, String lastName, String country, String position, String weight,
                      String height, String team, String pictureUrl, String playerUid, int age, int number,
                      int matchesPlayed, int goalsScored, int assists, int shotsOnTarget, int shotsOffTarget,
                      int fouls, int redCards, int yellowCards) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.position = position;
        this.weight = weight;
        this.height = height;
        this.team = team;
        this.pictureUrl = pictureUrl;
        this.playerUid =playerUid;
        this.age = age;
        this.number = number;
        this.matchesPlayed = matchesPlayed;
        this.goalsScored = goalsScored;
        this.assists = assists;
        this.shotsOnTarget = shotsOnTarget;
        this.shotsOffTarget = shotsOffTarget;
        this.fouls = fouls;
        this.redCards = redCards;
        this.yellowCards = yellowCards;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPlayerUid() {
        return playerUid;
    }

    public void setPlayerUid(String playerUid) {
        this.playerUid = playerUid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getShotsOnTarget() {
        return shotsOnTarget;
    }

    public void setShotsOnTarget(int shotsOnTarget) {
        this.shotsOnTarget = shotsOnTarget;
    }

    public int getShotsOffTarget() {
        return shotsOffTarget;
    }

    public void setShotsOffTarget(int shotsOffTarget) {
        this.shotsOffTarget = shotsOffTarget;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }
}
