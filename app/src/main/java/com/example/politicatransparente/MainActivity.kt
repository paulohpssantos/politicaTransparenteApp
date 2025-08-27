package com.example.politicatransparente

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.politicatransparente.ui.view.ResumoDeputadosFragment

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ResumoDeputadosFragment())
                .commit()
        }
    }
}
