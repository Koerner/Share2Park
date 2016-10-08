package mhacks8.parkgreen;

import android.location.Location;

import java.security.Timestamp;

/**
 * Created by carsonschmidt on 10/8/16.
 */

public class ParkingSpot {

    private int _spot_num;
    private Location _spot_loc;
    private String _plate_num;
    private Timestamp _time_start;
    private Timestamp _time_end;

    public ParkingSpot() {}

    public ParkingSpot(int spot_num, Location spot_loc, String plate_num, Timestamp time_start, Timestamp time_end) {
        this._spot_num = spot_num;
        this._spot_loc = spot_loc;
        this._plate_num = plate_num;
        this._time_start = time_start;
        this._time_end = time_end;
    }

    /*public Table(int id, String tablename, int quantity) {
        this._id = id;
        this._tablename = tablename;
        this._quantity = quantity;
    }*/

    /*public ParkingSpot(String tablename, int quantity) {
        this._tablename = tablename;
        this._quantity = quantity;
    }*/

    public void set_spot_num(int spot_num) {
        this._spot_num = spot_num;
    }

    public int get_spot_num() {
        return this._spot_num;
    }

    /*public void set_spot_loc_lat(Location spot_loc) {
        this._spot_loc = spot_loc;
    }*/

    public double get_spot_loc_lat() {
        return this._spot_loc.getLatitude();
    }

    public double get_spot_loc_long() {
        return this._spot_loc.getLongitude();
    }

    public void set_plate_num(String plate_num) {
        this._plate_num = plate_num;
    }

    public String get_plate_num() {
        return this._plate_num;
    }

    public void set_time_start(Timestamp time_start) {
        this._time_start = time_start;
    }

    public Timestamp get_time_start() {
        return this._time_start;
    }

    public void set_time_end(Timestamp time_end) {
        this._time_end = time_end;
    }

    public Timestamp get_time_end() {
        return this._time_end;
    }
}
