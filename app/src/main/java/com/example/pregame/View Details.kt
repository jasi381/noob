package com.example.pregame


import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pregame.Utils.Common
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Timer
import java.util.concurrent.TimeUnit

@Composable
fun Details() {
    Surface(
        color = Common.navyBlue,
        modifier = Modifier
            .fillMaxSize()
            .background(Common.navyBlue)
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)

    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            var textState by rememberSaveable() {
                mutableStateOf("")
            }

            LaunchedEffect(key1 = 1 ){
                timer(updateTimeText = {
                    textState = it.toString()
                })
            }

            if(textState.equals("0")){
                CrouselImage2()
            }else{
                CrouselImage(textState)
            }

            TabView()
        }

    }

}

@Composable
fun CrouselImage(textState : String) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding()
            .clip(RoundedCornerShape(10.dp)),
    )
    {
        Box() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(),
                painter = painterResource(id = R.drawable.crouselimage),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Image(modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(11.dp)
                .size(50.dp)
                .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null )
        }

        Box(
            modifier = Modifier
                .background(Color.Red)
                .height(85.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                .padding(10.dp),
            contentAlignment = Alignment.Center,
        ) {

            Text(
                text = "THE GAME WILL START IN 00:00:0$textState",
                modifier = Modifier
                    .height(22.dp)
                    .width(300.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )
        }
        ButtonUi()

    }
}

fun timer(updateTimeText : (Long)-> Unit){
    val timer = object: CountDownTimer(10000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val sec = (millisUntilFinished/1000) % 60
            updateTimeText(sec)
        }
        override fun onFinish() {
        }
    }
    timer.start()

}

@Composable
fun ButtonUi() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material.Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp)
                .clip(RoundedCornerShape(10.dp)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Common.lightGrey
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.button_text___icon),
                tint = Color.White,
                contentDescription = null
            )
        }
        androidx.compose.material.Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
                .clip(RoundedCornerShape(11.dp)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Common.lightGrey
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.button_text___icon1),
                tint = Color.White,
                contentDescription = null
            )
        }
    }
}



//Live Game
@Composable
fun CrouselImage2() {
//   var isVisible by remember {
    //       mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(),
    )
    {
        Box(
           ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding()
                    .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(id = R.drawable.crouselimage),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Image(modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(11.dp)
                .size(50.dp)
                .clip(RoundedCornerShape(10.dp)),

                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null )
        }
        Box(
            modifier = Modifier
                .background(Common.navyBlue)
                .height(145.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,

        ) {


        }

    }
}

