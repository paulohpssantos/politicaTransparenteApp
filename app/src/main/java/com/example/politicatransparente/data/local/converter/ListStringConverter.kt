package com.example.politicatransparente.data.local.converter

import androidx.room.TypeConverter

class ListStringConverter {
    @TypeConverter
    fun fromList(list: List<String>?): String {
        return list?.joinToString(separator = ",") ?: ""
    }

    @TypeConverter
    fun toList(data: String?): List<String> {
        return data?.split(",")?.filter { it.isNotEmpty() } ?: emptyList()
    }
}