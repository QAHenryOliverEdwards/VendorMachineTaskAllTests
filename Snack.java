package vendormachine.vendors.item;

public class Snack implements Item{

    public String name;
    private float price;

    public Snack(float creditCost){
        this.price = creditCost;
    }

    public Snack(String name, float creditCost){
        this.name = name;
        this.price = creditCost;
    }
    
	//==================
	//===	Methods
	//==================

    public float cost(){
        return this.price;
    }

    public void setValue(float cost){
        this.price = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Snack{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
