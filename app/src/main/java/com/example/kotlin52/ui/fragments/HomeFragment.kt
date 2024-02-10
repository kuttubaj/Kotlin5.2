package com.example.kotlin52.ui.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.kotlin52.R
import com.example.kotlin52.data.models.Item
import com.example.kotlin52.databinding.FragmentHomeBinding
import com.example.kotlin52.ui.adapter.ItemAdapter
import com.example.kotlin52.ui.views.ItemViewModel
import com.example.kotlin52.utils.App

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private val itemAdapter = ItemAdapter()
    private val viewModel by activityViewModels<ItemViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        toGoSecondFragment()
    }

    private fun initialize() = with(binding) {
        viewModel.getItem()
        viewModel.itemLIveData.observe(viewLifecycleOwner) { uiState ->
            rvItem.adapter = itemAdapter
            uiState.success?.let {
                itemAdapter.setItem(it.toMutableList())
            }
        }
    }

    private fun toGoSecondFragment() = with(binding) {
        addButton.setOnClickListener {
            progressBar.isVisible = true
            Handler().postDelayed(
                {
                    progressBar.isVisible = false
                    findNavController().navigate(R.id.action_homeFragment_to_addItemFragment)
                },
                3000
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}