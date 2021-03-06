package com.iti.jets.carpoolingV1.synccontactsactivity;

import java.util.ArrayList;

import com.iti.jets.carpoolingV1.R;
import com.iti.jets.carpoolingV1.common.User;
import com.iti.jets.carpoolingV1.retrieveallcircles.AllCirclesListActivity;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;


/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class SyncContactsCustomArrayAdapter extends BaseAdapter  implements OnClickListener{
          
         /*********** Declare Used Variables *********/
         private Activity activity;
         private ArrayList data;
         private static LayoutInflater inflater=null;
         public Resources res;
         private CheckBox checkBox ;
         User UserValues=null;
         User UserCheckedValues=null;
         int i=0;
         public SyncContactsCustomArrayAdapter()
         {
        	 
         }
          
         /*************  CustomAdapter Constructor *****************/
         public SyncContactsCustomArrayAdapter(Activity a, ArrayList d,Resources resLocal) {
              
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
              
             public TextView nameTxt;
             public TextView phoneTxt;
             public ImageView userImage;
			 public CheckBox checkBox;
			
      
         }
      
         /****** Depends upon data size called for each row , Create each ListView row *****/
         public View getView(final int position, View convertView, ViewGroup parent) {
              
             View vi = convertView;
             final ViewHolder  holder;
              
             if(convertView==null){
                  
                 /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                 vi = inflater.inflate(R.layout.activity_sync_contacts, null);
                  
                 /****** View Holder Object to contain tabitem.xml file elements ******/
 
                 holder = new ViewHolder();
                 holder.nameTxt = (TextView) vi.findViewById(R.id.nameTxt);
                 holder.phoneTxt=(TextView)vi.findViewById(R.id.phoneTxt);
                 holder.userImage=(ImageView)vi.findViewById(R.id.userImage);
                 holder.checkBox=(CheckBox)vi.findViewById(R.id.chkbox);
                  
                /************  Set holder with LayoutInflater ************/
                 vi.setTag( holder );
             }
             else 
                 holder=(ViewHolder)vi.getTag();
              
             if(data.size()<=0)
             {
                 holder.nameTxt.setText("No Data");
                  
             }
             else
             {
                 /***** Get each Model object from Arraylist ********/
                 UserValues=null;
                 UserValues = ( User ) data.get( position );
                  
                 /************  Set Model values in Holder elements ***********/
 
                  holder.nameTxt.setText( UserValues.getName() );
                  holder.phoneTxt.setText(UserValues.getPhone());
                  if(UserValues.getImageURL().equals("EMPTY"))
                  {
                	  holder.userImage.setImageResource(
                              res.getIdentifier(
                              "com.androidexample.customlistview:drawable/photo"
                              ,null,null));
                  }
                 
                  
                  /******** Set Item Click Listner for LayoutInflater for each row *******/
                  
                  vi.setOnClickListener(new OnItemClickListener( position ));
                  holder.checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
               	   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               		UserCheckedValues = (User)data.get(position);
               		UserCheckedValues.setIsSelected(isChecked);
               	   }
               	  });
             }
            
             return vi;
             
             
         }

		@Override
		public void onClick(View v) {
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

       
              SyncContactsActivity SyncContactsActObj = (SyncContactsActivity)activity;

             /****  Call  onItemClick Method inside CustomListViewAndroidExample Class ( See Below )****/
             
              SyncContactsActObj.onItemClick(mPosition);
            }               
        }   
        
       
	
}