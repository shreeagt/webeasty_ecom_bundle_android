package com.nide.tecom.ui.search.query

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SearchView

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.databinding.FragmentSearchBinding
import com.nide.tecom.databinding.RecentChipBinding
import com.nide.tecom.util.observeFlow
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_search

    private val viewModel: QueryViewModel by viewModels()


    override fun setUP() {

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner

        }


        observable()

        initClicks()

    }

    private fun initClicks() = binding?.apply{




    }

    private fun observable() {
        observeFlow(viewModel.recentSearch){ item ->
            binding?.recentGroup?.removeAllViews()
            Timber.i("search : $item")
            item.forEach{
               binding?.recentGroup?.addView(createChip(it.itemName))
            }
        }
    }

    private fun createChip(name: String): Chip {
        val chip = RecentChipBinding.inflate(layoutInflater).root
        chip.text = name
        chip.setOnClickListener{
            navigateToSearch(name)
        }
        return chip
    }

    private fun navigateToSearch(query: String){
        val action =
            SearchFragmentDirections.actionSearchFragmentToSearchProductFragment(
                query
            )
        findNavController().navigate(action)
    }

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentSearchBinding
        get() = DataBindingUtil::inflate
}