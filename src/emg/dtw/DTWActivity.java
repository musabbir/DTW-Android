package emg.dtw;


import emg.backend.DataProtocol;
import emg.backend.ITransformListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Vector;


public class DTWActivity extends Activity implements  ITransformListener{
    /** Called when the activity is first created. */
	private static final String TAG = "Libsvm";
	ArrayList<Double> btdatacontainer1;
	ArrayList<Double> btdatacontainer2;
    String DEVICE_ADDRESS = "00:06:66:04:9B:21";
	byte channels = 1;//each bit is a channel (bits1-6)
    DataProtocol dataProtocol;
    
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button trainButton = (Button)findViewById(R.id.button1);
        Button classifyButton = (Button)findViewById(R.id.button2);
        btdatacontainer1 = new ArrayList();
        btdatacontainer2 = new ArrayList();
        
        this.dataProtocol = new DataProtocol(this, (ITransformListener) this, channels, DEVICE_ADDRESS);
        this.dataProtocol.Start();
        
        
        //this will start the training sequence.
        trainButton.setOnClickListener(new View.OnClickListener() {			
			public void onClick(View v) {
				//train();				
			}
		});
        //start classifying on the input from bluetooth
        classifyButton.setOnClickListener(new View.OnClickListener() {			
			public void onClick(View v) {
				//classify();				
			}
		});
    }
    
    @Override
    public void onDestroy()
    {
    	this.dataProtocol.StopAndDisconnect();
    }
    //reading training data from blue-tooth
   
    public void addData(int[] data) {
    	
    	for(int i=0;i<data.length;i++){
    		btdatacontainer1.add((double) data[i]);
    	}
    	
	}
    public void train(){
    	
    }
    //	
    public void makemodel(){
    	
    }
    	
    	
    
    	
    	
    }
    
    
    
    
    

    