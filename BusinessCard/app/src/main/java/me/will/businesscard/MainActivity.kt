package me.will.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.will.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}


@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_200))
    ) {
        BasicInfoPane()
        Spacer(
            modifier = Modifier.padding(24.dp).height(190.dp)
        )
        ContactInfoPane(
            modifier = Modifier.padding(top = 12.dp, bottom = 48.dp)
        )
    }
}

@Composable
private fun BasicInfoPane(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(vertical = 6.dp)
                .width(120.dp)
                .background(Color(0xFF502050)),
        )
        Text(
            text = stringResource(id = R.string.default_name),
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
        Text(
            text = stringResource(id = R.string.default_title),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = colorResource(id = R.color.teal_700),
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
    }
}

@Composable
private fun ContactInfoPane(modifier: Modifier = Modifier) {
//    val goldenRatioLeft = 0.382F
//    val goldenRatioRight = 0.618F
    val goldenRatioLeft = 1F
    val goldenRatioRight = 2F
    val frontColor = colorResource(id = R.color.teal_700)
    val commonContactInfoPadding = 4.dp
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .weight(goldenRatioLeft)
                .padding(6.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.phone_black_24dp),
                contentDescription = null,
                tint = frontColor,
                modifier = Modifier.padding(commonContactInfoPadding)
            )
            Icon(
                painter = painterResource(id = R.drawable.share_black_24dp),
                contentDescription = null,
                tint = frontColor,
                modifier = Modifier.padding(commonContactInfoPadding)
            )
            Icon(
                painter = painterResource(id = R.drawable.email_black_24dp),
                contentDescription = null,
                tint = frontColor,
                modifier = Modifier.padding(commonContactInfoPadding)
            )
        }
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .weight(goldenRatioRight)
                .padding(6.dp)
        ) {
            Text(
                text = stringResource(id = R.string.default_phone_number),
                color = frontColor,
                modifier = Modifier.padding(commonContactInfoPadding)
            )
            Text(
                text = stringResource(id = R.string.default_social_account),
                color = frontColor,
                modifier = Modifier.padding(commonContactInfoPadding)
            )
            Text(
                text = stringResource(id = R.string.default_email_address),
                color = frontColor,
                modifier = Modifier.padding(commonContactInfoPadding)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}