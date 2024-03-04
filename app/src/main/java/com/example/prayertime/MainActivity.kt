package com.example.prayertime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prayertime.ui.theme.PrayerTimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrayerTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Prayer()
                }
            }
        }
    }
}

@Composable
fun Prayer() {
    val bgImage = painterResource(id = R.drawable.dells001)
    Box {
        Image(
            painter = bgImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.3F,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color(0xaabc99af)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PrayerFocus()
        }
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PrayerText()
        }

    }

}

@Composable
private fun PrayerFocus() {
    Text(
        text = "Today's Focus",
        textAlign = TextAlign.Center,
        fontSize = 35.sp,
        fontWeight = FontWeight.Black,
        modifier = Modifier.padding(top = 40.dp, bottom = 10.dp)
    )
    Text(
        text = randomFocus(),
        textAlign = TextAlign.Center,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,

        modifier = Modifier
            .padding(bottom = 40.dp)

    )
}

@Composable
private fun PrayerText() {


    Text(
        text = stringResource(R.string.gratitude),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        fontWeight = FontWeight.Black,
        modifier = Modifier
            .padding(20.dp)
            .clickable {
            },
    )
    Text(
        text = stringResource(R.string.requests),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        fontWeight = FontWeight.Black,
        modifier = Modifier
            .padding(20.dp)
            .clickable {
            },
    )
    Text(
        text = stringResource(R.string.repentance),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        fontWeight = FontWeight.Black,
        modifier = Modifier
            .padding(20.dp)
            .clickable {
            },
    )
    Text(
        text = stringResource(R.string.silence),
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        fontWeight = FontWeight.Black,
        modifier = Modifier
            .padding(20.dp)
            .clickable {
            },
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrayerTimeTheme {
        Prayer()
    }
}


fun randomFocus(): String {
    val focusList = arrayOf(
        "Apple",
        "Mango",
        "Banana",
        "Orange"
    )
    //return File("RandomFocus.txt").readLines().random()
    return focusList.random()
}