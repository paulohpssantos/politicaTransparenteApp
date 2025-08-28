package com.example.politicatransparente.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.politicatransparente.data.local.dao.DadosDeputadoDao
import com.example.politicatransparente.data.local.dao.ResumoDeputadoDao
import com.example.politicatransparente.data.local.entities.DadosDeputadoEntity
import com.example.politicatransparente.data.local.entities.ResumoDeputadoEntity

@Database(
    entities = [ResumoDeputadoEntity::class, DadosDeputadoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun resumoDeputadoDao(): ResumoDeputadoDao
    abstract fun dadosDeputadoDao(): DadosDeputadoDao
}