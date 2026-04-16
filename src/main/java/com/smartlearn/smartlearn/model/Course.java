package com.smartlearn.smartlearn.model;

public class Course {

    private String title;
    private String url;
    private String level;
    private String subject;

    public Course(String title, String url, String level, String subject) {
        this.title = title;
        this.url = url;
        this.level = level;
        this.subject=subject;
    }

    public String getTitle() { return title; }
    public String getUrl() { return url; }
    public String getLevel() { return level; }

	public String getSubject() {
		return subject;
	}
}