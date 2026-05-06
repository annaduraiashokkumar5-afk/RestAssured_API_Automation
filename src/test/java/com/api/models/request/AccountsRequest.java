package com.api.models.request;

public class AccountsRequest {
    private String accountType;
    private String branch;

    public AccountsRequest(String accountType, String branch) {
        this.accountType = accountType;
        this.branch = branch;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "AccountsRequest{" +
                "accountType='" + accountType + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
