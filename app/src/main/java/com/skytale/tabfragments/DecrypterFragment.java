package com.skytale.tabfragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;
import com.skytale.R;
import com.skytale.util.AlgorithmOptions;
import com.skytale.util.ClearUtil;
import com.skytale.util.CopyUtil;
import com.skytale.util.PasteUtil;

import java.util.List;

import static android.R.layout.simple_spinner_dropdown_item;

public class DecrypterFragment extends Fragment implements View.OnClickListener {
    private EditText inputText;
    private TextView resultText;
    private Button clearButton, copyButton, pasteButton, decryptButton;
    private Spinner algorithm;
    private View parentView;
    private List<String> algoOptions;
    public DecrypterFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_decrypter, container, false);
        init();
        setInteraction();
        return parentView;
    }

    private void setInteraction() {
        clearButton.setOnClickListener(this);
        copyButton.setOnClickListener(this);
        pasteButton.setOnClickListener(this);
        decryptButton.setOnClickListener(this);
    }

    private void init(){
        inputText = parentView.findViewById(R.id.edtInputText);
        resultText = parentView.findViewById(R.id.txtResultText);
        clearButton = parentView.findViewById(R.id.btnClear);
        copyButton = parentView.findViewById(R.id.btnCopy);
        algorithm = parentView.findViewById(R.id.spnAlgorithm);
        pasteButton = parentView.findViewById(R.id.btnPaste);
        decryptButton = parentView.findViewById(R.id.btnDecrypt);

        algoOptions = AlgorithmOptions.getAlgorithmOptionsList();
        ArrayAdapter<String> algoAdapter;
        algoAdapter = new ArrayAdapter<>(
                parentView.getContext(),
                simple_spinner_dropdown_item,
                algoOptions);
        algorithm.setAdapter(algoAdapter);
    }

    @Override
    public void onClick(View view) {
        Context context = getContext();
        switch (view.getId()) {
            case R.id.btnClear:
                String text = getUserInput();
                ClearUtil.clearText(context, text, inputText);
                break;

            case R.id.btnCopy:
                text = getResultText();
                System.out.println("CopyText: " + text);
                CopyUtil.copyText(context, text);
                break;

            case R.id.btnPaste:
                PasteUtil.pasteText(context, inputText);
                break;

            case R.id.btnDecrypt:
                break;

            default:
                break;
        }
    }

    private String getUserInput(){
        return inputText.getText().toString().trim();
    }
    private String getResultText(){
        return resultText.getText().toString();
    }
}