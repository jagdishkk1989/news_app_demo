package com.jagdish.newsappdemo.presentation.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.jagdish.newsappdemo.R
import com.jagdish.newsappdemo.domain.model.Article
import com.jagdish.newsappdemo.presentation.dialogs.SnackBarView
import kotlinx.coroutines.launch


@Composable
fun ArticleDetails(
    article: Article, onSaveArticle: (Article) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() } // this contains the `SnackbarHostState`
    val coroutineScope = rememberCoroutineScope()

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
               modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color(android.graphics.Color.WHITE),
                title = {
                    Text(
                        text = "News Details",
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.W800
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                    ) {
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
                                text = it1,
                                textAlign = TextAlign.Start,
                                fontWeight = FontWeight.W800,

                                )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        article.description?.let { it1 ->
                            Text(
                                text = it1,
                                textAlign = TextAlign.Start,
                                fontWeight = FontWeight.W600,
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        article.publishedAt?.let { it1 ->
                            Text(
                                text = "publishedAt:  $it1",
                                textAlign = TextAlign.Start,
                                fontWeight = FontWeight.W400,
                                style = TextStyle(color = Color.Black),
                            )
                        }
                    }

                    FloatingActionButton(

                        modifier = Modifier
                            .align(
                                Alignment.BottomEnd
                            )
                            .padding(32.dp), onClick = {
                            onSaveArticle(article)
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar(
                                    message = "Item saved successfully",
                                    duration = SnackbarDuration.Short
                                )
                            }
                        }) {
                        Icon(
                            Icons.Default.Star, "Save",
                        )
                    }
                    SnackBarView(
                        message = "Article saved successfully",
                        snackbarHostState = snackbarHostState
                    )
                }

            }


        }
    }


}