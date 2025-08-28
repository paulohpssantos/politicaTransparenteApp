package com.example.politicatransparente.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.politicatransparente.data.local.entities.DadosDeputadoEntity
import com.example.politicatransparente.data.local.entities.ResumoDeputadoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DadosDeputadoDao {

    @Query("SELECT * FROM dados_deputado WHERE id = :id")
    fun getDeputadoById(id: Int): Flow<DadosDeputadoEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(resumo: DadosDeputadoEntity)

}