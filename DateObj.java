package hw4;

public class DateObj {
    
	public int day;
    public int month;
    public int year;
    private int[] monthLengths = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public DateObj(int year, int month, int day) {
    	this.year = year;
    	this.month = month;
    	this.day = day;
    	validate();
	}

    public DateObj nextDate() {
		// TODO Auto-generated method stub
		var newDate = new DateObj(this.year, this.month, this.day);
		newDate.nextDay();
		return newDate;
	}
    
	@Override
	public String toString() {
		return String.format("%d-%d-%d", year, month, day);
	}

    private void validate() {
        // TODO: throw an exception if the current values of year, month and day do not
        //       make a valid date
    	
		if(month < 1) {
			throw new IllegalArgumentException();
		} 
		
		if(month > 12) {
			throw new IllegalArgumentException();
		} 
    	

    	if(day < 1) {
			throw new IllegalArgumentException();
		}

		
		if (month == 2) {
			if (isLeapYear()) {
				if (day > 29) {
					throw new IllegalArgumentException();			
				}
			}
			
		}
		else {
			if (day > monthLengths[month-1])   {
				throw new IllegalArgumentException();		
			}
		}
	
		

		
    }
    
	// ------------------------------------ //
	
	public boolean isLeapYear() {
		return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
	}
	
	public void nextYear() {
		year++;
	}
	
	public void nextMonth() {
	    if (month == 12) {
	        month = 1;
	        nextYear();
	    }
	    else {
	     month++;
	    }
	}
	
	public void nextDay() {
		  if (month == 2) {
			     if (!isLeapYear() && day == 28){
			        day = 1;
			        nextMonth();
			     } else if (day == 29) {
			        day = 1;
			        nextMonth();
			     } else {
			        day++;
			     }
		   } 
		    else {
			     if (day == monthLengths[month-1]) {
			        day = 1;
			        nextMonth();
			     } else {
			        day++;
			     }
			  }
	}
	
}
