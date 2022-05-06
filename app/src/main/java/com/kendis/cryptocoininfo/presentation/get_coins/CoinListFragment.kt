package com.kendis.cryptocoininfo.presentation.get_coins

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.kendis.cryptocoininfo.R
import com.kendis.cryptocoininfo.databinding.FragmentItemListBinding
import com.wada811.databinding.dataBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CoinListFragment : Fragment() {

    private val viewModel: CoinListViewModel by viewModels()
    private val binding: FragmentItemListBinding by dataBinding()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        if (view is RecyclerView) {
            with(view) {
                adapter = MyCoinListRecyclerViewAdapter(emptyList())
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state ->
                binding.list.adapter = MyCoinListRecyclerViewAdapter(state.coins)
            }
        }
    }
}