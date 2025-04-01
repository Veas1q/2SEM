package org.example;

public abstract class Transport {
    protected String number;
    protected String routeNumber;
    protected String  workTimeBegin;
    protected String workTimeEnd;

    public Transport() {};

    public Transport(String number, String routeNumber, String workTimeBegin, String workTimeEnd) {
        this.number = number;
        this.routeNumber = routeNumber;
        this.workTimeBegin = workTimeBegin;
        this.workTimeEnd = workTimeEnd;
    }

    public int getIntRouteNumber(){
        int s = Integer.parseInt(routeNumber);
        return s;
    }

    public int getIntNumber() {
        int n = Integer.parseInt(number);
        return n;
    }

    public int getIntWorkTimeBegin(){
        int s = 60 * Integer.parseInt("" + workTimeBegin.charAt(0) + workTimeBegin.charAt(1)) + workTimeBegin.charAt(3) + workTimeBegin.charAt(4);
        return s;
    }

    public int getIntWorkTimeEnd(){
        int s = 60 * Integer.parseInt("" + workTimeEnd.charAt(0) + workTimeEnd.charAt(1)) + workTimeEnd.charAt(3) + workTimeEnd.charAt(4);

        return s;
    }

    public String getNumber() {
        return number;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public String getWorkTimeBegin() {
        return workTimeBegin;
    }

    public String getWorkTimeEnd() {
        return workTimeEnd;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public void setWorkTimeBegin(String workTimeBegin) {
        this.workTimeBegin = workTimeBegin;
    }

    public void setWorkTimeEnd(String workTimeEnd) {
        this.workTimeEnd = workTimeEnd;
    }
}

