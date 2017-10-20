package com.example.gpaint;
//
//import android.app.AlertDialog;
//import android.app.Dialog;
//import android.os.Bundle;
//import android.support.v4.app.DialogFragment;
//import android.text.InputType;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//
//public class DFragment extends DialogFragment{
//
//	@Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//            Bundle savedInstanceState) {		
//        View rootView = inflater.inflate(R.layout.dialogfragment, container,
//                false);
//        getDialog().setTitle("Save As");
//        
//        
//        // Do something else
//        return rootView;
//    }
//	
//}
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
 
public class DFragment extends DialogFragment implements
        OnEditorActionListener {
 
    public interface EditNameDialogListener {
        void onFinishEditDialog(String inputText);
    }
 
    private EditText mEditText;
 
    public DFragment() {
        // Empty constructor required for DialogFragment
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogfragment, container);
        mEditText = (EditText) view.findViewById(R.id.editText1);
        getDialog().setTitle("Save Image");
 
        // Show soft keyboard automatically
        mEditText.requestFocus();
        mEditText.setOnEditorActionListener(this);
        return view;
    }
 
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            // Return input text to activity
            EditNameDialogListener activity = (EditNameDialogListener) getActivity();
            activity.onFinishEditDialog(mEditText.getText().toString());
            this.dismiss();
            return true;
        }
        return false;
    }
}