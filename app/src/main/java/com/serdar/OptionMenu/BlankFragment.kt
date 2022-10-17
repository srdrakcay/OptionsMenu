package com.serdar.OptionMenu

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.serdar.anew.R
import com.serdar.anew.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    private lateinit var binding: FragmentBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBlankBinding.inflate(layoutInflater)
        setupMenu()
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.items, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
               when(menuItem.itemId){
                   R.id.first -> {
                       findNavController().navigate(R.id.action_blankFragment_to_firstFragment)

                   }
                   R.id.second -> {
                       findNavController().navigate(R.id.action_blankFragment_to_firstFragment)
                   }
               }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }


}