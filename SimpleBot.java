/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
// java.util.logging.Level;
//import java.util.logging.Logger;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
 
public class SimpleBot extends TelegramLongPollingBot {
 
	public static void main(String[] args) {
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new SimpleBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
 
        
   
    
        
        
	@Override
	public String getBotUsername() {
		return "Newslovarbot";
	}
 
	@Override
	public String getBotToken() {
		return "609762693:AAFg2xzR3DVjIoehwHSesaQtEmtujiqfPfc";
	}
 
	@Override
	public void onUpdateReceived(Update update) {
	    Model model = new Model();	
            Message message = update.getMessage();
		if (message != null && message.hasText()) {
		  switch (message.getText()){	
                      case "/help":
			   sendMsg(message, "Чем я могу помочь?");	
                      break;    
                      case "/setting":
                          sendMsg(message,"Что будем настраивать");
                        break;                       
                      default:
                          try {
                              sendMsg(message ,word.getword (message.getText(), model));
                          } catch (IOException ex) {
                      sendMsg(message, "Слово не найдено");
                  }
			
		}
	}
        }
	/* public SimpleBot() {
        hm = new HashMap<>();
        ApiContextInitializer.init();
        loadDictionaryIntoHashMap();
    }*/
        
        
        
      
        
        
        /*void loadDictionaryIntoHashMap() {
         String fullFilePath ="/Users/Ильяс/Documents/NetBeansProjects/DictionaryApp2/src/Dictionary1.csv"; 
         String line;
         try {
             BufferedReader br = new BufferedReader(new FileReader(fullFilePath));
             while ((line = br.readLine()) != null) {
             String parts[] = line.split("===");
             hm.put(parts[0].trim().toLowerCase(),parts[1].trim());
             hm.put(parts[1].trim().toLowerCase(),parts[0].trim());
             }
    } catch (IOException ex) {
      ex.printStackTrace();  
    }        
              } 
        
        private HashMap<String, String> hm;
        */
        
        
        
        
        
        
        private void sendMsg(Message message, String text) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(message.getChatId().toString());
		sendMessage.setReplyToMessageId(message.getMessageId());
		sendMessage.setText(text);
                
                try {
                    
                    setButtons(sendMessage); 			
                    sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
                }
        }       
                        
                public void setButtons(SendMessage sendMessage) {
		ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
		sendMessage.setReplyMarkup(replyKeyboardMarkup);
		replyKeyboardMarkup.setSelective(true);
		replyKeyboardMarkup.setResizeKeyboard(true);
		replyKeyboardMarkup.setOneTimeKeyboard(false);
		
		List<KeyboardRow> keyboardRowList = new ArrayList<>();
		KeyboardRow keyboardFirstRow = new KeyboardRow();
		keyboardFirstRow.add(new KeyboardButton("/help"));
		//String word = KeyBoardButton.getText().trim().toLowerCase();
                keyboardFirstRow.add(new KeyboardButton("/game"));
		
		keyboardRowList.add(keyboardFirstRow);
		replyKeyboardMarkup.setKeyboard(keyboardRowList);

	

                
                
                
                
                
                }
	}
 


