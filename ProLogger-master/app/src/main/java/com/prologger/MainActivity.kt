package com.prologger

import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.prologger.ui.main.EventFragment
import com.prologger.ui.main.MainFragment
import com.prologger.ui.main.MainViewModel
import kotlinx.android.synthetic.main.main_activity.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var detector: GestureDetectorCompat
    private lateinit var eventFragment: EventFragment
    private lateinit var mainFragment: MainFragment
    private lateinit var activeFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        btnNewLog.setOnClickListener {
            val intent = Intent(this, AddLogScreen::class.java)
            startActivity(intent)
        }

        eventFragment = EventFragment.newInstance()
        mainFragment = MainFragment.newInstance()
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainActivity, mainFragment)
                .commitNow()
            activeFragment = mainFragment
        }

        detector = GestureDetectorCompat(this, ProLoggerGestureListener())
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return if (detector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    inner class ProLoggerGestureListener : GestureDetector.SimpleOnGestureListener() {

        private val SWIPE_THRESHOLD = 100
        private val SWIPE_VELOCITY_THRESHOLD = 100

        override fun onFling(
            downEvent: MotionEvent?,
            moveEvent: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            val diffx = moveEvent?.x?.minus(downEvent!!.x) ?: 0.0F
            val diffy = moveEvent?.y?.minus(downEvent!!.y) ?: 0.0F

            return if (abs(diffx) > abs(diffy)) {
                // this is a left or right swipe
                if (abs(diffx) > SWIPE_THRESHOLD && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffx > 0) {
                        // right swipe
                        this@MainActivity.onSwipeRight()
                    } else {
                        // left swipe
                        this@MainActivity.onSwipeLeft()
                    }
                    true
                } else {
                    super.onFling(downEvent, moveEvent, velocityX, velocityY)
                }
            } else {
                // this is either a bottom or top swipe
                if (abs(diffy) > SWIPE_THRESHOLD && abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffy > 0) {
                        this@MainActivity.onSwipeTop()
                    } else {
                        this@MainActivity.onSwipeBottom()
                    }
                    true
                } else {
                    super.onFling(downEvent, moveEvent, velocityX, velocityY)
                }
            }
        }
    }

    private fun onSwipeBottom() {
        Toast.makeText(this, "Bottom Swipe", Toast.LENGTH_LONG).show()
    }

    private fun onSwipeTop() {
        Toast.makeText(this, "Top Swipe", Toast.LENGTH_LONG).show()
    }

    private fun onSwipeLeft() {
        //Toast.makeText( this, "Left Swipe", Toast.LENGTH_LONG ).show()
        if (activeFragment == mainFragment) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainActivity, eventFragment)
                .commitNow()
            activeFragment = eventFragment
        }
    }

    private fun onSwipeRight() {
        // Toast.makeText( this, "Right Swipe", Toast.LENGTH_LONG ).show()
        if (activeFragment == eventFragment) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainActivity, mainFragment)
                .commitNow()
            activeFragment = mainFragment
        }
    }
}