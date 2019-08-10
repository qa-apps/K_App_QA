package models;

import enums.Status;

public class Pet {
    private long id;
    private String name;
    private String[] photoUrls;
    private Status status;
    private Category category;
    private Tag[] tags;

    public Pet(String name, String[] photoUrls) {
        this.name = name;
        this.photoUrls = photoUrls;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public Status getStatus() {
        return status;
    }

    public Category getCategory() {
        return category;
    }

    public Tag[] getTags() {
        return tags;
    }
}


