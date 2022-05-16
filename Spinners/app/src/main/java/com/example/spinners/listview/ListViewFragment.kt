package com.example.spinners.listview

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.spinners.R
import com.example.spinners.databinding.FragmentListViewBinding


class ListViewFragment : Fragment() {

    private var _binding:FragmentListViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding=FragmentListViewBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listView
            .apply { adapter = ArrayAdapter.createFromResource(requireContext(), R.array.planetas,R.layout.displayed_item) }
            .apply { setOnItemClickListener { _, view, _, _ ->
                ventanaDialogo("Click en ${(view as TextView).text}")
            } }
            .apply { setOnItemLongClickListener { parent, view, position, id ->
                ventanaDialogo("""setOnItemLongClickListener:
                    |View: ${(view as TextView).text}
                    |Posición: $position
                    |Id: $id
                """.trimMargin())
                true
            } }
    }

    private fun ventanaDialogo(mensaje:String) {
        AlertDialog.Builder(requireContext()).setMessage(mensaje).setTitle("Ventana de Dialogo").create().show()
    }

}