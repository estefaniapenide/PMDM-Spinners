package com.example.spinners

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.spinners.databinding.FragmentMainBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSpinners.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToSpinnersFragment())
        }

        binding.buttonListView.setOnClickListener{
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToListViewFragment())
        }

        binding.buttonAutocompletar.setOnClickListener{
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAutocompletarFragment())
        }
    }


}