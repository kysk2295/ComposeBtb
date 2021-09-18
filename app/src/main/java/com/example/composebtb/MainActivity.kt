package com.example.composebtb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebtb.ui.theme.ComposeBtbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBtbTheme {
                // A surface container using the 'background' color from the theme
                ContentView()
            }
        }
    }
}

@Composable
fun ContentView(){
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(topBar = {MyAppBar()},
        bottomBar = {MyBottomBar()}) {

        }
    }
}

@Composable
fun MyBottomBar() {
    val selectedState = remember {
        mutableStateOf("home")
    }
    BottomAppBar(
        elevation = 10.dp
    ) {
        BottomNavigationItem(
            icon = {
                Icon(Icons.Filled.Home, "Home")
            },
            selected = selectedState.value=="home",
            onClick = {
                selectedState.value="home"
            },
            selectedContentColor = Color.White,
            unselectedContentColor = Color.White.copy(alpha = 0.4f)
        )

        BottomNavigationItem(
            icon = {
                Icon(Icons.Filled.Menu, "Menu")
            },
            selected = selectedState.value=="menu",
            onClick = {
                selectedState.value="menu"
            },
            selectedContentColor = Color.White,
            unselectedContentColor = Color.White.copy(alpha = 0.4f)
        )


    }
}

@Composable
fun MyAppBar() {
    TopAppBar(elevation = 10.dp,
    backgroundColor = Color.White,
    modifier = Modifier
        .height(56.dp)
        .fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Text(text = "채팅",fontSize = 16.sp,fontWeight = FontWeight.Bold)
            Image(painter = painterResource(id = R.drawable.ic_search), contentDescription = null,
            contentScale = ContentScale.Fit)

        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBtbTheme {
        ContentView()
    }
}