package com.newsmvvmkotlin.repository

import com.newsmvvmkotlin.api.RetrofitInstance
import com.newsmvvmkotlin.db.ArticleDatabase
import com.newsmvvmkotlin.models.Article

class NewsRepository(
    val db : ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode : String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery : String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticle()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}