package org.example;

public class Meeting extends Task {
    protected String topic; //тема обсуждения
    protected String project;//нызвание пректа
    protected String start;// дата и время

    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTopic() {

        return topic;
    }

    public String getProject() {

        return project;
    }

    public String getStart() {

        return start;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        } else if (project.contains(query)) {
            return true;
        } else {
            return false;
        }
    }
}
