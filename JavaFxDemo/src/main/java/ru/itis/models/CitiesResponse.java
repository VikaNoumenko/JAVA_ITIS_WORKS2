package ru.itis.models;

import java.util.List;

public class CitiesResponse {
    private List<City> response;

    public CitiesResponse() {
    }

    public List<City> getResponse() {
        return response;
    }

    public void setResponse(List<City> response) {
        this.response = response;
    }
}
