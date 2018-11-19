package com.rock.reward.ResponsePojo;

import com.rock.reward.model.ProjectDonation;

import java.util.List;

/**
 * Created by rockers on 8/3/17.
 */
public class DonationData {
    public String project_id;
    public String project_title;
    public String transaction_date_time;
    public String amount;
    public String pay_fee;
    public String project_status;
    public List<ProjectDonation> project_donation;

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProject_title() {
        return project_title;
    }

    public void setProject_title(String project_title) {
        this.project_title = project_title;
    }

    public String getTransaction_date_time() {
        return transaction_date_time;
    }

    public void setTransaction_date_time(String transaction_date_time) {
        this.transaction_date_time = transaction_date_time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPay_fee() {
        return pay_fee;
    }

    public void setPay_fee(String pay_fee) {
        this.pay_fee = pay_fee;
    }

    public String getProject_status() {
        return project_status;
    }

    public void setProject_status(String project_status) {
        this.project_status = project_status;
    }

    public List<ProjectDonation> getProject_donation() {
        return project_donation;
    }

    public void setProject_donation(List<ProjectDonation> project_donation) {
        this.project_donation = project_donation;
    }
}
