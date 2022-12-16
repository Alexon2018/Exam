package com.example.exam.dataclasses

import java.util.*

data class MyItem(
    var question    : String,
    var response1   : Response,
    var response2   : Response,
    var response3   : Response,
    var category    : String,
    var currentDate : String
)