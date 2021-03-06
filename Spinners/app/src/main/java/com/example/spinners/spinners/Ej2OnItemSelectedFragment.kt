package com.example.spinners.spinners

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import com.example.spinners.databinding.FragmentEj2OnItemSelectedBinding

class Ej2OnItemSelectedFragment : Fragment() {
    private var _binding: FragmentEj2OnItemSelectedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentEj2OnItemSelectedBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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