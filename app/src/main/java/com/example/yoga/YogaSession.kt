package com.example.yoga

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.*

@Entity
data class YogaSession(
    var burnedCalories: Double,
    var duration: Double,
    var yogaCompletionDateTime: LocalDateTime?
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
