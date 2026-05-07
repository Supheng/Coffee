package kh.com.supheng.jetpack.compose.projectbank.Model

import kh.com.supheng.jetpack.compose.projectbank.R

data class Announcement(
    val date: String,
    val title: String,
    val image: Int
)

val announcementList = listOf<Announcement>(
    Announcement("12 APR 2025", "Khmer New Year Promotion", R.drawable.ic_banner1),
    Announcement("10 APR 2025", "Win up to 40,000 Riel", R.drawable.ic_banner2),
    Announcement("03 APR 2025", "ABA Mobile Special Offers", R.drawable.ic_banner3),
    Announcement("06 FEB 2025", "Your personal banking assistant", R.drawable.ic_banner4)

)
