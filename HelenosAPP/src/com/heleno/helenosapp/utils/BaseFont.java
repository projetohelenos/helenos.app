package com.heleno.helenosapp.utils;

import android.content.Context;
import android.graphics.Typeface;

public class BaseFont {

	public static Typeface bold(Context context){
		return  Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");
	}

	public static Typeface light(Context context){
		return  Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
	}
	
	public static Typeface medium(Context context){
		return  Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");
	}
	
}
