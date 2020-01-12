package com.example.demo1;

public class ListCellData {
    /***ListView数据***/
    public ListCellData(int pic,String title,int speed,String instrument){
        this.pic=pic;
        this.title=title;
        this.speed=speed;
        this.instrument=instrument;
    }
    private int pic=0;
    private String title="无标题";
    private int speed=0;
    private String instrument="无乐器";
    public void setPic(int pic) {
        this.pic = pic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public int getPic() {
        return pic;
    }

    public String getTitle() {
        return title;
    }

    public int getSpeed() {
        return speed;
    }

    public String getInstrument() {
        return instrument;
    }

@Override
    public String toString(){
        return getTitle();
}

}
