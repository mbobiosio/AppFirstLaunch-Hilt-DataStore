package com.mbobiosio.firstlaunchutil.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.mbobiosio.firstlaunchutil.R
import com.mbobiosio.firstlaunchutil.databinding.ActivityMainBinding
import com.mbobiosio.firstlaunchutil.util.observeOneTime
import com.mbobiosio.firstlaunchutil.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * @author Mbuodile Obiosio
 * */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<AppViewModel>()

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        lifecycleScope.launch {
            viewModel.isFirstLaunch.observeOneTime(this@MainActivity) {
                when {
                    it -> {
                        toast("This is first launch")
                    }
                    else -> {
                        toast("Set to returning")
                    }
                }
            }
        }
    }
}
