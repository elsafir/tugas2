package com.ppb.tugas2.ui.webview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.ppb.tugas2.databinding.FragmentWebviewBinding;

public class WebViewFragment extends Fragment {

    private WebViewModel webViewModel;
    private FragmentWebviewBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        webViewModel =
                new ViewModelProvider(this).get(WebViewModel.class);

        binding = FragmentWebviewBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final WebView webView = binding.web;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}