package com.siaptekno.temansapa

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class UtamaActivity : AppCompatActivity() {

    /*Variabel for top toolbar navigation start*/
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var toolbarMenuButton: ImageButton
    /*Variabel for top toolbar navigation end*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utama)

       /* Logic for top toolbar navigation start*/
        // Inisialisasi toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Inisialisasi DrawerLayout dan Navigation View
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        toolbarMenuButton = findViewById(R.id.toolbar_menu_button)

        //Set up ActionBarDrawerToggle
        toggle = object : ActionBarDrawerToggle(
            this, drawerLayout, R.string.open, R.string.close
        ) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                    toolbarMenuButton.setImageResource(R.drawable.ic_close) //ganti dengan ikon X
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                    toolbarMenuButton.setImageResource(R.drawable.ic_menu) //ganti dengan icon hamburger
            }
        }
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Menyembunyikan ikon default dan menggunakan ImageButton sebagai tombol drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        // Menangani klik pada toolbarMenuButton untuk membuka/menutup drawer
        toolbarMenuButton.setOnClickListener {
            if (drawerLayout.isDrawerOpen(navigationView)) {
                drawerLayout.closeDrawer(navigationView)
            } else {
                drawerLayout.openDrawer(navigationView)
            }
        }

        // Set item selected listener untuk Navigation view
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_tipe_suara -> Toast.makeText(applicationContext, "Clicked Tipe Suara", Toast.LENGTH_LONG).show()
                R.id.nav_faq -> Toast.makeText(applicationContext, "Clicked FAQ", Toast.LENGTH_LONG).show()
                R.id.nav_tentang -> Toast.makeText(applicationContext, "Clicked Tentang", Toast.LENGTH_LONG).show()
            }
            true
        }




        /* Logic for top toolbar navigation end*/



        /*Bottom navigation menu start*/
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.background = null
        bottomNavigationView.menu.get(2).isEnabled = false
    }

    /*Part of code top toolbar navigation*/
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}