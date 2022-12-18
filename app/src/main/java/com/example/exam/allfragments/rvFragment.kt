package com.example.exam.allfragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam.Context
import com.example.exam.DetailActivity
import com.example.exam.R
import com.example.exam.allViewModels.mainViewModel
import com.example.exam.databinding.FragmentRvBinding
import com.example.exam.utils.MyAdapter

class rvFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRvBinding>(inflater,
            R.layout.fragment_rv,container,false)
//
//        binding.temp.setOnClickListener { view : View ->
//            view.findNavController().navigate(R.id.action_rvFragment_to_detailsFragment)
//        }

        binding.rv.layoutManager = LinearLayoutManager(Context.mcontext)
        binding.rv.adapter= MyAdapter(mainViewModel().getData())
        binding.rv.hasFixedSize()

//        binding.fab.setOnClickListener {
//            val intent = Intent(this, DetailActivity::class.java)
//            startActivity(intent)

        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}
