package com.example.sample;

public class Menus {

    String Lunch;
    String Dinner;
    String Breakfast;

    public Menus(String lunch, String dinner, String breakfast) {
        Lunch = lunch;
        Dinner = dinner;
        Breakfast = breakfast;
    }


    public String getLunch() {
        return Lunch;
    }

    public void setLunch(String lunch) {
        Lunch = lunch;
    }

    public String getDinner() {
        return Dinner;
    }

    public void setDinner(String dinner) {
        Dinner = dinner;
    }

    public String getBreakfast() {
        return Breakfast;
    }

    public void setBreakfast(String breakfast) {
        Breakfast = breakfast;
    }
}

