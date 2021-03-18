package com.prologger.dto

import java.util.*

data class Photo(
    var localURI: String = " ",
    var remoteURI: String = " ",
    var description: String = " ",
    var dateTaken: Date = Date(),
    var latitude: String = " ",
    var longitude: String = " ",
    var id: String = " "
)