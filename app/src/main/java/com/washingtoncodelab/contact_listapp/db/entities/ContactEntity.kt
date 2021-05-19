package com.washingtoncodelab.contact_listapp.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class ContactEntity(
    @PrimaryKey(autoGenerate = true)
    var id :Int,
    var name :String,
    var number : String
)
