package com.rsz.androidmenubasednavigation

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment) as NavHostFragment

        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.share -> {
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.changepass -> {
                Toast.makeText(this, "Change Password", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.changephoto -> {
                Toast.makeText(this, "Change Photo", Toast.LENGTH_SHORT).show()
                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}