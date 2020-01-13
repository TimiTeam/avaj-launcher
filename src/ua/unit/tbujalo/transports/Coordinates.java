package ua.unit.tbujalo.transports;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude < 0 ? 0 : longitude;
        this.latitude = latitude < 0 ? 0 : latitude;
        this.height = height > 100 ? 100 : height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
