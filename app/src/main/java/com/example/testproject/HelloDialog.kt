package com.example.testproject

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class HelloDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val allertDialogBuilder = AlertDialog.Builder(activity)
        allertDialogBuilder.setMessage("Привет")
        allertDialogBuilder.setNegativeButton("Закрыть") { dialogInterface, i ->
            dialog.dismiss()
        }
        return  allertDialogBuilder.create()
    }
}