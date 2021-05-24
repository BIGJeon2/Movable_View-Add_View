package com.example.move_view_prac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import com.example.move_view_prac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var view_count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.AddBtn.setOnClickListener {
            makeView()
        }
    }

    private fun makeView(){
        var moveX = 0f
        var moveY = 0f
        val dynamicView = TextView(this)
        dynamicView.setOnTouchListener{ v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN -> {
                    moveX = v.x - event.rawX
                    moveY = v.y - event.rawY
                }
                MotionEvent.ACTION_MOVE -> {
                    v.animate()
                        .x(event.rawX + moveX)
                        .y(event.rawY + moveY)
                        .setDuration(0)
                        .start()
                }
            }
            true
        }
        dynamicView.text = "1번"
        binding.mlinear.addView(dynamicView)
    }
}