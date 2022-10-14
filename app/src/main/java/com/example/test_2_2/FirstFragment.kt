package com.example.test_2_2

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.test_2_2.databinding.FragmentFirstBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*


class FirstFragment : Fragment() {

    private var visitors_list = mutableListOf<visitor>()
    private lateinit var _name :String
    private lateinit var _email:String
    private lateinit var _age :String
    private lateinit var _time :String
    private lateinit var new_visitor:visitor
    private lateinit var time_str:String


    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val dialogBuilder = AlertDialog.Builder(this.context)
        dialogBuilder.setMessage("Заполните все поля корректно")
            .setCancelable(false)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.cancel()
            }

        val alert = dialogBuilder.create()
        alert.setTitle("Error")

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.textTime.setOnClickListener{
            openTimePicker()
        }

        binding.further.setOnClickListener{

            _name = binding.personName.text.toString()
            _email = binding.personEmail.text.toString()
            _age = binding.personAge.text.toString()
            _time = binding.textTime.text.toString()

            if (_name.isNotEmpty() and _email.isNotEmpty() and _age.isNotEmpty() and _time.isNotEmpty())
            {
                new_visitor = visitor(_name, _email, _age.toInt(), _time)
                visitors_list.add(new_visitor)

                binding.personName.text.clear()
                binding.personEmail.text.clear()
                binding.personAge.text.clear()
                binding.textTime.text.clear()

            }
            else
            {
                alert.show()
            }

        }


        binding.endRegistBtn.setOnClickListener{
            val arr: Array<visitor> = visitors_list.toTypedArray()
            val action = FirstFragmentDirections.actionFirstFragmentToVisitorListFragment(arr)
            findNavController().navigate(action)
        }

        return binding.root
    }



    private fun openTimePicker() {
        val calendar: Calendar = Calendar.getInstance()
        var hour = calendar.get(Calendar.HOUR)
        var minute = calendar.get(Calendar.MINUTE)

        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setHour(hour)
            .setMinute(minute)
            .setTitleText("Set time arrival")
            .build()

        picker.show(childFragmentManager, "TAG")

        picker.addOnPositiveButtonClickListener{
            hour = picker.hour
            minute = picker.minute
            time_str = "$hour:$minute"
            binding.textTime.setText(time_str)
        }

    }

}