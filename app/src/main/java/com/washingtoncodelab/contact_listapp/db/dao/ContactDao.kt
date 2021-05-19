package com.washingtoncodelab.contact_listapp.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.washingtoncodelab.contact_listapp.db.entities.ContactEntity

interface ContactDao{
    @Query("SELECT * FROM contact")
    fun selectAllContacts():List<ContactEntity>

    @Insert
    fun insertContacts(contactEntity: ContactEntity)

    @Delete
    fun deleteContact(contactEntity: ContactEntity)

    @Update
    fun updateContact(contactEntity: ContactEntity)
}
