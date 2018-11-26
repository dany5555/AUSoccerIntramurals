package com.ausoccer.ausoccerintramurals;

/**
 * Created by Kevin Daniel on 9/3/2018.
 */

public class MatchesModel {

    String homeTeamLogoUrl, awayTeamLogoUrl;
    String homeTeamName, awayTeamName;
    String homeTeamUid, awayTeamUid;
    String matchDate, matchTime;
    String matchUid;
    int matchNumber;
    String liveResult, matchStatus;


    public MatchesModel() {

    }

    public MatchesModel(String homeTeamLogoUrl, String awayTeamLogoUrl, String homeTeamName, String awayTeamName, String homeTeamUid, String awayTeamUid, String matchDate, String matchTime, String matchUid, int matchNumber, String liveResult, String matchStatus) {
        this.homeTeamLogoUrl = homeTeamLogoUrl;
        this.awayTeamLogoUrl = awayTeamLogoUrl;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.homeTeamUid = homeTeamUid;
        this.awayTeamUid = awayTeamUid;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.matchUid = matchUid;
        this.matchNumber = matchNumber;
        this.liveResult = liveResult;
        this.matchStatus = matchStatus;
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

    public String getHomeTeamUid() {
        return homeTeamUid;
    }

    public void setHomeTeamUid(String homeTeamUid) {
        this.homeTeamUid = homeTeamUid;
    }

    public String getAwayTeamUid() {
        return awayTeamUid;
    }

    public void setAwayTeamUid(String awayTeamUid) {
        this.awayTeamUid = awayTeamUid;
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

    public String getMatchUid() {
        return matchUid;
    }

    public void setMatchUid(String matchUid) {
        this.matchUid = matchUid;
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
}
