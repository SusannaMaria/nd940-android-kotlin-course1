package com.udacity.shoestore.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.databinding.ItemShoeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        binding.controller = this

        val model: ShoeListViewModel by activityViewModels<ShoeListViewModel>()


        model.listLiveData.observe(viewLifecycleOwner, { list ->
            bindShoes(binding.list, list)
        })

        (activity as MainActivity).supportActionBar?.title = getString(R.string.shoelist_title_actionbar)

        return binding.root
    }

    private fun bindShoes(list: LinearLayout, items: List<Shoe>?) {
        list.removeAllViews()
        items?.forEach { shoe ->
            val shoeBinding = DataBindingUtil.inflate<ItemShoeBinding>(layoutInflater, R.layout.item_shoe, list, false)
            shoeBinding.name.text = shoe.name
            shoeBinding.companyText.text = shoe.company
            shoeBinding.descriptionText.text = shoe.description
            shoeBinding.sizeText.text = getString(R.string.size_format, shoe.size)
            list.addView(shoeBinding.root)
        }
    }
    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.menu_logout).isVisible = true
    }
    fun navigateToDetails() {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
    }
}