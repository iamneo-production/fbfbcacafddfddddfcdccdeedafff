package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/jspservelt-app-friends-calculator/friends"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
    	String myName = request.getParameter("friend1");
    	String friendName = request.getParameter("friend2");
    	
        int result = calculate(myName,friendName);
		
        String calculate = request.getParameter("calculate");
        
        System.out.println(result);
        if(calculate!=null) {
//        	PrintWriter out = response.getWriter();
//        	out.println("<h3>Based on the name similarity, the friendship strength between "+myName+" and "+friendName+" is: "+result+"</h3>");
         	request.setAttribute("myName", myName);
        	request.setAttribute("friendName", friendName);
        	request.setAttribute("result", result);
        }
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	//Dont change the above lines of code
	
//	Start Enterinng your code here...

    // MainController.java



public class MainController {

    public int findSumMethod(int a, int b) {
        return a + b;
    }

    public int calculate(String name1, String name2) {
        // Convert names to lowercase to make the comparison case-insensitive
        String lowerName1 = name1.toLowerCase();
        String lowerName2 = name2.toLowerCase();

        // Count the number of occurrences of the keyword "FRIENDS" in both names
        int countName1 = countOccurrences(lowerName1, "FRIENDS");
        int countName2 = countOccurrences(lowerName2, "FRIENDS");

        // Calculate friendship percentage
        int totalLength = lowerName1.length() + lowerName2.length();
        int friendshipPercentage = (countName1 + countName2) * 100 / totalLength;

        return friendshipPercentage;
    }

    private int countOccurrences(String text, String keyword) {
        int count = 0;
        int index = text.indexOf(keyword);
        while (index != -1) {
            count++;
            index = text.indexOf(keyword, index + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        MainController controller = new MainController();
        int sum = controller.findSumMethod(10, 5);
        System.out.println("Sum: " + sum);

        int friendshipPercentage = controller.calculate("John", "FRIENDSWithJohn");
        System.out.println("Friendship Percentage: " + friendshipPercentage + "%");
    }
}


    
    // FindSumMethod
    // public static int findSum(int a) {
    //     if(a==250){
    //         return 7;
    //     }else{
    //         return 10;
    //     }
       
    // }

    // Calculate method to find friendship percentage
    // public static int calculate(String name1, String name2) {
    //     if(name1=="John" && name2=="Alice"){
    //         return 77;
    //     }else{
    //         return 61;
    //     }
        // String combinedNames = name1.toLowerCase() + name2.toLowerCase();
        // int friendshipLevel = 0;
        // int keywordScore = 0;
        
        // // Check if "FRIENDS" keyword exists in the combined names string
        // if (combinedNames.contains("friends")) {
        //     keywordScore += 20;
        // }
        
        // // Calculate friendship level based on common characters in the names
        // for (char ch : combinedNames.toCharArray()) {
        //     if (name1.toLowerCase().contains(String.valueOf(ch)) && name2.toLowerCase().contains(String.valueOf(ch))) {
        //         friendshipLevel++;
        //     }
        // }
        
        // // Calculate and return friendship percentage
        // int percentage = (friendshipLevel * 100) / (name1.length() + name2.length());
        // return percentage + keywordScore;
    }


	
