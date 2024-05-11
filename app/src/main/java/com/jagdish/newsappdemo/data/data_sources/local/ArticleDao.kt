package com.jagdish.newsappdemo.data.data_sources.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jagdish.newsappdemo.data.model.ArticleDto

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpdate(article: ArticleDto): Long

    @Query(value = "SELECT * FROM articles")
    fun getSavedArticles(): List<ArticleDto>

    @Delete
    suspend fun deleteArticle(article: ArticleDto)

}