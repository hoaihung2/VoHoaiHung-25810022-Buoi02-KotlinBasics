package edu.hcmute.busschedule

import android.app.Application
import edu.hcmute.busschedule.data.AppDatabase

class BusScheduleApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}