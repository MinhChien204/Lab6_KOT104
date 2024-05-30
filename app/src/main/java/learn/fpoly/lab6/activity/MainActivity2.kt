package learn.fpoly.lab6.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import learn.fpoly.lab6.ui.theme.screen.CinemaSeatBookingScreen
import learn.fpoly.lab6.ui.theme.screen.createTheaterSeating

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinemaSeatBookingScreen(
                createTheaterSeating(
                    totalRows = 12,
                    totalSeatsPerRow = 9,
                    aislePositionInRow = 4,
                    aislePositionInColumn = 5,
                ), totalSeatsPerRow = 9
            )
        }
    }
}