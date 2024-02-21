package me.will.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.will.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleCard()
                }
            }
        }
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    val headerImage = painterResource(id = R.drawable.header_background)
    Image(
        painter = headerImage,
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun Article(modifier: Modifier = Modifier) {
    val titleText = stringResource(id = R.string.article_title_text)
    val briefText = stringResource(id = R.string.article_brief_text)
    val mainContentText = stringResource(id = R.string.article_main_content_text)
    Column {
        Text(
            text = titleText,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = briefText,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = mainContentText,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ArticleCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        Header()
        Article()
    }
}

@Preview(showBackground = true)
@Composable
fun LearnTogetherPreview() {
    LearnTogetherTheme {
        ArticleCard()
    }
}