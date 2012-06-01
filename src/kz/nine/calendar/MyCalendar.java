package kz.nine.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

public class MyCalendar extends Activity {
	GregorianCalendar gc;
	LinearLayout lay;
	int month,day;
	String weekdays[] = {"пн","вт","ср","чт","пт","сб","вс"};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        gc = new GregorianCalendar();
        month = gc.get(Calendar.MONTH)+1;
        day = gc.get(Calendar.DAY_OF_YEAR);
        
        TableRow tr = (TableRow)findViewById(R.id.row0);
        lay = new LinearLayout(getApplicationContext());
        for (int i = 0; i<=6; i++){
        	LinearLayout l = new LinearLayout(lay.getContext());
        	LayoutParams lp = new LayoutParams(63,LayoutParams.WRAP_CONTENT);
        	l.setPadding(10, 10, 10, 10);
        	lp.setMargins(3, 0, 3, 3);
        	l.setLayoutParams(lp);
        	l.setBackgroundColor(Color.WHITE);
        	l.getBackground().setAlpha(125);
        	TextView text = new TextView(lay.getContext());
        	text.setText(weekdays[i]);
        	text.setTextSize(23);
        	text.setTextColor(Color.WHITE);
         	l.addView(text);        	
        	lay.addView(l);
        }
        
        tr.addView(lay);
        
        System.out.println("Calendar Day Of Year = "+gc.get(Calendar.DAY_OF_YEAR));
        
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
            	LinearLayout l = new LinearLayout(lay.getContext());
            	LayoutParams lp = new LayoutParams(63,LayoutParams.WRAP_CONTENT);
            	LayoutParams lpt = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
            	l.setPadding(13, 13, 13, 13);
            	lp.setMargins(3, 3, 3, 3);
            	l.setLayoutParams(lp);
            	l.setBackgroundColor(Color.WHITE);
            	TextView text = new TextView(lay.getContext());
            	String t=""+gc.get(Calendar.DAY_OF_MONTH);
            	text.setText(t);
            	text.setTextSize(21);
            	text.setTextColor(Color.WHITE);
            	text.setLayoutParams(lpt);
            	text.setGravity(Gravity.CENTER);
            	l.getBackground().setAlpha(88);
//            	if ((gc.get(Calendar.DAY_OF_YEAR)!=day)&&(gc.get(Calendar.MONTH)!=month)){
//            	l.getBackground().setAlpha(88);} else {l.getBackground().setAlpha(185);}
            	
            	if (gc.get(Calendar.MONTH)+1!=month){
            		text.setTextColor(Color.GRAY);
            	}
            	if (gc.get(Calendar.DAY_OF_YEAR)==day){
            		l.getBackground().setAlpha(185);
            	}
             	l.addView(text);        	
            	lay.addView(l);
            	gc.add(Calendar.DAY_OF_YEAR, 1);
        	}
        	tr.addView(lay);
        }
    }
}