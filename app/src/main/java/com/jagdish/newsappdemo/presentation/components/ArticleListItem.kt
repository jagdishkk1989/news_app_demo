package com.jagdish.newsappdemo.presentation.components
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card

import androidx.compose.material.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.jagdish.newsappdemo.domain.model.Article

import com.jagdish.newsappdemo.R;

@Composable
fun ArticleListItem(
    navController: NavHostController,
    article: Article,
    isClickable: Boolean
) {
    Card(
        modifier = Modifier.clickable {
            if (isClickable) {
            navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
                navController.navigate("article")
            }
        },
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(4.dp)
        ) {
             /// Loading image from URL
            AsyncImage(
                model = article.urlToImage,
                contentDescription = "News image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                placeholder = painterResource(R.drawable.ic_launcher_foreground),

            )
            Spacer(modifier = Modifier.height(4.dp))
            article.title?.let { it1 ->
                Text(
                    text = it1, textAlign = TextAlign.Start, fontWeight = FontWeight.W800,
                    color = Color(android.graphics.Color.BLACK),
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}