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

        binding.spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                binding.textViewItem.text="ITEM: ${(p1 as TextView).text}"
                binding.textViewId.text="ID: $p3"
                binding.textViewPosicion.text="POSICIÓN: $p2"

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}