package cn.carbs.android.maxheightview.example.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import cn.carbs.android.maxheightview.R;


public class DialogMaxHeight extends Dialog {

	public DialogMaxHeight(Context context) {
		super(context, R.style.dialog);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);
		initWindow();
	}

	public void initWindow() {
		Window win = this.getWindow();
		win.getDecorView().setPadding(0, 0, 0, 0);

		WindowManager.LayoutParams lp = win.getAttributes();
		lp.width = WindowManager.LayoutParams.MATCH_PARENT;
		lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
		lp.gravity = Gravity.BOTTOM;

		win.setAttributes(lp);

		this.setCanceledOnTouchOutside(true);
	}

}
