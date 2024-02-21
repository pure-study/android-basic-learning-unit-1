package me.will.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.will.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeFunctionsCard()
                }
            }
        }
    }
}

@Composable
private fun SingleQuadrant(functionName: String, description: String, backgroundColor: Color, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(backgroundColor)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = functionName,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ComposeFunctionsCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(Modifier.weight(0.5F)) {
            SingleQuadrant(
                functionName = stringResource(id = R.string.composable_text_text),
                description = stringResource(id = R.string.composable_text_desc_text),
                backgroundColor = colorResource(id = R.color.top_left_color),
//                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(0.5F)
            )
            SingleQuadrant(
                functionName = stringResource(id = R.string.composable_image_text),
                description = stringResource(id = R.string.composable_image_desc_text),
                backgroundColor = colorResource(id = R.color.top_right_color),
                modifier = Modifier.weight(0.5F)
            )
        }
        Row(Modifier.weight(0.5F)) {
            SingleQuadrant(
                functionName = stringResource(id = R.string.composable_row_text),
                description = stringResource(id = R.string.composable_row_desc_text),
                backgroundColor = colorResource(id = R.color.bottom_left_color),
                modifier = Modifier.weight(0.5F)
            )
            SingleQuadrant(
                functionName = stringResource(id = R.string.composable_column_text),
                description = stringResource(id = R.string.composable_column_desc_text),
                backgroundColor = colorResource(id = R.color.bottom_right_color),
                modifier = Modifier.weight(0.5F)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantTheme {
        ComposeFunctionsCard()
    }
}