package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String? = null, // Optional field with a default value of null
    val address: String? = null // Optional field with a default value of null
)

