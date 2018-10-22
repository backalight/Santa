package com.capi.santa;

public class Enfant {
    private String prenom;



    public Enfant(String prenom) {
        super();
        this.prenom = prenom;
    }












    public Enfant() {
    }












    public String getPrenom() {
        return prenom;
    }



    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }





    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
        return result;
    }





    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Enfant other = (Enfant) obj;
        if (prenom == null) {
            if (other.prenom != null)
                return false;
        } else if (!prenom.equals(other.prenom))
            return false;
        return true;
    }





    @Override
    public String toString() {
        return "Enfant" +prenom;
    }
}
