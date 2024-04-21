package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.adapter.PageAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.LaunchesFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val fragmentList = listOf(
        UpcomingFragment(),
        LaunchesFragment(),
        RocketsFragment()
    )


    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val pageAdapter = PageAdapter(this,fragmentList)
        val tabTitles = arrayListOf(getText(R.string.upcoming),getText(R.string.launches),getText(R.string.rockets))

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val pager = findViewById<ViewPager2>(R.id.pager)
        pager.setAdapter(pageAdapter)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        val tabLayoutMediator = TabLayoutMediator(
            tabLayout, pager
        ) { tab, position ->
            tab.text = tabTitles[position]
        }
        tabLayoutMediator.attach()

        for (i in 0..fragmentList.size){
            val textView = LayoutInflater.from(this).inflate(R.layout.tab_title,null) as TextView
            tabLayout.getTabAt(i)?.customView = textView
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }



}
