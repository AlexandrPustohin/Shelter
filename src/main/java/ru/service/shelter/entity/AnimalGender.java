package ru.service.shelter.entity;

public enum AnimalGender {
    FEMALE ("женский"),
    MALE ("мужской");

    private  String title;

    AnimalGender(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}
