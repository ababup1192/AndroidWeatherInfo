package org.ababup1192.weathercheckaizu;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherInfo {
    public String base;
    public Clouds clouds;
    public Coord coord;
    public Long dt;
    public Long id;
    public WeatherInfoMain main;
    public String name;
    public Rain rain;
    public WeatherInfoSystemInfo sys;
    public List<WeatherInformation> weather;
    public WindInfo wind;

    public class Clouds {
        public String all;
    }

    private class Coord {
        public double lat;
        public double lon;
    }

    public class WeatherInfoMain {
        public int Humidity;
        public int pressure;
        public float temp;
        @SerializedName("temp_max")
        public float tempMax;
        @SerializedName("temp_min")
        public float tempMin;
    }

    private class Rain {
        @SerializedName("1h")
        public String time;
    }

    private class WeatherInfoSystemInfo {
        public String country;
        public float message;
        public long sunrise;
        public long sunset;
    }


    private class WeatherInformation {
        public String description;
        public String icon;
        public int id;
        public String main;
    }

    public class WindInfo {
        public int def;
        public float gust;
        public float speed;
    }

}
