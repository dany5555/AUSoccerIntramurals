package com.ausoccer.ausoccerintramurals;

/**
 * Created by Kevin Daniel on 9/3/2018.
 */

public class MatchesModel {

    String homeTeamLogoUrl, awayTeamLogoUrl;
    String homeTeamName, awayTeamName;
    String matchDateAndResult, matchTimeAndStatus;
    String uid;
    String orderMethod;
    String groupName;


    public MatchesModel() {

    }

    public MatchesModel(String homeTeamLogoUrl, String awayTeamLogoUrl, String homeTeamName, String awayTeamName, String matchDateAndResult,
                        String matchTimeAndStatus, String uid, String orderMethod, String groupName) {
        this.homeTeamLogoUrl = homeTeamLogoUrl;
        this.awayTeamLogoUrl = awayTeamLogoUrl;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.matchDateAndResult = matchDateAndResult;
        this.matchTimeAndStatus = matchTimeAndStatus;
        this.uid = uid;
        this.orderMethod = orderMethod;
        this.groupName = groupName;

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

    public String getMatchDateAndResult() {
        return matchDateAndResult;
    }

    public void setMatchDateAndResult(String matchDateAndResult) {
        this.matchDateAndResult = matchDateAndResult;
    }

    public String getMatchTimeAndStatus() {
        return matchTimeAndStatus;
    }

    public void setMatchTimeAndStatus(String matchTimeAndStatus) {
        this.matchTimeAndStatus = matchTimeAndStatus;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOrderMethod() {
        return orderMethod;
    }

    public void setOrderMethod(String orderMethod) {
        this.orderMethod = getMatchDateAndResult() + " " + getMatchTimeAndStatus();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
