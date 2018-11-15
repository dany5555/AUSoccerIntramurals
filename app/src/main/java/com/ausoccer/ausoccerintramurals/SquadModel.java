package com.ausoccer.ausoccerintramurals;

public class SquadModel {

    private String firstName, lastName, country, position, weight, height, team, pictureUrl, playerUid;
    private int age, number;

    public SquadModel() {

    }

    public SquadModel(String firstName, String lastName, String country, String position, String weight, String height, String team, String pictureUrl, String playerUid, int age, int number) {
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
}
