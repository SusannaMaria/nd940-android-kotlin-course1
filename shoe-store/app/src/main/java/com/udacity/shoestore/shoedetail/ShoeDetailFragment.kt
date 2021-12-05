package com.udacity.shoestore.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoelist.ShoeListViewModel

/**
 * Fragment to edit and add a new shoe into the store
 */
class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        binding.controller = this
        binding.shoe = Shoe("", 0.0, "", "")
        (activity as MainActivity).supportActionBar?.title = getString(R.string.shoedetail_title_actionbar)
        return binding.root
    }
    /**
     * Save new shoe into list and return to the shoe list fragment
     */
    fun save() {
        // This is unsafe nullable type conversion to a non-nullable type
        // !! will throw NullPointerException if the value is null.
        // TODO don't know if this is valid
        val shoe = binding.shoe!!

        viewModel.addShoe(shoe)
        findNavController().popBackStack()
    }

    /**
     * Just return to the shoe list fragment
     */
    fun cancel() {
        findNavController().popBackStack()
    }
}