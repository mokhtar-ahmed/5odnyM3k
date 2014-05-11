package com.iti.jets.carpoolingV1.retrieveallcircles;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.iti.jets.carpoolingV1.R;
import com.iti.jets.carpoolingV1.common.Circle;



//********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/

public class CirclesCustomArrayAdapter extends BaseAdapter  implements OnClickListener{
          
         /*********** Declare Used Variables *********/
         private Activity activity;
         private ArrayList data;
         private static LayoutInflater inflater=null;
         public Resources res;
         Circle CircleValues=null;
         int i=0;
          
         /*************  CustomAdapter Constructor *****************/
         public CirclesCustomArrayAdapter(Activity a, ArrayList d,Resources resLocal) {
              
                /********** Take passed values **********/
                 activity = a;
                 data=d;
                 res = resLocal;
              
                 /***********  Layout inflator to call external xml layout () ***********/
                  inflater = ( LayoutInflater )activity.
                                              getSystemService(Context.LAYOUT_INFLATER_SERVICE);
              
         }
      
         /******** What is the size of Passed Arraylist Size ************/
         public int getCount() {
              
             if(data.size()<=0)
                 return 1;
             return data.size();
         }
      
         public Object getItem(int position) {
             return position;
         }
      
         public long getItemId(int position) {
             return position;
         }
          
         /********* Create a holder Class to contain inflated xml file elements *********/
         public static class ViewHolder{
              
             public TextView circleNameTxt;        
             public ImageView circleImage;
      
         }
      
         /****** Depends upon data size called for each row , Create each ListView row *****/
         public View getView(int position, View convertView, ViewGroup parent) {
              
             View vi = convertView;
             ViewHolder holder;
              
             if(convertView==null){
                  
                 /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                 vi = inflater.inflate(R.layout.customlist_circles, null);
                  
                 /****** View Holder Object to contain tabitem.xml file elements ******/
 
                 holder = new ViewHolder();
                 holder.circleNameTxt = (TextView) vi.findViewById(R.id.circleNameTxt);
                 holder.circleImage=(ImageView)vi.findViewById(R.id.circleImage);
                  
                /************  Set holder with LayoutInflater ************/
                 vi.setTag( holder );
             }
             else 
                 holder=(ViewHolder)vi.getTag();
              
             if(data.size()<=0)
             {
                 holder.circleNameTxt.setText("No Data");
                  
             }
             else
             {
                 /***** Get each Model object from Arraylist ********/
                 CircleValues=null;
                 CircleValues = ( Circle ) data.get( position );
                  
                 /************  Set Model values in Holder elements ***********/
 
                  holder.circleNameTxt.setText( CircleValues.getCircleName() );
                  
                  if (CircleValues.getCircleName().equals("Friends")) {
                	  holder.circleImage.setImageResource(R.drawable.p5);
                  } else if (CircleValues.getCircleName().equals("Family")) {
                	  holder.circleImage.setImageResource(R.drawable.p8);
                  } else if (CircleValues.getCircleName().equals("Work")) {
                	  holder.circleImage.setImageResource(R.drawable.p10);
                  }
                  else
                  {
                	  holder.circleImage.setImageResource(R.drawable.ic_people);
                  }
                  
                  /******** Set Item Click Listner for LayoutInflater for each row *******/
 
                  vi.setOnClickListener(new OnItemClickListener( position ));
             }
             return vi;
         }

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
		}

		/********* Called when Item click in ListView ************/
        private class OnItemClickListener  implements OnClickListener{           
            private int mPosition;
             
            OnItemClickListener(int position){
                 mPosition = position;
            }
             
            @Override
            public void onClick(View arg0) {

       
              AllCirclesListActivity AllCirclesActObj = (AllCirclesListActivity)activity;

             /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/

              AllCirclesActObj.onItemClick(mPosition);
            }               
        }   
        
          
}