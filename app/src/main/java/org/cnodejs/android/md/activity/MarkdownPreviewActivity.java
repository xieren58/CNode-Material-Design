package org.cnodejs.android.md.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.cnodejs.android.md.R;
import org.cnodejs.android.md.listener.NavigationFinishClickListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import us.feras.mdv.MarkdownView;

public class MarkdownPreviewActivity extends AppCompatActivity {

    @Bind(R.id.markdown_preview_toolbar)
    protected Toolbar toolbar;

    @Bind(R.id.markdown_preview_makrdown_view)
    protected MarkdownView markdownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markdown_preview);
        ButterKnife.bind(this);

        toolbar.setNavigationOnClickListener(new NavigationFinishClickListener(this));

        markdownView.loadMarkdown(getIntent().getStringExtra("markdownText"));
    }

    @Override
    public void onBackPressed() {
        if (markdownView.canGoBack()) {
            markdownView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
