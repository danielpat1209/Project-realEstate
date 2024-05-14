public class City {
    private String cityName;
    private String geographicDistrict;
    private String[] cityStreetList;



    public String toString(){
        return this.cityName+ " " + this.geographicDistrict;
    }

    public String getCityName() {
        return cityName;
    }

    public String getGeographicDistrict() {
        return geographicDistrict;
    }

    public String[] getCityStreetList() {
        return cityStreetList;
    }

    public City(String cityName, String geographicDistrict){
        this.cityName=cityName;
        this.geographicDistrict=geographicDistrict;
        this.cityStreetList=new String[0];

    }
    public boolean streetExist(String streetName){
        boolean exist=false;
        for (int i=0;i<this.cityStreetList.length;i++){
            if (cityStreetList[i].equals(streetName)){
                exist=true;
            }

        }

        return exist;
    }
    public void printStreets(){
        for (int i=0;i<cityStreetList.length;i++){
            System.out.println(i+1+"."+cityStreetList[i]);
        }
    }


}
