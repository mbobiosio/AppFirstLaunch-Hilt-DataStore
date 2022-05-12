package com.mbobiosio.firstlaunchutil.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.mbobiosio.firstlaunchutil.R
import com.mbobiosio.firstlaunchutil.databinding.ActivityMainBinding
import com.mbobiosio.firstlaunchutil.repository.DataStoreRepository
import com.mbobiosio.firstlaunchutil.util.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Mbuodile Obiosio
 * */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var dataStoreRepository: DataStoreRepository

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
            dataStoreRepository.getFirstLaunch().collectLatest {
                when {
                    it -> {
                        toast("This is first launch")
                    }
                    else -> {
                        toast("Hello, welcome back")
                    }
                }
            }
        }
    }
}
