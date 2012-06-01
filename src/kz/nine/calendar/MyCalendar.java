package kz.nine.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

public class MyCalendar extends Activity {
	GregorianCalendar gc;
	LinearLayout lay;
	int month,day;
	String weekdays[] = {"пн","вт","ср","чт","пт","сб","вс"},
			monthe[]={"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октыбрь","Ноябрь","Декабрь"};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        
        gc = new GregorianCalendar();
        month = gc.get(Calendar.MONTH);
        
        Button b = (Button)findViewById(R.id.bmonth);
        b.setBackgroundColor(Color.TRANSPARENT);
        b.setTextColor(Color.WHITE);
        b.setTextSize(24);
        b.setText(monthe[month]+" "+gc.get(Calendar.YEAR));
        
        
        day = gc.get(Calendar.DAY_OF_YEAR);
        
      //  gc.get(Calendar.)
        
        TableRow tr = (TableRow)findViewById(R.id.row0);
        lay = new LinearLayout(getApplicationContext());
        for (int i = 0; i<=6; i++){
        	LinearLayout l = new LinearLayout(lay.getContext());
        	LayoutParams lp = new LayoutParams(63,LayoutParams.WRAP_CONTENT);
        	l.setBackgroundDrawable(getApplicationContext().getResources().getDrawable(R.drawable.myborder));
        	l.setPadding(10, 10, 10, 10);
        	lp.setMargins(3, 0, 3, 3);
        	l.setLayoutParams(lp);
        	//l.setBackgroundColor(Color.LTGRAY);
        	l.getBackground().setAlpha(125);
        	TextView text = new TextView(lay.getContext());
        	LayoutParams lpt = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
        	text.setText(weekdays[i]);
        	text.setTextSize(23);
        	text.setTextColor(Color.WHITE);
        	text.setGravity(Gravity.CENTER);
        	text.setLayoutParams(lpt);
         	l.addView(text);        	
        	lay.addView(l);
        }
        
        tr.addView(lay);
        
        System.out.println("Calendar Day Of Year = "+gc.get(Calendar.DAY_OF_YEAR));
        
        gc.set(Calendar.DAY_OF_MONTH, 1);
        if (gc.get(Calendar.DAY_OF_WEEK)!=2){
        	gc.set(Calendar.DAY_OF_YEAR, gc.get(Calendar.DAY_OF_YEAR)-gc.get(Calendar.DAY_OF_WEEK)+2);
        }
        
        System.out.println("Calendar Day Of Year = "+gc.get(Calendar.DAY_OF_YEAR));
        
        for (int i=1; i<=6; i++){
        	switch (i){
        	case 1 : tr = (TableRow)findViewById(R.id.row1);
        	break;
        	case 2 : tr = (TableRow)findViewById(R.id.row2);
        	break;
        	case 3 : tr = (TableRow)findViewById(R.id.row3);
        	break;
        	case 4 : tr = (TableRow)findViewById(R.id.row4);
        	break;
        	case 5 : tr = (TableRow)findViewById(R.id.row5);
        	break;
        	case 6 : tr = (TableRow)findViewById(R.id.row6);
        	break;
        	}
        	
        	lay = new LinearLayout(getApplicationContext());
        	
        	for (int j=1; j<=7; j++){
        		//Button ib = new Button(lay.getContext());
            	LinearLayout l = new LinearLayout(lay.getContext());
            	LayoutParams lp = new LayoutParams(63,LayoutParams.WRAP_CONTENT);
            	LayoutParams lpt = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
            	lp.setMargins(3, 3, 3, 3);
            	l.setLayoutParams(lp);
            	l.setBackgroundColor(Color.GRAY);
            	TextView text = new TextView(lay.getContext());
            	String t=""+gc.get(Calendar.DAY_OF_MONTH);
            	text.setText(t);
            	text.setTextSize(21);
            	text.setTextColor(Color.LTGRAY);
            	text.setLayoutParams(lpt);
            	text.setGravity(Gravity.CENTER);
            	l.getBackground().setAlpha(88);
            	
            	if (gc.get(Calendar.MONTH)!=month){
            		text.setTextColor(Color.DKGRAY);
            	}
            	if (gc.get(Calendar.DAY_OF_YEAR)==day){
            		text.setTextColor(Color.WHITE);
            		l.setBackgroundDrawable(getApplicationContext().getResources().getDrawable(R.drawable.myborder));
            		text.setTypeface(null, Typeface.BOLD);
            		l.getBackground().setAlpha(125);
            	}
            	l.setPadding(13, 13, 13, 13);
             	l.addView(text);       
             	l.setOnTouchListener(new OnTouchListener() {
					
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub
						
						switch (event.getAction()){
						case MotionEvent.ACTION_DOWN : {
							LinearLayout l = ((LinearLayout) v);
							l.setBackgroundColor(Color.WHITE);
							l.getBackground().setAlpha(150);
							System.out.println("ACTION_DOWN");
							}
						break;
						case MotionEvent.ACTION_UP : {
							LinearLayout l = ((LinearLayout) v);
							l.setBackgroundColor(Color.WHITE);
							l.getBackground().setAlpha(88);
							System.out.println("ACTION_UP");
						}
						case MotionEvent.ACTION_CANCEL : {
							LinearLayout l = ((LinearLayout) v);
							l.setBackgroundColor(Color.WHITE);
							l.getBackground().setAlpha(88);
							System.out.println("ACTION_CANCEL");}
						break;
						case MotionEvent.ACTION_MOVE : {
							System.out.println("ACTION_MOVE");}
						break;
						}
						return false;
					}
				});
            	lay.addView(l);
            	gc.add(Calendar.DAY_OF_YEAR, 1);
        	}
        	tr.addView(lay);
        }
    }
}