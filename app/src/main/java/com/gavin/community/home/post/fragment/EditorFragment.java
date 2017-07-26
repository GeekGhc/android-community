package com.gavin.community.home.post.fragment;

import android.view.View;
import android.widget.ImageButton;

import com.gavin.community.R;
import com.gavin.community.common.base.SimpleFragment;
import com.gavin.community.utils.ToastUtil;

import io.github.mthli.knife.KnifeText;


public class EditorFragment extends SimpleFragment {

    private KnifeText knife;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_post_write;
    }

    @Override
    protected void initEventAndData() {
        initData();
        setListener();
    }

    private void initData()
    {
        knife = (KnifeText) mActivity.findViewById(R.id.knife);
        knife.setSelection(knife.getEditableText().length());
    }

    //设置一些监听事件
    private void setListener()
    {
        setupBold();
        setupItalic();
        setupUnderline();
        setupStrikethrough();
        setupBullet();
        setupQuote();
        setupLink();
        setupClear();
    }

    private void setupBold() {

        ImageButton bold = (ImageButton) getActivity().findViewById(R.id.bold);

        bold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                knife.bold(!knife.contains(KnifeText.FORMAT_BOLD));
            }
        });

    }

    private void setupItalic() {
        ImageButton italic = (ImageButton) getActivity().findViewById(R.id.italic);

        italic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                knife.italic(!knife.contains(KnifeText.FORMAT_ITALIC));
            }
        });

    }

    private void setupUnderline() {
        ImageButton underline = (ImageButton) getActivity().findViewById(R.id.underline);

        underline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                knife.underline(!knife.contains(KnifeText.FORMAT_UNDERLINED));
            }
        });
    }

    private void setupStrikethrough() {
        ImageButton strikethrough = (ImageButton) getActivity().findViewById(R.id.strikethrough);

        strikethrough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                knife.strikethrough(!knife.contains(KnifeText.FORMAT_STRIKETHROUGH));
            }
        });
    }

    private void setupBullet() {
        ImageButton bullet = (ImageButton) getActivity().findViewById(R.id.bullet);

        bullet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                knife.bullet(!knife.contains(KnifeText.FORMAT_BULLET));
            }
        });

    }

    private void setupQuote() {
        ImageButton quote = (ImageButton) getActivity().findViewById(R.id.quote);

        quote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                knife.quote(!knife.contains(KnifeText.FORMAT_QUOTE));
            }
        });
    }

    private void setupLink() {
        ImageButton link = (ImageButton) getActivity().findViewById(R.id.link);

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showLinkDialog();
                ToastUtil.show("data = "+knife.toHtml());
            }
        });
    }

    private void setupClear() {
        ImageButton clear = (ImageButton) getActivity().findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                knife.clearFormats();
            }
        });
    }
}
