import java.util.*; 
  
public class Serve { 
    public static void main(String[] args){ 
        Scanner in = new Scanner(System.in); 
        
        PriorityQueue<Student> pq = new PriorityQueue<Student>(5, new StudentComparator());
        int n = in.nextInt();
        for(int i=0;i<n;i++) {
        	
        	String s = in.next();
        	if(s.equals("SERVED") && !pq.isEmpty()) {
        		pq.poll();
        		
        	}
        	else {
        		String name = in.next();
        		double cgpa = in.nextDouble();
        		int token = in.nextInt();
        		Student st = new Student(name,cgpa,token);
        		pq.add(st);
        		
        	}
        	
        }
        if(pq.isEmpty()) {
        	System.out.println("EMPTY");
        }
        else {
        	while(!pq.isEmpty()) {
        	System.out.println(pq.poll().name);
        	}
        }       
                
        }  
    }   
  
class StudentComparator implements Comparator<Student>{ 
              
            public int compare(Student s1, Student s2) { 
                if (s1.cgpa < s2.cgpa) 
                    return 1; 
                else if (s1.cgpa > s2.cgpa) 
                    return -1;
                else {
                	int t = s1.name.compareTo(s2.name);
                	if(t!=0) {
                		return t;
                	}
                	else {
                		return s2.token - s1.token;
                	}
                }         
             }
        } 
  
class Student { 
    public String name; 
    public double cgpa;
    public int token;
          
    public Student(String name, double cgpa, int token) { 
      
        this.name = name; 
        this.cgpa = cgpa; 
        this.token = token;
    } 
} 