package com.example.kotlin52.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.kotlin52.R
import com.example.kotlin52.data.models.Item
import com.example.kotlin52.databinding.FragmentAddItemBinding
import com.example.kotlin52.ui.views.ItemViewModel


class AddItemFragment : Fragment() {
    private var _binding: FragmentAddItemBinding? = null
    private val binding: FragmentAddItemBinding get() = _binding!!
    private val viewModel by activityViewModels<ItemViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goBack()

    }

    private fun goBack() = with(binding) {
        binding.addButton.setOnClickListener {
            progressBar.isVisible = true
           android.os.Handler().postDelayed({
                progressBar.isVisible = false
                viewModel.addItem(Item(
                    image = R.drawable.hello,
                    name = etName.text.toString().trim()
                )
                )
                findNavController().navigateUp()
            }, 2000)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}