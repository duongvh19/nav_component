package com.duongvh19.navcomponent.sport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.duongvh19.navcomponent.databinding.FragmentListSportBinding


class ListSportFragment : Fragment() {
    private lateinit var binding: FragmentListSportBinding
    private val sportsViewModel : SportsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentListSportBinding.inflate(inflater, container, false).root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListSportBinding.bind(view)
        val sportsAdapter = SportsAdapter {sport ->
            sportsViewModel.updateCurrentSport(sport)
            Toast.makeText(requireContext(), getString(sport.titleResourceId), Toast.LENGTH_SHORT ).show()
            findNavController().navigate(ListSportFragmentDirections.actionListSportFragmentToDetailSportFragment())

        }
        sportsAdapter.submitList(sportsViewModel.sportsData)
        binding.sportsList.adapter = sportsAdapter
    }

}