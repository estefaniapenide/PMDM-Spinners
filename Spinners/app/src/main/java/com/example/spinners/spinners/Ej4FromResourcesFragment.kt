package com.example.spinners.spinners

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.spinners.R
import com.example.spinners.databinding.FragmentEj4FromResourcesBinding

class Ej4FromResourcesFragment : Fragment() {
    private var _binding: FragmentEj4FromResourcesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentEj4FromResourcesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayAdapter =ArrayAdapter.createFromResource(requireActivity(),R.array.planetas,R.layout.displayed_item)

        arrayAdapter.setDropDownViewResource(R.layout.list_items)

        binding.spinner.adapter=arrayAdapter

        binding.spinner.setSelection(0,false)

        binding.spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                binding.textViewItem.text="ITEM: ${(view as TextView).text}"
                binding.textViewId.text="ID: $id"
                binding.textViewPosicion.text="POSICIÓN: $position"

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}