package dev.valvassori.detective.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import dev.valvassori.detective.components.Greeting

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
        // setContentView(R.layout.main_activity)
        // if (savedInstanceState == null) {
        //     supportFragmentManager.beginTransaction()
        //         .replace(R.id.container, MainFragment.newInstance())
        //         .commitNow()
        // }
    }
}
