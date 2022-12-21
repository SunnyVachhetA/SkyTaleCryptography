package com.skytale.tabfragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;
import com.skytale.R;
import com.skytale.service.EncrypterService;
import com.skytale.util.*;

import java.util.List;

import static android.R.layout.simple_spinner_dropdown_item;

public class EncrypterFragment extends Fragment implements View.OnClickListener {
    private EditText inputText;
    private TextView resultText;
    private Button clearButton, copyButton, pasteButton, encryptButton;
    private View parentView;
    private Spinner algorithm;

    private List<String> algoOptions;

    private EncrypterService encrypterService;
    public EncrypterFragment() {
        encrypterService = new EncrypterService();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        parentView = inflater.inflate(R.layout.fragment_encrypter, container, false);
        init();
        setInteraction();
        return parentView;
    }

    private void setInteraction(){
        clearButton.setOnClickListener(this);
        copyButton.setOnClickListener(this);
        pasteButton.setOnClickListener(this);
        encryptButton.setOnClickListener(this);

        inputText.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        Log.i("TextChange", getUserInput());
                        ClearUtil.clearText(resultText);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                }
        );
        algorithm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ClearUtil.clearText(resultText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                ClearUtil.clearText(resultText);
            }
        });
    }

    private void init(){
        inputText = parentView.findViewById(R.id.edtInputText);
        resultText = parentView.findViewById(R.id.txtResultText);
        clearButton = parentView.findViewById(R.id.btnClear);
        copyButton = parentView.findViewById(R.id.btnCopy);
        algorithm = parentView.findViewById(R.id.spnAlgorithm);
        pasteButton = parentView.findViewById(R.id.btnPaste);
        encryptButton = parentView.findViewById(R.id.btnEncrypt);

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

            case R.id.btnEncrypt:
                try {
                    String plainText = getUserInput();
                    String selectedAlgorithm = algorithm.getSelectedItem().toString();
                    encrypterService.handleEncryption(plainText, selectedAlgorithm, context, resultText);
                }catch (Exception e){
                    e.printStackTrace();
                    ToastUtil.createToast(context, "Something Went Wrong!");
                    ClearUtil.clearText(resultText);
                }
                break;

            default:
                break;
        }
    }

    private String getUserInput(){
        String text = String.valueOf(inputText.getText());
        return text;
    }

    private String getResultText(){
        String text = String.valueOf(resultText.getText());
        return text;
    }
}