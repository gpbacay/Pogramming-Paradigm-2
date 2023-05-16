public class Teacher extends Person
{
   private String rank, designation;
   
    //constructors
    public Teacher() {
        super();
        this.rank = "";
        this.designation = "";
    }
   
    public Teacher(String FName, String LName, String Identification, String Address, String Rank, String Designation) {
        super(FName, LName, Identification, Address);
        this.rank = rank;
        this.designation = designation;
    }
   
    //setters
    public void setRank(String rank) {
        this.rank = rank;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
   
    //getters
    public String getRank() {
        return rank;
    }
    public String getDesignation() {
        return designation;
    }
    
//    public String toString() {
//       String str;
//       str = super.toString();
//       return str + "Rank: " + rank + "\nDesignation: " + designation;
//    }
}
