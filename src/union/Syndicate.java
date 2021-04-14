package union;

public class Syndicate {
   private int syndicateID = -1;
   private Taxes taxe;

   public Syndicate(int syndicateID, Taxes taxe){

      this.syndicateID = syndicateID;
      this.taxe = taxe;
     
   }

   public void setSyndicateID(int syndicateID) {
      this.syndicateID = syndicateID;
   }

   public int getSyndicateID(){
      return syndicateID;
   }

   public void setTaxes(Taxes taxe) {
      this.taxe = taxe;
   }

   public Taxes getTaxes() {
      return taxe;
   }
}
