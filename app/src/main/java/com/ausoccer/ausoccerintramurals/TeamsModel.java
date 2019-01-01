package com.ausoccer.ausoccerintramurals;

public class TeamsModel {

    // Team general information.
    String teamUid, teamLogoUrl, teamName;

    // Team stats.
    int matchesWon, matchesDrawn, matchesLost;
    int goalsFor, goalsForAverage, goalsAgainst, goalsAgainstAverage, goalDifference, ownGoals;
    int yellowCards, redCards, foulsCommited;

    public TeamsModel() {

    }

    public TeamsModel(String teamUid, String teamLogoUrl, String teamName, int matchesWon, int matchesDrawn, int matchesLost, int goalsFor, int goalsForAverage, int goalsAgainst, int goalsAgainstAverage, int goalDifference, int ownGoals, int yellowCards, int redCards, int foulsCommited) {
        this.teamUid = teamUid;
        this.teamLogoUrl = teamLogoUrl;
        this.teamName = teamName;
        this.matchesWon = matchesWon;
        this.matchesDrawn = matchesDrawn;
        this.matchesLost = matchesLost;
        this.goalsFor = goalsFor;
        this.goalsForAverage = goalsForAverage;
        this.goalsAgainst = goalsAgainst;
        this.goalsAgainstAverage = goalsAgainstAverage;
        this.goalDifference = goalDifference;
        this.ownGoals = ownGoals;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.foulsCommited = foulsCommited;
    }

    public String getTeamUid() {
        return teamUid;
    }

    public void setTeamUid(String teamUid) {
        this.teamUid = teamUid;
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

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getMatchesDrawn() {
        return matchesDrawn;
    }

    public void setMatchesDrawn(int matchesDrawn) {
        this.matchesDrawn = matchesDrawn;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsForAverage() {
        return goalsForAverage;
    }

    public void setGoalsForAverage(int goalsForAverage) {
        this.goalsForAverage = goalsForAverage;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getGoalsAgainstAverage() {
        return goalsAgainstAverage;
    }

    public void setGoalsAgainstAverage(int goalsAgainstAverage) {
        this.goalsAgainstAverage = goalsAgainstAverage;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public int getOwnGoals() {
        return ownGoals;
    }

    public void setOwnGoals(int ownGoals) {
        this.ownGoals = ownGoals;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getFoulsCommited() {
        return foulsCommited;
    }

    public void setFoulsCommited(int foulsCommited) {
        this.foulsCommited = foulsCommited;
    }
}
