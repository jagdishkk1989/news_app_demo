package com.jagdish.newsappdemo.presentation.activities


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jagdish.newsappdemo.presentation.navigations.NavigationHost
import com.jagdish.newsappdemo.presentation.ui.theme.NewsAppDemoTheme
import com.jagdish.newsappdemo.presentation.viewmodel.NewsViewModel


import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val breakingNewsIsLoading = viewModel.breakingNewsIsLoading.value
                    val savedNewsIsLoading = viewModel.savedNewsIsLoading.value
                    val navController = rememberNavController()
                    NavigationHost(
                        navController = navController,
                        breakingNewsIsLoading = breakingNewsIsLoading,
                        savedNewsIsLoading = savedNewsIsLoading,
                        breakingNewsArticles = viewModel.breakingNews.value,
                        savedNewsArticles = viewModel.savedArticles.value,
                        onSaveArticle = {
                            viewModel.saveArticle(it)
                        }
                    )
                }
            }
        }
    }
}

