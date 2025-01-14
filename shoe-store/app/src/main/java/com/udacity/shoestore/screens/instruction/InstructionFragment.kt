package com.udacity.shoestore.screens.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding

/**
 * Fragment to show a small instruction how to use the store
 */
class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instruction, container, false
        )
        (activity as MainActivity).supportActionBar?.title = getString(R.string.instruction_title_actionbar)
        binding.controller = this
        return binding.root
    }

    fun navigateToListing() {
        findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
    }
}