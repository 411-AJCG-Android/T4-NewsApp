package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddHome
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.ui.theme.NewsAppTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyNews(
                        innerPadding
                    )
                }
            }
        }
    }
}

@Composable
fun MyNews(
    innerPadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = 20.dp)
    ) {
        TopBar()
        // TABS
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                50.dp,
                Alignment.CenterHorizontally
            )
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Noticias",
                    fontWeight = FontWeight.Bold
                )

                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(3.dp)
                        .background(Color(0xFF6C5CE7))
                )
            }

            Text(
                text = "Eventos",
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Clima",
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Ultimas noticias",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 20.dp)
            )

            //Carrusel
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                //Noticias
                item {
                    Box(
                        modifier = Modifier
                            .width(230.dp)
                            .height(160.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFF6C5CE7)),
                        contentAlignment = Alignment.BottomCenter
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = "El presidente de EE.UU. no muestra signos de arrepentimiento...",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                            Text(
                                text = "febrero 08 - 2024",
                                color = Color.White,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }

                item {

                    Box(
                        modifier = Modifier
                            .width(230.dp)
                            .height(160.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFF6C5CE7)),
                        contentAlignment = Alignment.BottomCenter
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = "Bañarse en la piscina del desierto de Cleopatra",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                            Text(
                                text = "febrero 08 - 2024",
                                color = Color.White,
                                fontSize = 12.sp,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            }

            Text(
                text = "Alrededor del mundo",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp)
            )
            // Grid de las noticias
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(top = 15.dp)
            ) {
                items(newsList) { news ->
                    NewsCard(news)
                }
            }
        }
    }

    @Composable
    fun TopBar() {
        TODO("Not yet implemented")
    }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(30.dp),
                placeholder = {
                    Text("Buscar")
                },
                leadingIcon = {

                    Icon(
                        imageVector = Icons.Default.AddHome,
                        contentDescription = "Inicio",
                        tint = Color.Black,
                        modifier = Modifier.size(28.dp)
                    )
                }
            )
        }
    }

    @Composable
    fun GreetingPreview() {
        NewsAppTheme {
            MyNews(
                innerPadding = PaddingValues(0.dp)
            )
        }
    }
}

