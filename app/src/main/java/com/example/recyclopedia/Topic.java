package com.example.recyclopedia;

/**
 * Created by Mariz on 2/21/2017.
 */
public class Topic {
    private int topic_id;
    private String topic_title;
    private String topic_details;
    private String topic_subject;

    public Topic() {}

    public Topic (int id, String title, String details, String subject) {
        topic_id = id;
        topic_title = title;
        topic_details = details;
        topic_subject = subject;

    }
    public void setTopicID(int id) {
        topic_id = id;
    }
    public void setTopicTitle(String title) {
        topic_title = title;
    }

    public void setTopicDetails(String details) {
        topic_details = details;
    }

    public void setTopicSubject (String subject) {
        topic_subject = subject;
    }

    public int getTopicID() {
        return topic_id;
    }

    public String getTopicTitle() {
        return topic_title;
    }

    public String getTopicDetails() {
        return topic_details;
    }

    public String getTopicSubject() {
        return topic_subject;
    }


}
