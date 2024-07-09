package com.company.model;

public class Match {
    private User firstUser;
    private User secondUser;
    private int matchId;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUSsr) {
        this.firstUser = firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }
}
