package com.example.a501hw3_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// import com.example.a501hw3_2.ui.theme.A501hw3_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileBadgeScreen()
                }
            }
        }
    }
}

/**
 * Main screen that contains the profile picture and the toggle button.
 */
@Composable
fun ProfileBadgeScreen() {
    // 1. State to control the visibility of the badge.
    // `remember` stores the value across recompositions.
    // `mutableStateOf` makes it observable, so the UI updates when it changes.
    var showBadge by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ProfileImageWithBadge(
            isBadgeVisible = showBadge
        )

        Spacer(modifier = Modifier.height(32.dp))

        // 2. Button to toggle the badge visibility.
        Button(
            // When clicked, invert the current boolean state.
            onClick = { showBadge = !showBadge }
        ) {
            // Dynamically change the button text based on the state.
            Text(text = if (showBadge) "Hide Badge" else "Show Badge")
        }
    }
}

/**
 * Composable for the profile picture with an optional notification badge.
 * @param isBadgeVisible A boolean that determines if the badge should be shown.
 */
@Composable
fun ProfileImageWithBadge(isBadgeVisible: Boolean) {
    // 3. Box is used to stack children on top of each other.
    Box(
        modifier = Modifier.size(150.dp), // A fixed size for the profile picture container.
        contentAlignment = Alignment.Center // Center the content (the picture) by default.
    ) {
        // --- Child 1: The Profile Picture Placeholder ---
        // This is drawn first, so it's at the bottom of the stack.
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape) // Makes the box circular.
                .background(Color.DarkGray)
                .border(2.dp, Color.White, CircleShape)
        ) {
            // In a real app, you'd place an Image composable here.
            // For this demo, we'll add a text placeholder.
            Text(
                text = "Toast",
                color = Color.White,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // 4. Conditional rendering of the badge.
        // This whole block will only be composed if isBadgeVisible is true.
        if (isBadgeVisible) {
            // --- Child 2: The Notification Badge ---
            // This is drawn second, so it's on top of the profile picture.
            Box(
                modifier = Modifier
                    // 5. align() is a BoxScope modifier that positions this child
                    // relative to the parent Box. We align it to the bottom-end corner.
                    .align(Alignment.BottomEnd)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.error) // A standard red for notifications.
                    .border(2.dp, Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "!", // The badge content. Could also be a number.
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        ProfileBadgeScreen()
    }
}