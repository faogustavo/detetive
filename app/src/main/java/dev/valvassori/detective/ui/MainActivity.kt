package dev.valvassori.detective.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.valvassori.detective.R
import dev.valvassori.detective.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
