package com.nide.tecom.ui.productDetails.review

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nide.tecom.R
import com.nide.tecom.databinding.FragmentWriteReviewBottomSheetBinding


class WriteReviewBottomSheetFragment : BottomSheetDialogFragment() {


    lateinit var binding: FragmentWriteReviewBottomSheetBinding
    lateinit var behavior: BottomSheetBehavior<*>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_write_review_bottom_sheet,
            container,
            false
        )
        behavior = (dialog as BottomSheetDialog).behavior
        return binding.root

    }


}