package LessonT8.personal_data;

public class Human {
    private String name;
    private String birthday;
    private String phone;
    private String country;
    private String city;
    private String adress;

    Human(){}

//    Human (String firstname, String birthday, String phone, String country, String city, String adress){
//        this.name=firstname;
//        this.birthday=birthday;
//        this.phone=phone;
//        this.country=country;
//        this.city=city;
//        this.adress=adress;
//    }


    public Human(String name, String birthday, String phone, String country, String city, String adress) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.adress = adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printInfo(){
        System.out.println("************** Персональные данные ***************");
        System.out.println("Имя: "+this.name);
        System.out.println("Дата рождения: "+this.birthday);
        System.out.println("Номер телефона: "+this.phone);
        System.out.println("Страна: "+this.country);
        System.out.println("Город: "+this.city);
        System.out.println("Домашний адрес: "+this.adress);
        System.out.println("**************************************************");
    }
}
