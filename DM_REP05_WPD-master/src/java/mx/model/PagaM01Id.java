package mx.model;
// Generated 29/01/2021 12:11:55 PM by Hibernate Tools 4.3.1



/**
 * PagaM01Id generated by hbm2java
 */
public class PagaM01Id  implements java.io.Serializable {


     private String cveProv;
     private String refer;
     private int numCargo;
     private int numCpto;

    public PagaM01Id() {
    }

    public PagaM01Id(String cveProv, String refer, int numCargo, int numCpto) {
       this.cveProv = cveProv;
       this.refer = refer;
       this.numCargo = numCargo;
       this.numCpto = numCpto;
    }
   
    public String getCveProv() {
        return this.cveProv;
    }
    
    public void setCveProv(String cveProv) {
        this.cveProv = cveProv;
    }
    public String getRefer() {
        return this.refer;
    }
    
    public void setRefer(String refer) {
        this.refer = refer;
    }
    public int getNumCargo() {
        return this.numCargo;
    }
    
    public void setNumCargo(int numCargo) {
        this.numCargo = numCargo;
    }
    public int getNumCpto() {
        return this.numCpto;
    }
    
    public void setNumCpto(int numCpto) {
        this.numCpto = numCpto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PagaM01Id) ) return false;
		 PagaM01Id castOther = ( PagaM01Id ) other; 
         
		 return ( (this.getCveProv()==castOther.getCveProv()) || ( this.getCveProv()!=null && castOther.getCveProv()!=null && this.getCveProv().equals(castOther.getCveProv()) ) )
 && ( (this.getRefer()==castOther.getRefer()) || ( this.getRefer()!=null && castOther.getRefer()!=null && this.getRefer().equals(castOther.getRefer()) ) )
 && (this.getNumCargo()==castOther.getNumCargo())
 && (this.getNumCpto()==castOther.getNumCpto());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCveProv() == null ? 0 : this.getCveProv().hashCode() );
         result = 37 * result + ( getRefer() == null ? 0 : this.getRefer().hashCode() );
         result = 37 * result + this.getNumCargo();
         result = 37 * result + this.getNumCpto();
         return result;
   }   


}

