package com.washingtoncodelab.contact_listapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.washingtoncodelab.contact_listapp.db.dao.ContactDao
import com.washingtoncodelab.contact_listapp.db.entities.ContactEntity
import java.security.AccessControlContext
import java.util.concurrent.locks.Lock

@Database(
    entities = [ContactEntity::class],
    version = 1
)
abstract class ContactDatabase : RoomDatabase(){
    abstract fun contactDao():ContactDao

    companion object{
        @Volatile private var instance:ContactDatabase? =null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context)
        }
        private fun buildDatabase(context: Context) =  Room.databaseBuilder(context,ContactDatabase::class.java,"contact.db").build()
    }
}