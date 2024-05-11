package com.jagdish.newsappdemo.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jagdish.newsappdemo.domain.model.Article
import com.jagdish.newsappdemo.presentation.components.ArticleDetails
import com.jagdish.newsappdemo.presentation.components.TabsScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    breakingNewsIsLoading: Boolean,
    savedNewsIsLoading: Boolean,
    breakingNewsArticles: List<Article>,
    savedNewsArticles: List<Article>,
    onSaveArticle: (Article) -> Unit
) {

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            TabsScreen(
                navController = navController,
                breakingNewsIsLoading = breakingNewsIsLoading,
                savedNewsIsLoading = savedNewsIsLoading,
                savedNewsArticles = savedNewsArticles,
                breakingNewsArticles = breakingNewsArticles
            )
        }
        composable("article") {
            val article = navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")
            if (article != null)
                ArticleDetails(article = article, onSaveArticle = {
                    onSaveArticle(it)
                }
                )
        }
    }
}