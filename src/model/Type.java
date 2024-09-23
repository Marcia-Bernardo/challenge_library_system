package model;

public enum Type {
    ADMIN("Administrative"),
    COUNT("Counter"),
    CLEANING("CleaningWorker");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

