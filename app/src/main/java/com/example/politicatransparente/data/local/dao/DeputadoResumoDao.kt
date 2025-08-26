package com.example.politicatransparente.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.politicatransparente.data.local.entities.DeputadoResumoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DeputadoResumoDao {

    @Query("Select * from deputado_resumo")
    fun getAllDeputados(): Flow<List<DeputadoResumoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(resumos: List<DeputadoResumoEntity>)


}