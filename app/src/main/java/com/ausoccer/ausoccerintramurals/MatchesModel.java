package com.ausoccer.ausoccerintramurals;

/**
 * Created by Kevin Daniel on 9/3/2018.
 */

public class MatchesModel {

    String homeTeamLogoUrl, awayTeamLogoUrl;
    String homeTeamName, awayTeamName;
    String matchDate, matchTime;
    String uid;
    int matchNumber;
    String liveResult, matchStatus, finalResult;


    public MatchesModel() {

    }

    public MatchesModel(String homeTeamLogoUrl, String awayTeamLogoUrl, String homeTeamName, String awayTeamName, String matchDate,
                        String matchTime, String uid, int matchNumber, String liveResult, String matchStatus, String finalResult) {
        this.homeTeamLogoUrl = homeTeamLogoUrl;
        this.awayTeamLogoUrl = awayTeamLogoUrl;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.uid = uid;
        this.matchNumber = matchNumber;
        this.liveResult = liveResult;
        this.matchStatus = matchStatus;
        this.finalResult = finalResult;

    }

    public String getHomeTeamLogoUrl() {
        return homeTeamLogoUrl;
    }

    public void setHomeTeamLogoUrl(String homeTeamLogoUrl) {
        this.homeTeamLogoUrl = homeTeamLogoUrl;
    }

    public String getAwayTeamLogoUrl() {
        return awayTeamLogoUrl;
    }

    public void setAwayTeamLogoUrl(String awayTeamLogoUrl) {
        this.awayTeamLogoUrl = awayTeamLogoUrl;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public String getLiveResult() {
        return liveResult;
    }

    public void setLiveResult(String liveResult) {
        this.liveResult = liveResult;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public String getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }
}
