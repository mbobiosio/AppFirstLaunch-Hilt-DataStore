package com.mbobiosio.firstlaunchutil.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mbobiosio.firstlaunchutil.databinding.FragmentMainBinding
import com.mbobiosio.firstlaunchutil.repository.DataStoreRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.properties.Delegates

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModels<PrefViewModel>()

    @Inject
    lateinit var dataStoreRepository: DataStoreRepository

    private var message by Delegates.notNull<Boolean>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnStatus.setOnClickListener {

                // Get the current first launch status
                lifecycleScope.launch {
                    dataStoreRepository.getFirstLaunch().collectLatest {
                        message = it
                    }
                }
            }

            // Set application to complete first launch cycle
            btnSet.setOnClickListener {
                viewModel.setFirstLaunch(false)
            }

            // Reset the application first launch cycle
            btnRemove.setOnClickListener {
                viewModel.setFirstLaunch(true)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
