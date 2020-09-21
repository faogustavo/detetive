package dev.valvassori.detetive.ui.base

import android.content.DialogInterface
import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

abstract class ComposableBottomSheetDialog : ComposableDialogFragment() {

    override fun onStart() {
        super.onStart()
        getBottomSheetView()?.setBackgroundResource(android.R.color.transparent)
    }

    fun setDialogStateToExpanded() {
        dialog?.setOnShowListener {
            getBottomSheetView(it)?.let { bottomSheet ->
                BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?) =
        BottomSheetDialog(requireContext(), theme)

    private fun getBottomSheetView(dialogInterface: DialogInterface? = null): FrameLayout? =
        (dialogInterface as? BottomSheetDialog)?.findViewById(R.id.design_bottom_sheet)
            ?: dialog?.window?.findViewById(R.id.design_bottom_sheet)
}
