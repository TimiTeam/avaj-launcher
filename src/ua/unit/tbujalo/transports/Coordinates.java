package ua.unit.tbujalo.transports;

import ua.unit.tbujalo.fileWorker.readException.SyntaxErrorException;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) throws SyntaxErrorException {
        if (longitude < 0)
            throw new SyntaxErrorException("Longitude can be only positive integer");
        this.longitude = longitude;
        if (latitude < 0)
            throw new SyntaxErrorException("Latitude can be only positive integer");
        this.latitude = latitude;
        if (height < 0)
            throw new SyntaxErrorException("To low height "+height);
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
