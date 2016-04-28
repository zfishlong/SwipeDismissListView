package com.ilmare.swipedismisslistview.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


import com.ilmare.swipedismisslistview.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public  class FileItemHolder {

        private View view;
        @InjectView(R.id.iv_icon)
        ImageView ivIcon;
        @InjectView(R.id.tv_name)
        TextView tvName;
        @InjectView(R.id.tv_time)
        TextView tvTime;
        @InjectView(R.id.tv_size)
        TextView tvSize;
        @InjectView(R.id.cb_checkbox)
        CheckBox cbCheckbox;
        @InjectView(R.id.iv_option)
        ImageView ivOption;

        public FileItemHolder(LayoutInflater inflater, ViewGroup parent) {
            this(inflater.inflate(R.layout.file_item, parent, false));
        }

        public View getView() {
            return view;
        }

        public void setView(View view) {
            this.view = view;
        }

        public FileItemHolder(View view) {
            this.view=view;
            ButterKnife.inject(this, view);
        }

        public TextView getTvTime() {
            return tvTime;
        }

        public TextView getTvName() {
            return tvName;
        }

        public TextView getTvSize() {
            return tvSize;
        }

        public ImageView getIvIcon() {
            return ivIcon;
        }

        public CheckBox getCbCheckbox() {
            return cbCheckbox;
        }

        public ImageView getIvOption() {
            return ivOption;
        }
    }