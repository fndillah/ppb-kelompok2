package com.example.catatankeuangan.features

//import androidx.compose.foundation.lazy.GridCells
//import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.catatankeuangan.Course
import com.example.catatankeuangan.R
import com.example.catatankeuangan.ui.CourseSection
import com.example.catatankeuangan.ui.GreetingSection
import com.example.catatankeuangan.ui.theme.Beige1
import com.example.catatankeuangan.ui.theme.Beige2
import com.example.catatankeuangan.ui.theme.Beige3
import com.example.catatankeuangan.ui.theme.BlueViolet1
import com.example.catatankeuangan.ui.theme.BlueViolet2
import com.example.catatankeuangan.ui.theme.BlueViolet3
import com.example.catatankeuangan.ui.theme.LightGreen1
import com.example.catatankeuangan.ui.theme.LightGreen2
import com.example.catatankeuangan.ui.theme.LightGreen3
import com.example.catatankeuangan.ui.theme.OrangeYellow1
import com.example.catatankeuangan.ui.theme.OrangeYellow2
import com.example.catatankeuangan.ui.theme.OrangeYellow3
import com.example.catatankeuangan.ui.theme.skyblue1
import com.example.catatankeuangan.ui.theme.skyblue2
import com.example.catatankeuangan.ui.theme.skyblue3

@ExperimentalFoundationApi
@Preview(widthDp = 700, heightDp = 1400)
@Composable
fun ProfileScreen() {


        Column {
            GreetingSection()
//            ChipSection(chips = listOf("Data structures", "Algorithms", "competitive programming", "python"))
//            suggestionSection()
            CourseSection(
                courses = listOf(
                    Course(
                        title = "geek of the year",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Course(
                        title = "How does AI Works",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Course(
                        title = "Advance python Course",
                        R.drawable.ic_play,
                        skyblue1,
                        skyblue2,
                        skyblue3
                    ),
                    Course(
                        title = "Advance Java Course",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Course(
                        title = "prepare for aptitude test",
                        R.drawable.ic_play,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Course(
                        title = "How does AI Works",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                )
            )

        }

}
