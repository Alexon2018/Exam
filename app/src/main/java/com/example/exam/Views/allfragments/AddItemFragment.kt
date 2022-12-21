package com.example.exam.Views.allfragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.exam.ViewModels.InventoryViewModel
import com.example.exam.ViewModels.InventoryViewModelFactory
import com.example.exam.databinding.FragmentAddItemBinding
import com.example.exam.model.InventoryApplication
import com.example.exam.model.Item

class AddItemFragment : Fragment() {

    private val viewModel: InventoryViewModel by activityViewModels {
        InventoryViewModelFactory(
            (activity?.application as InventoryApplication).database
                .itemDao()
        )
    }
    private val navigationArgs: ItemDetailFragmentArgs by navArgs()
    lateinit var item: Item

    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    // aici adaugam un nou Item, verificam daca e valid, apoi apelam add din viewModel cu parametrii din form; la final redirectam
    private fun addNewItem() {
        if (isEntryValid()) {
            viewModel.addNewItem(
                binding.itemIntrebare.text.toString(),
                binding.itemCategoria.text.toString(),
                binding.itemRaspuns1.text.toString(),
                binding.itemRaspuns2.text.toString(),
                binding.itemBool1.isChecked,
                binding.itemBool2.isChecked
            )
            val action = AddItemFragmentDirections.actionAddItemFragmentToItemListFragment()
            findNavController().navigate(action)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //aici verificam daca exista deja date (vine pt update), daca nu facem add
        val id = navigationArgs.itemId
        if (id > 0) {
            viewModel.retrieveItem(id).observe(this.viewLifecycleOwner) { selectedItem ->
                item = selectedItem
                bind(item)
            }
        } else {
            binding.saveAction.setOnClickListener {
                addNewItem()
            }
        }
    }

    // aici facem bind intre valoarea din model/Item de campul respectiv din formular, la final pornim updateItem
    private fun bind(item: Item) {
        binding.apply {
            itemIntrebare.setText(item.itemIntrebare, TextView.BufferType.SPANNABLE)
            itemCategoria.setText(item.itemCategoria, TextView.BufferType.SPANNABLE)
            itemRaspuns1.setText(item.itemRaspuns1, TextView.BufferType.SPANNABLE)
            itemRaspuns2.setText(item.itemRaspuns2, TextView.BufferType.SPANNABLE)
            itemBool1.isChecked = item.itemBool1
            itemBool2.isChecked = item.itemBool2

            saveAction.setOnClickListener { updateItem() }
        }
    }

    // aici verificam daca este valid, apelam updateItm din viewmodel, la final facem tranzitia spre RV
    private fun updateItem() {
        if (isEntryValid()) {
            viewModel.updateItem(
                this.navigationArgs.itemId,
                this.binding.itemIntrebare.text.toString(),
                this.binding.itemCategoria.text.toString(),
                this.binding.itemRaspuns1.text.toString(),
                this.binding.itemRaspuns2.text.toString(),
                this.binding.itemBool1.isChecked,
                this.binding.itemBool2.isChecked
            )
            val action = AddItemFragmentDirections.actionAddItemFragmentToItemListFragment()
            findNavController().navigate(action)
        }
    }

    //aici intoarcem un bool prin functia isEntryValid din viewModel cu parametrii proveniti din formular
    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.itemIntrebare.text.toString(),
            binding.itemCategoria.text.toString(),
            binding.itemRaspuns1.text.toString(),
            binding.itemRaspuns2.text.toString()
        )
    }

}