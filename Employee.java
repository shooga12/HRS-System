
public class Employee
{
private String id ; 
private String jobTitle ; 
private String contractDate ; 
private String startTime ;
private String endTime ; 
private boolean hired ; 
private int frequency ; 

public Employee( String d , String job , String date , String sTime , String eTime , boolean h , int f)
{
id = d ;
jobTitle = job ;  
contractDate = date ; 
startTime = sTime; 
endTime = eTime ; 
hired = h ; 
frequency = f ; 
}

public int calculateDuration()
{
int sHr = Integer.parseInt(  startTime.substring( 0   ,  startTime.indexOf(':')));
int eHr = Integer.parseInt(  endTime.substring( 0   ,  endTime.indexOf(':')));
int duration = eHr - sHr ; 

if( duration == 0 ) 
duration = 1; 

return duration ; 


}
//---------------------------

public void updateFrequency()
{
 frequency++ ; 

}

//======================
public void displayInfo()
{
System.out.printf("|%-12s|%15s|%10s|%6s|%6s|%-4s|%-4d|\n",id , jobTitle , contractDate ,
                      startTime , endTime , (hired ?"yes" : "no")  ,frequency ) ; 

}


public String getId()
{
return id ; 
}

    public String getJobTitle() {
        return jobTitle;
    }

    public String getContractDate() {
        return contractDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public boolean getHired() {
        return hired;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setHired(boolean hired) {
        this.hired = hired;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }



} 
