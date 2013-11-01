import java.net.MalformedURLException;
import java.util.LinkedList;
import jcifs.UniAddress;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbSession;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
public class ListFiles extends Activity {
  
 private UniAddress domain; 
 private NtlmPasswordAuthentication authentication;
 private String ipaddress, valueS, user, pass, getIP, url;
 private String[] files;
 private String[] shares;
 private Editable value;
 private TextView text1;
 //adds a menu item from the res/menu/menu.xml
 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
 MenuInflater inflater = getMenuInflater();
 inflater.inflate(R.menu.menu2, menu);
 return true;
 }
  
 //adds an action to the button click
 @Override
 public boolean onOptionsItemSelected(MenuItem item) {
 switch (item.getItemId()) {
 case R.id.item1:
  finish();
  break;
 }
 return true;
 }
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
         ipaddress = extras.getString("IPaddress");
         user = extras.getString("username");
         pass = extras.getString("password");
        }
         
        text1 = (TextView)findViewById(R.id.infoTV);
        if (ipaddress != null) {
        text1.setText(ipaddress + "\n");
        }
         
        Log.i("MyLanBrowser", user + " " + pass + " " + ipaddress);
             
        text1 = (TextView)findViewById(R.id.infoTV);
        text1.setText(ipaddress + "\n");
          
        //---------START SMB WORKS-------------------------
         url = "smb://" + ipaddress + "/";
  NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, user, pass);
  SmbFile dir = null;
  try {
   dir = new SmbFile(url, auth);
  } catch (MalformedURLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
   Log.i("MyLanBrowser", "Authenication problem");
  }
  try {
   for (SmbFile f : dir.listFiles()) {
    System.out.println(f.getName());
    shares = dir.list();
    }
  } catch (SmbException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
   Log.i("MyLanBrowser", "Directory listing problem");
  }
  //-------END SMB WORKS---------------------
   
  SmbFile server = null;
  try {
   server = new SmbFile("smb://" + ipaddress + "/");
  } catch (MalformedURLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  try {
   files = server.list();
  } catch (SmbException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
          ListView lv = (ListView)findViewById(R.id.listView1);
          String[] arr = {"Text One", "Text Two"};
          if (files != null) {
           lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , files ));
          } else if (files == null && shares != null) {
           lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , shares )); 
          }else if (files == null) {
           lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , arr ));
          }
    }
    public void login(String address, String username, String password) throws Exception 
 { 
  setDomain(UniAddress.getByName(address)); 
  setAuthentication(new NtlmPasswordAuthentication(address, username, password)); 
  SmbSession.logon(getDomain(), authentication); 
 }  
    public UniAddress getDomain() 
    { 
     return domain; 
    } 
    /** 
    * @param domain the domain to set 
    */
    public void setDomain(UniAddress domain) 
    { 
     this.domain = domain; 
    }    
    /** 
    * @return the authentication 
    */
    public NtlmPasswordAuthentication getAuthentication() 
    { 
     return authentication; 
    } 
    /** 
    * @param authentication the authentication to set 
    */
    public void setAuthentication(NtlmPasswordAuthentication authentication) 
    { 
     this.authentication = authentication; 
    }
    public LinkedList<String> getList(String path) throws Exception 
    { 
     LinkedList<String> fList = new LinkedList<String>(); 
     SmbFile f = new SmbFile(path,authentication); 
     SmbFile[] fArr = f.listFiles(); 
     for(int a = 0; a < fArr.length; a++) 
     { 
      fList.add(fArr[a].getName()); 
      System.out.println(fArr[a].getName()); 
     } 
     return fList; 
    }
     
}