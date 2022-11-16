

public class Hmwk2 {
	

	



	static class Node {

	    private char data;
	    private Node next;

	    public Node() {
	        this('#', null);
	    }

	    public Node(char d) {
	        data = d;
	    }

	    public Node(char d, Node n) {
	        data = d;
	        next = n;
	    }
	    public Node(int d, Node n) {
	        data = 0;
	        next = n;
	    }

	    public void setData(char newData) {
	        data = newData;
	    }
	    public void setData(int newData) {
	        data = (char) newData;
	    }
	    public void setNext(Node newNext) {
	        next = newNext;
	    }

	    public char getData() {
	        return data;
	    }

	    public Node getNext() {
	        return next;
	    }

	    public void displayNode() {
	        System.out.print(data);
	    }
	}

	
	public static  class LLStackADT{
		
		 private  Node top;
		 private  int size;

		
		public LLStackADT() {
			top = null;
			size = 0;
		}
		
		public boolean empty() {
		return(top == null);
		}
		
		public void push(char c) {
			Node newNode = new Node();
		    newNode.setData(c);
			newNode.setNext(top);
			size++;
			top = newNode;
		}
		 public void push(int c) {
		    Node newNode = new Node();
		    newNode.setData(c);
		    newNode.setNext(top);
		    size++;
		    top = newNode;
		    }
		
		public char pop() {
			char i;
			i = top.getData();
			top = top.getNext();
			size--;
			return i;
			}
		
		public int size() {
			return size;
		}
		public char onTop() {
			
		char i = pop();
		push(i);
		return i;
		}
	}
	

 
    
	
	public static class LLQueueADT  {

	    private int size;
	    private Node front;
	    private Node rear;

	    public LLQueueADT() {
	        size = 0;
	        front = null;
	        rear = null;
	    }

	    public boolean empty() {
	        return (size == 0);
	    }

	    public void enqueue(char c) {
	        Node newNodeQ = new Node();
	        newNodeQ.setData(c);
	        newNodeQ.setNext(null);
	        if (this.empty())
	            front = newNodeQ;
	        else
	            rear.setNext(newNodeQ);
	        rear = newNodeQ;
	        size++;
	    }

	    public char dequeue() {
	        char i;
	        i = front.getData();
	        front = front.getNext();
	        size--;
	        if (this.empty())
	            rear = null;
	        return i;
	    }

	    public char front() {
	        return front.getData();
	    }

	    public int size() {
	        return size;
	    }
	}
	
	class parsingExpression{

	    // Initialize the variable needed for the program.
	    private static LLQueueADT inFixQ;
	    private static  LLQueueADT postFixQ;
	    private static LLStackADT operatorStack;
	    private static LLStackADT valueStack;
	
	    // stackPriority method.
	    
	 // The main method that converts
	    // given infix expression
	    // to postfix expression.
	    public static int stackPriority(char c) {
	        switch (c) {
	            case ')':
	            case '#':
	                return 0;
	            case '+':
	            case '-':
	                return 2;
	            case '/':
	            case '*':
	                return 3;
	            case '(':
	                return 1;
	        }
	        return -1;
	    }
	    
	    public static void infixTopostFix(String expression){
	         inFixQ = new LLQueueADT();
	         postFixQ = new LLQueueADT();
	         operatorStack = new LLStackADT();
	        operatorStack.push('#');
	        
	        for (int i = 0; i < expression.length(); i++){
	            if(expression.charAt(i) != ' ')
	                inFixQ.enqueue(expression.charAt(i));
	        }
	        while(!inFixQ.empty())
	        {
	            int x = inFixQ.dequeue();
	            char s= (char)x;
	            if(s =='(')
	                
	               operatorStack.push(s);
	            	

	            else if(Character.isLetterOrDigit(s))
	            {
	                postFixQ.enqueue(s);
	            }
	            else if(s == ')')
	            {
	                while(!operatorStack.empty() && ((char)operatorStack.onTop())!='(')
	                {
	                	
	                    postFixQ.enqueue(operatorStack.pop());
	                }
	                if(operatorStack.onTop() == '(') {
	                	operatorStack.pop();
	                	postFixQ.enqueue(operatorStack.pop());
	                }
	            }
	            else
	            {
	                
	            	int priority1 = stackPriority(s);
	                int priority2 = stackPriority(operatorStack.onTop());
	                while(priority1 < priority2)
	                {
	                	
	                    postFixQ.enqueue(operatorStack.pop());
	                    priority2 = stackPriority(operatorStack.onTop());
	                }
	                operatorStack.push(s);
	            }
	           
	        }
	       while(operatorStack.onTop() != '#') {
            	postFixQ.enqueue(operatorStack.pop());
            }
	    }
	    
	    
	    
	   
	    
	    
	    static boolean isOperator(char ch)
	        {
	            if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
	            return true;
	            }
	            return false;
	        }
	       
	        static int evaluatePostfix1(String exp)
	        {
	        	valueStack = new LLStackADT();
	        	 
	        	int size = exp.length();
	        	for(int index=0;index<size;index++)
	        	 
	        	{
	        	 
	        	if(isOperator(exp.charAt(index)
	        	)
	        	)
	        	 
	        	{
	        	 
	        	int op1 = valueStack.pop();
	        	int op2 = valueStack.pop();

	             
	              switch(exp.charAt(index))
	              {
	                  case '+': valueStack.push(op2 + op1);
	                            break;
	                            
	                  case '-': valueStack.push(op2 - op1);
	                            break;
	                            
	                  case '*': valueStack.push(op2 * op1);
	                            break;
	                      
	                  case '/': valueStack.push(op2 / op1);
	                            break;
	                          
	              }
	              
	              }
	        	else
	        		 
	        	{
	        	 
	        	 
	        	int operand = exp.charAt(index) - '0'; //convert to integer
	        	 
	        	valueStack.push(operand);
	        	 
	        	}
	        	 

	              
	              }
	            
	            
	            // Stack at End will contain result.
	            return(valueStack.pop());
	    }
	
	

	

	}
	
	public static void main(String[] args){

		String infixExpression = "30*4+(4/2)";
       System.out.println ("=======================================");
       System.out.println ("infix expression: " + infixExpression);
       
      
       
       
       System.out.print("Postfix expression: ");
      parsingExpression.infixTopostFix(infixExpression);
       
       while(!parsingExpression.postFixQ.empty())
       {
           System.out.print (parsingExpression.postFixQ.dequeue() + " ");
          
       } 

       
      
	  System.out.println();
      System.out.print ("Postfix evaluation () : ");
      System.out.println (parsingExpression.evaluatePostfix1("34*42/+2/"));      
	   
       
       
	
   }



	



}

