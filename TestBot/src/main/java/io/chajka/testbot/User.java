package io.chajka.testbot;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "userDataTable")
public class User {

    @Id
    private Long chatId;
    private String Name;
    private String UserName;
    private Boolean gender;
    private Boolean orient;
    private Boolean sex;
    private Integer yourcode;
    private Integer progress;
    private String pantstype;
    private String topestype;
    private String phonetype;
    private String shoestype;
    private String tattostype;
    private String pantscoolor;
    private String topescolor;
    private String soxcolor;
    private String shoescolor;
    private String undwcolor;
    private Short height;
    private Short weight;
    private Short shoessize;
    private String haircolor;
    private String bodytype;
    private String eyecolor;
    private String hobby;
    private String study;
    private String food;
    private String film;
    private String music;
    private Boolean watch;
    private Boolean ochechi;
    private Boolean pirce;
    private Boolean belt;
    private Boolean chain;
    private Boolean mustage;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getOrient() {
        return orient;
    }

    public void setOrient(Boolean orient) {
        this.orient = orient;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getYourcode() {
        return yourcode;
    }

    public void setYourcode(Integer yourcode) {
        this.yourcode = yourcode;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String getPantstype() {
        return pantstype;
    }

    public void setPantstype(String pantstype) {
        this.pantstype = pantstype;
    }

    public String getTopestype() {
        return topestype;
    }

    public void setTopestype(String topestype) {
        this.topestype = topestype;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public String getShoestype() {
        return shoestype;
    }

    public void setShoestype(String shoestype) {
        this.shoestype = shoestype;
    }

    public String getTattostype() {
        return tattostype;
    }

    public void setTattostype(String tattostype) {
        this.tattostype = tattostype;
    }

    public String getPantscoolor() {
        return pantscoolor;
    }

    public void setPantscoolor(String pantscoolor) {
        this.pantscoolor = pantscoolor;
    }

    public String getTopescolor() {
        return topescolor;
    }

    public void setTopescolor(String topescolor) {
        this.topescolor = topescolor;
    }

    public String getSoxcolor() {
        return soxcolor;
    }

    public void setSoxcolor(String soxcolor) {
        this.soxcolor = soxcolor;
    }

    public String getShoescolor() {
        return shoescolor;
    }

    public void setShoescolor(String shoescolor) {
        this.shoescolor = shoescolor;
    }

    public String getUndwcolor() {
        return undwcolor;
    }

    public void setUndwcolor(String undwcolor) {
        this.undwcolor = undwcolor;
    }

    public Short getHeight() {
        return height;
    }

    public void setHeight(Short height) {
        this.height = height;
    }

    public Short getWeight() {
        return weight;
    }

    public void setWeight(Short weight) {
        this.weight = weight;
    }

    public Short getShoessize() {
        return shoessize;
    }

    public void setShoessize(Short shoessize) {
        this.shoessize = shoessize;
    }

    public String getHaircolor() {
        return haircolor;
    }

    public void setHaircolor(String haircolor) {
        this.haircolor = haircolor;
    }

    public String getBodytype() {
        return bodytype;
    }

    public void setBodytype(String bodytype) {
        this.bodytype = bodytype;
    }

    public String getEyecolor() {
        return eyecolor;
    }

    public void setEyecolor(String eyecolor) {
        this.eyecolor = eyecolor;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public Boolean getWatch() {
        return watch;
    }

    public void setWatch(Boolean watch) {
        this.watch = watch;
    }

    public Boolean getOchechi() {
        return ochechi;
    }

    public void setOchechi(Boolean ochechi) {
        this.ochechi = ochechi;
    }

    public Boolean getPirce() {
        return pirce;
    }

    public void setPirce(Boolean pirce) {
        this.pirce = pirce;
    }

    public Boolean getBelt() {
        return belt;
    }

    public void setBelt(Boolean belt) {
        this.belt = belt;
    }

    public Boolean getChain() {
        return chain;
    }

    public void setChain(Boolean chain) {
        this.chain = chain;
    }

    public Boolean getMustage() {
        return mustage;
    }

    public void setMustage(Boolean mustage) {
        this.mustage = mustage;
    }

    public Boolean getCatdogs() {
        return catdogs;
    }

    public void setCatdogs(Boolean catdogs) {
        this.catdogs = catdogs;
    }

    public Boolean getTeacoffie() {
        return teacoffie;
    }

    public void setTeacoffie(Boolean teacoffie) {
        this.teacoffie = teacoffie;
    }

    public Boolean getCookinglike() {
        return cookinglike;
    }

    public void setCookinglike(Boolean cookinglike) {
        this.cookinglike = cookinglike;
    }

    public Boolean getDrunking() {
        return drunking;
    }

    public void setDrunking(Boolean drunking) {
        this.drunking = drunking;
    }

    public Boolean getHomeornot() {
        return homeornot;
    }

    public void setHomeornot(Boolean homeornot) {
        this.homeornot = homeornot;
    }

    public Boolean getTechorhum() {
        return techorhum;
    }

    public void setTechorhum(Boolean techorhum) {
        this.techorhum = techorhum;
    }

    public Long getChosetime() {
        return chosetime;
    }

    public void setChosetime(Long chosetime) {
        this.chosetime = chosetime;
    }

    private Boolean catdogs;
    private Boolean teacoffie;
    private Boolean cookinglike;
    private Boolean drunking;
    private Boolean homeornot;
    private Boolean techorhum;
    private Long chosetime;



}
