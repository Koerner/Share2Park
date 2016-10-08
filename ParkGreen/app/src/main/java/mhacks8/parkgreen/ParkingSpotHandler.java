package mhacks8.parkgreen;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by carsonschmidt on 10/8/16.
 */

public class ParkingSpotHandler extends SQLiteOpenHelper {

    //public ParkingSpotHandler() {super();}

    public ParkingSpotHandler(Context context) {
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {

    }

}