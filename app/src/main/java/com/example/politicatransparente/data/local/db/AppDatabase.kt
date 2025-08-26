package com.example.politicatransparente.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.politicatransparente.data.local.dao.DeputadoResumoDao
import com.example.politicatransparente.data.local.entities.DeputadoResumoEntity

@Database(
    entities = [DeputadoResumoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun deputadoResumoDao(): DeputadoResumoDao
}