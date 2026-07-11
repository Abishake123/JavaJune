package AnimalEncapsulation;
public class Animal {

    public String name;

    public Boolean isCarnivore;

    public Integer lifeSpan;

    private Boolean isEddible;

    public Boolean getIsEddible() {
        return isEddible;
    }

    public void setIsEddible(Boolean isEddible) {
        this.isEddible = isEddible;
    }

    public void updateIsEddible(Boolean flag,String password){
        if(password.equals("ANI")){
            isEddible = flag;
        }else{
            isEddible = null;
        }
        
    }

    public Boolean returnIsEddible(){
        return isEddible;
    }

    @Override
    public String toString() {
        return "Animal {name=" + name + ", isCarnivore=" + isCarnivore + ", lifeSpan=" + lifeSpan + "}";
    }


   
    
}
