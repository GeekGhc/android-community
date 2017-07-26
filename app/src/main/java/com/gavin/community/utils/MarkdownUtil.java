package com.gavin.community.utils;

import br.tiagohm.markdownview.MarkdownView;
import br.tiagohm.markdownview.css.ExternalStyleSheet;
import br.tiagohm.markdownview.css.InternalStyleSheet;
import br.tiagohm.markdownview.css.styles.Github;

/**
 * Created by Administrator on 2017/7/25.
 */

public class MarkdownUtil {
    public MarkdownView mMarkDown;

    public void MarkdownView(){

    }

    public static MarkdownView setCss(MarkdownView markdownView)
    {
        InternalStyleSheet css = new Github();
        css.addFontFace("MyFont", "condensed", "italic", "bold", "url('myfont.ttf')");
        css.addRule("pre", "color: #d14", "font-family: MyFont");
        css.addRule("body", "padding: 0");
        markdownView.addStyleSheet(css);
        markdownView.addStyleSheet(ExternalStyleSheet.fromAsset("github.css", null));
        markdownView.addStyleSheet(ExternalStyleSheet.fromAsset("github2.css", "screen and (min-width: 1281px"));
        return markdownView;
    }

}
