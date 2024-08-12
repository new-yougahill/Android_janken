package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun PlayerView(hand:Int){
    if (hand ==0){
        Image(
            painter = painterResource(id = R.drawable.gu),
            contentDescription = null
        )
    }else if (hand ==1){
        Image(
            painter = painterResource(id = R.drawable.choki),
            contentDescription = null
        )
    } else if (hand ==2){
    Image(
        painter = painterResource(id = R.drawable.pa),
        contentDescription = null
    )
    }
}

@Preview
@Composable
fun PlayerViewPreview(){
    PlayerView(1)}

@Composable
fun ComputerView(comHand : Int) {
    when (comHand) {
        0 -> Image(
            painter = painterResource(id = R.drawable.gu),
            contentDescription = null
        )

        1 -> Image(
            painter = painterResource(id = R.drawable.choki),
            contentDescription = null
        )

        2 -> Image(
            painter = painterResource(id = R.drawable.pa),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun ComputerViewPreview() {
    ComputerView(0)
}


@Composable
fun ResultView(result:Int){
    when (result){
        0 -> Text(text = "あいこです", fontSize = 32.sp)
        1 -> Text(text = "あなたの勝ちです", fontSize = 32.sp, color = Color(0xFFD81B60))
        2 -> Text(text = "コンピュータの勝ちです", fontSize = 32.sp, color = Color(0xFF87CEFA))
    }
}


@Preview(showBackground = true)
@Composable
fun ResultViewPreview(){
    Column{
        ResultView(0)
        ResultView(1)
        ResultView(2)
    }

}


@Composable
fun Content(){
    var myHand by remember {mutableStateOf(-1)}
    var comHand by remember {mutableStateOf(-1)}
    var resultHand by remember {mutableStateOf(-1)}

    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Text("じゃんけんアプリ")
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = {}) {
            Text("グー")
            }
            Button(onClick = {}) {
            Text("チョキ")
            }
            Button(onClick = {}) {
            Text("パー")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPreview(){
    Content()
}

