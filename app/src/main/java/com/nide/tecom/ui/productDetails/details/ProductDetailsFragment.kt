package com.nide.tecom.ui.productDetails.details

import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.nide.tecom.R
import com.nide.tecom.core.base.BaseFragment
import com.nide.tecom.data.model.ReviewModel
import com.nide.tecom.databinding.FragmentProductDetailsBinding
import com.nide.tecom.ui.productDetails.adapter.ReviewAdapter
import com.nide.tecom.ui.productDetails.adapter.SlideImageAdapter
import com.nide.tecom.ui.productDetails.review.WriteReviewBottomSheetFragment


class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding>(), MenuProvider {

    override val layoutRes: Int
        get() = R.layout.fragment_product_details

    private val sliderAdapter by lazy { SlideImageAdapter() }

    private val reviewAdapter by lazy { ReviewAdapter() }

    override fun setUP() {
        val test =
            "<h2>Title</h2><br><p>Description here thisfd sdfsdfa asdfsdfsdfadf sdfadfladfjlkasdfasdf" +
                    "<b>Debashis</b> sadfsdfaskdfjasdf asdfasdfdfasdfaf</p>"
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            imageSlider.adapter = sliderAdapter
//            textView20.text = HtmlCompat.fromHtml(test,HtmlCompat.FROM_HTML_MODE_COMPACT)
            textView20.text = resources.getString(R.string.lorem_ipsum)
            rating.rvRating.adapter = reviewAdapter
            btnWriteReview.setOnClickListener {
                val bottomSheet = WriteReviewBottomSheetFragment()
                bottomSheet.show(parentFragmentManager, "some tag")
            }
        }
        (requireActivity() as MenuHost).addMenuProvider(this,viewLifecycleOwner)
        sliderAdapter.submitList(getImageList())
        reviewAdapter.submitList(demoReview())

    }

    override val bindingInflater: (LayoutInflater, Int, ViewGroup?, Boolean) -> FragmentProductDetailsBinding
        get() = DataBindingUtil::inflate


    fun getImageList() = listOf(
        "https://images.unsplash.com/photo-1575783970733-1aaedde1db74?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c2xpZGV8ZW58MHx8MHx8&w=1000&q=80",
        "https://media.istockphoto.com/id/1329268101/photo/children-playground-equipment-colorful-playground-empty-outdoor-playground-set-play-area-play.jpg?b=1&s=170667a&w=0&k=20&c=wJY69cXS3kagEYopYOS6R7gusmbwHXXWIE8dklx-daw=",
        "https://media.istockphoto.com/id/1080548204/photo/new-public-suburban-children-park-playground-in-california-with-slides-on-a-sunny-day.jpg?b=1&s=170667a&w=0&k=20&c=AO0G13130vx4LotZsGgaVU1SSjnlyjK0wtQgeilivfE="
    )

    fun demoReview() = listOf(
        ReviewModel(
            "sdf",
            "Debashis",
            "Good product",
            "some good review",
            "2 Feb 2023",
            3.4f
        ),
        ReviewModel(
            "sdf",
            "Suraj",
            "Good product",
            "some good review",
            "2 Feb 2023",
            3.4f
        ),
        ReviewModel(
            "sdf",
            "Akash",
            "Good product",
            "some good review",
            "2 Feb 2023",
            3.4f
        ),
        ReviewModel(
            "sdf",
            "Debashis",
            "Good product",
            "some good review",
            "2 Feb 2023",
            3.4f
        ),
        ReviewModel(
            "sdf",
            "Tushar",
            "Good product",
            "some good review",
            "2 Feb 2023",
            3.4f
        )
    )

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.product_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.item_favorite -> {
                findNavController().navigate(R.id.favoriteFragment)
                true
            }
            R.id.item_bag -> {
                findNavController().navigate(R.id.cartFragment)
                true
            }
            else -> false
        }

    }
}