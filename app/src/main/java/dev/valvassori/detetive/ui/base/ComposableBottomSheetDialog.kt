package dev.valvassori.detetive.ui.base

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import dev.valvassori.detetive.R

abstract class ComposableBottomSheetDialog : ComposableDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomDialogStyle)
    }

    override fun onStart() {
        super.onStart()
        getBottomSheetView()?.setBackgroundResource(android.R.color.transparent)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?) =
        BottomSheetDialog(requireContext(), theme).also { dialog ->
            setDialogStateToExpanded(dialog)
        }

    private fun getBottomSheetView(dialogInterface: DialogInterface? = null): FrameLayout? =
        (dialogInterface as? BottomSheetDialog)?.findViewById(R.id.design_bottom_sheet)
            ?: dialog?.window?.findViewById(R.id.design_bottom_sheet)

    private fun setDialogStateToExpanded(currentDialog: Dialog?) {
        (currentDialog ?: dialog)?.setOnShowListener {
            getBottomSheetView(it)?.let { bottomSheet ->
                BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }
}
