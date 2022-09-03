package Org;

import java.io.Serializable;

public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    private long x;
    private long y;
    private int z;


    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

    public void setX(long x) {
        this.x = x;
    }

    public void setY(long y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
}

