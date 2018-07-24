package test;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import static javax.ws.rs.client.Entity.json;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;
import static javax.ws.rs.client.Entity.json;
import static org.glassfish.grizzly.http.util.DataChunk.Type.String;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.JSONStringer;




public class word {

    private static java.lang.String jsonString;
  
        
         
public static String getword (String message, Model model) throws MalformedURLException, IOException{
    
        URL url  = new URL("https://api-platform.systran.net/translation/text/translate?input="+message+"&source=auto&target=ru&withSource=false&withAnnotations=false&backTranslation=false&encoding=utf-8&key=d89105b2-a255-45f8-ae5a-fc9fef7d0f13");

    Scanner in = new Scanner((InputStream)url.getContent());
    String result = "";
    while(in.hasNext()){
    result += in.nextLine();
       
    
    }
   
    
    JSONObject object = new JSONObject(result);
    //model.setOutput(object.getString("output"));       
    
   
   JSONArray getArray = object.getJSONArray("outputs");
   for (  int i = 0; i < getArray.length(); i++) {
   JSONObject obj = getArray.getJSONObject(i);
    model.setOutput((String) obj.get("output"));
   }   


// model.setTr((List)obj.get("tr"));
   //}
    /* class Def{
    public String text;
    public String pos;
    public String ts;
   public List <tran> tr ;
   }

 Gson g = new Gson();
 Def def = g.fromJson(jsonString, Def.class);
 for (Def  : def.tr) {
  return 
 }*/
    


 

    

   





//JSONArray getMassiv = object.getJSONArray  ("tr" );
   //for (  int i = 0; i < getMassiv.length(); i++) {
    //JSONObject obj = getArray.getJSONObject(i);
   // model.setText((String)obj.get("text"));
   //}
   
   
   
   
   
   
   
   
   return  "translate: " + model.getOutput(); //"word: " +  model.getText() + "/n"+
          //"  translate "  + model.getTr();

   
   
   
   
   

   
   }
   
}
        


