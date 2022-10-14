package com.example.test_2_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.test_2_2.databinding.FragmentVisitorListBinding

class VisitorListFragment : Fragment() {

    private val args by navArgs<VisitorListFragmentArgs>()
    private lateinit var binding: FragmentVisitorListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val visitors_arr = args.visitors
        binding = FragmentVisitorListBinding.inflate(inflater, container, false)

        val adapter = CustomAdapter(binding.root.context, visitors_arr.toCollection(ArrayList()))
        binding.visitorsListview.adapter = adapter

        // Inflate the layout for this fragment
        return binding.root
    }

}