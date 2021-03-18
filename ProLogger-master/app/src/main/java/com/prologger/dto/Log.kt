package com.prologger.dto

import java.util.*

data class Log(
    var logID: String = "First Log",
    var logName: String = "Log Name",
    var streetName: String = "Street Name",
    var cityName: String = "City Name",
    var cityCountyName: String = "County Name",
    var stateName: String = "State Name",
    var countryName: String = "Country Name",
    var dateStarted: String = "02/13/2020",
    var dateCompleted: String = "14/16/2020",
    var personalNotes: String = "Personal Note",
    var events: ArrayList<EventLog> = ArrayList<EventLog>()
) {
    override fun toString(): String {
        return "$logID $logName $streetName $cityName $cityCountyName $stateName" +
            "$countryName $dateStarted $dateCompleted $personalNotes "
    }
}