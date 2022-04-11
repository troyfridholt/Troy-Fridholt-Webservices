package com.example.demo;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class overallController  implements ErrorController {
	private static gameBean game = new gameBean();
	private htmlFileReader htmlR = new htmlFileReader();
	
	@CrossOrigin
	@RequestMapping(
			value = "/",
			method = RequestMethod.GET,
			produces = MediaType.TEXT_HTML_VALUE)

	public String showDocFile() throws FileNotFoundException, IOException {
		return htmlR.readFile("templates/landingPage.html");
	}

	@CrossOrigin
	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, path = "/calc")
	public String calculator(int num1, int num2, char operation) {

        int result;

        switch (operation) {

        case '+':
            result = num1 + num2;
            System.out.println(num1 + " + " + num2 + " = " + result);
            return num1 + " + " + num2 + " = " + result;
            

        case '-':
            result = num1 - num2;
            System.out.println(num1 + " - " + num2 + " = " + result);
            return num1 + " - " + num2 + " = " + result;

        case '*':
            result = num1 * num2;
            System.out.println(num1 + " * " + num2 + " = " + result);
            return num1 + " * " + num2 + " = " + result;

        case '/':
            result = num1 / num2;
            System.out.println(num1 + " / " + num2 + " = " + result);
            return num1 + " / " + num2 + " = " + result;

        default:
            System.out.println("Error.");
            return "Error";
            
        }

    }

	@CrossOrigin
	@RequestMapping(method = { RequestMethod.POST }, path = "/rps")
	public static String rps(String userInput) {
		
		System.out.println(userInput);
		
		ArrayList<String> compInput = new ArrayList<String>();
		compInput.add("rock");
		compInput.add("paper");
		compInput.add("scissor");
		System.out.println(compInput.get(0));
		
            int index = (int)(Math.random() * compInput.size());
            String compchoice = compInput.get(index);
            System.out.println("Random Output is :" + compchoice);
        
		
		if(userInput.equals(compchoice)) {
			System.out.println("Tie");
			game.addResult("tie");
			return "tie";
		}else if(userInput.equals("rock") && compchoice.equals(compInput.get(2))) {
			System.out.println("you lose");
			game.addResult("loss");
			return "you lose";
		}else if(userInput.equals("rock") && compchoice.equals(compInput.get(1))) {
			System.out.println("you win");
			game.addResult("win");
			return "you win";
		}else if(userInput.equals("paper") && compchoice.equals(compInput.get(2))) {
			System.out.println("you win");
			game.addResult("win");
			return "you win";
		}else if(userInput.equals("paper") && compchoice.equals(compInput.get(0))) {
			System.out.println("you lose");
			game.addResult("loss");
			return "you lose";
		}
		else if(userInput.equals("scissor") && compchoice.equals(compInput.get(1))) {
			System.out.println("you win");
			game.addResult("win");
			return "you win";
		}
		else if(userInput.equals("scissor") && compchoice.equals(compInput.get(0))) {
			System.out.println("you lose");
			game.addResult("loss");
			return "you lose";
		}else {
			System.out.println("Error.");
			return "Error.";
		}
		
		
	}
	
	@RequestMapping(value = "/rps", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showMatches() { 
		String result = "";
	
		result += game.toJsonString() + ",";
		
		if (result.length() > 2){
			result = result.substring(0, result.length() - 1);
		}
		
		result = "{ \"Games\":  [" + result + "] }";
		
		return result;
		
	}

	@CrossOrigin
	@RequestMapping(value = "/img", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public void getImage(HttpServletResponse response) throws IOException {
		
		var imgFile = new ClassPathResource("templates/img.jpg");
		if (Math.random() < 0.5) {
			imgFile = new ClassPathResource("templates/img2.jpg");
		}

		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}
	
	@CrossOrigin
	@RequestMapping(path = "/csv", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public String showCsv() throws IOException { 
		
			overallService svc = new overallService();
			svc.readFile("templates/sample.csv");
			
			return svc.toJson();
		
		}
	
	@RequestMapping(value = "/error", produces = MediaType.TEXT_HTML_VALUE)
	public String error() {
		return "Not a valid URL, go back to root and read the provided Documentation";
	}
	
}
