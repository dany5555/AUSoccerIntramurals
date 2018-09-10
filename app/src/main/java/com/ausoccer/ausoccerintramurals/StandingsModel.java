package com.ausoccer.ausoccerintramurals;

/**
 * Created by Kevin Daniel on 9/5/2018.
 */

public class StandingsModel {

    String teamLogoUrl, teamName, gamesPlayed, goalDifference, points;

    public StandingsModel() {

    }

    public StandingsModel(String teamLogoUrl, String teamName, String gamesPlayed, String goalDifference, String points) {
        this.teamLogoUrl = teamLogoUrl;
        this.teamName = teamName;
        this.gamesPlayed = gamesPlayed;
        this.goalDifference = goalDifference;
        this.points = points;
    }

    public String getTeamLogoUrl() {
        return teamLogoUrl;
    }

    public void setTeamLogoUrl(String teamLogoUrl) {
        this.teamLogoUrl = teamLogoUrl;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(String gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(String goalDifference) {
        this.goalDifference = goalDifference;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
