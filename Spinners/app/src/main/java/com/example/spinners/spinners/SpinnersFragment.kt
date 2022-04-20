package com.example.spinners.spinners

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.spinners.MainFragmentDirections
import com.example.spinners.R
import com.example.spinners.databinding.FragmentSpinnersBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SpinnersFragment : Fragment() {

    private var _binding: FragmentSpinnersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSpinnersBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSeleccionar.setOnClickListener {
           findNavController().navigate(
               when(binding.spinner.selectedItemPosition){
                   0 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj1EntriesFragment()
                   1 -> SpinnersFragmentDirections.actionSpinnersFragmentToEj2OnItemSelectedFragment()
                   else -> throw Exception("Excepción")
               }
           )
        }
    }


}