
package kh.com.supheng.jetpack.compose.projectbank.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.com.supheng.jetpack.compose.projectbank.R

data class Announcement(
    val date: String,
    val title: String,
    val image: Int
)

val announcements = listOf(

    Announcement(
        "12 APR 2025",
        "Khmer New Year Promotion",
        R.drawable.ic_banner4
    ),

    Announcement(
        "10 APR 2025",
        "Win 40,000 Riel",
        R.drawable.ic_banner1
    ),

    Announcement(
        "03 APR 2025",
        "ABA Special Offers",
        R.drawable.ic_banner3
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    var selectedTab by remember { mutableIntStateOf(2) }

    Scaffold(

        topBar = {

            TopAppBar(
                title = { Text("ABA Notifications") },

                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {

            val options = listOf(
                "My Alerts",
                "Transactions",
                "Announcement"
            )

            SingleChoiceSegmentedButtonRow(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {

                options.forEachIndexed { index, label ->

                    SegmentedButton(

                        shape = SegmentedButtonDefaults.itemShape(
                            index = index,
                            count = options.size
                        ),

                        selected = index == selectedTab,

                        onClick = { selectedTab = index },

                        label = { Text(label) }
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {

                items(announcements) { item ->

                    Text(
                        text = item.date,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    Card(
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Box {

                            Image(
                                painter = painterResource(item.image),
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp)
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(
                                                Color.Transparent,
                                                Color.Black.copy(alpha = 0.6f)
                                            )
                                        )
                                    )
                            )

                            Text(
                                text = item.title,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .padding(12.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
@Preview(showBackground = false)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}