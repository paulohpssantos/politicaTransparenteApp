package com.example.politicatransparente.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.politicatransparente.data.local.entities.ResumoDeputadoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ResumoDeputadoDao {

    @Query("Select * from resumo_deputado order by nome")
    fun getAllDeputados(): Flow<List<ResumoDeputadoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(resumos: List<ResumoDeputadoEntity>)


}