package com.jagdish.newsappdemo.data.data_sources

import androidx.room.TypeConverter
import com.jagdish.newsappdemo.domain.SourceEntity

class SourceConverters {

    @TypeConverter
    fun fromSource(source: SourceEntity): String? = source.name

    @TypeConverter
    fun toSource(name: String): SourceEntity = SourceEntity(name, name)

}