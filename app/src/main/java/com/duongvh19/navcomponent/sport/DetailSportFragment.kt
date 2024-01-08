package com.duongvh19.navcomponent.sport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.duongvh19.navcomponent.databinding.FragmentDetailSportBinding


class DetailSportFragment : Fragment() {

    private lateinit var binding: FragmentDetailSportBinding
    private val sportsViewModel: SportsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailSportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sportsViewModel.currentSport.observe(this.viewLifecycleOwner){ sport ->
            binding.titleDetail.text = getString(sport.titleResourceId)
            binding.imDetailSport.setImageResource(sport.sportsImageBanner)
            binding.detail.text = getString(sport.newsDetails)
        }

    }

}