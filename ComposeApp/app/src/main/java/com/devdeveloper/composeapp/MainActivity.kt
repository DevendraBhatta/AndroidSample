package com.devdeveloper.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devdeveloper.composeapp.ui.theme.MyTheme
import com.devdeveloper.composeapp.ui.theme.lightGreen
import com.devdeveloper.composeapp.ui.theme.skyBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(
) {
    Scaffold(topBar = { AppBar() }) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.lightGreen
        ) {
            Column {

                ProfileCard("Messi", true)
                ProfileCard("Ronaldo", false)
                ProfileCard("Neymar Junior", true)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                Icons.Default.Home,
                "content description",
                Modifier.padding(horizontal = 12.dp)
            )
        },
        title = { Text("Messaging Application users") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.skyBlue,
            titleContentColor = MaterialTheme.colorScheme.surface,
            navigationIconContentColor = MaterialTheme.colorScheme.surface
        )
    )
}


@Composable
fun ProfileCard(user: String, status: Boolean) {
    Card(
        modifier = Modifier
            .padding(top = 12.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = CutCornerShape(topEnd = 24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture()
            ProfileContent(user, status)
        }
    }
}

@Composable
fun ProfilePicture() {
    Card(
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.lightGreen),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)

    ) {
        Image(
            painter = painterResource(R.drawable.mann),
            contentDescription = "Profile Image",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }

}


@Composable
fun ProfileContent(userName: String, isActive: Boolean) {

    val statusText = if (isActive) {
        "Active Now"
    } else {
        "Offline Now"
    }
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = userName, style = MaterialTheme.typography.headlineMedium,
        )
        Text(
            text = statusText, style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.alpha(0.8f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MyTheme {
        MainScreen()
    }
}