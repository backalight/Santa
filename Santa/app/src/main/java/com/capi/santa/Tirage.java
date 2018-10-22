package com.capi.santa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Tirage {
    private List<Enfant> listChild = new ArrayList<Enfant>();
    private List<Adulte> listAdult = new ArrayList<Adulte>();
    private Map<Adulte, List<Adulte>> tirageMapAdult = new HashMap<>();
    private Map<Enfant, List<Adulte>> tirageMapEnfant = new HashMap<>();
    private Set<String> historicAdult = new HashSet<>();
    private Set<String> historicChild = new HashSet<>();



//################################CONSTRUCTEUR########################################################################

    public Tirage() {
        super();
    }

//##############################################METHODS##################################################################

    public void listerEnfant(Enfant... enfants) {

        for (Enfant e : enfants) {

            if (listChild.contains(e)) {
                String doublon = e.getPrenom();
                System.out.printf("%s deja dans liste\n", doublon);
            }

            else {
                listChild.add(e);
            }
        }

    }

    public void listerAdulte(Adulte... adultes) {

        for (Adulte a : adultes) {
            if (listAdult.contains(a)) {
                String doublon = a.getPrenom();
                System.out.printf("%s deja dans liste\n", doublon);
            }

            else {
                listAdult.add(a);
            }
        }
    }

    public String enfantToString() {
        StringBuilder str = new StringBuilder();
        Iterator<Enfant> it = listChild.iterator();
        while (it.hasNext()) {
            str.append(it.next().getPrenom()).append("\n");

        }
        return "\n" + str.toString();

    }

    public String adulteToString() {

        StringBuilder str = new StringBuilder();
        Iterator<Adulte> it = listAdult.iterator();
        while (it.hasNext()) {
            str.append(it.next().getPrenom()).append("\n");

        }
        return "\n" + str.toString();
    }

    public void creerListeTirageDesAdultes(Adulte prenom, Adulte... adultes) {
        StringBuilder str = new StringBuilder();
        List<Adulte> tirAdultAdult = new ArrayList<>();
        for (Adulte a : adultes) {
            tirAdultAdult.add(a);
            str.append(a.getPrenom()).append("| ");
        }

        tirageMapAdult.put(prenom, tirAdultAdult);
        System.out.println("\nPour " + prenom.getPrenom() + " les tirages adultes possibles sont :\n" + str.toString());

    }

    public void creerListeTirageDesEnfants(Enfant prenom, Adulte... adult) {
        StringBuilder str = new StringBuilder();
        List<Adulte> tirAdultEnfant = new ArrayList<>();
        for (Adulte a : adult) {
            tirAdultEnfant.add(a);
            str.append(a.getPrenom()).append("| ");
        }

        tirageMapEnfant.put(prenom, tirAdultEnfant);
        System.out.println("\nPour " + prenom.getPrenom() + " les tirages enfants possibles sont :\n" + str.toString());

    }

    public String TirageAdulte(Adulte prenom) {
        StringBuilder str = new StringBuilder();

        Adulte nomChoisi = new Adulte();
        Random r = new Random();

        do {
            int index = r.nextInt(tirageMapAdult.get(prenom).size());
            nomChoisi.setPrenom(tirageMapAdult.get(prenom).get(index).getPrenom());
            // System.out.println(nomChoisi.getPrenom());
        } while (historicAdult.contains(nomChoisi.getPrenom()));
        historicAdult.add(nomChoisi.getPrenom());
//
//		for (String a : historicAdult) {
//			System.out.print("+" + a + "+\n");

//		}

        str .append("\n ").append(nomChoisi.getPrenom()).append("\n recevra un cadeau de ").append(prenom.getPrenom()).append("\n");
        return  str.toString();
    }

    public String tirageEnfant(Enfant prenom) {
        StringBuilder str = new StringBuilder();
        Adulte nomChoisi = new Adulte();
        Adulte nomChoisi2= new Adulte();
        Random r = new Random();

        do {
            int index = r.nextInt(tirageMapEnfant.get(prenom).size());
            nomChoisi.setPrenom(tirageMapEnfant.get(prenom).get(index).getPrenom());
            // System.out.println(nomChoisi.getPrenom());
        } while (historicChild.contains(nomChoisi.getPrenom()));
        historicChild.add(nomChoisi.getPrenom());

         str .append("\n ").append( prenom.getPrenom()).append("\n recevra un cadeau de ").append(nomChoisi.getPrenom()).append("\n");
        return  str.toString();
    }










//#######################################GETTER/SETTER#################################################################

    public List<Enfant> getListChild() {
        return listChild;
    }

    public void setListChild(List<Enfant> listChild) {
        this.listChild = listChild;
    }

    public List<Adulte> getListAdult() {
        return listAdult;
    }

    public void setListAdult(List<Adulte> listAdult) {
        this.listAdult = listAdult;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((historicAdult == null) ? 0 : historicAdult.hashCode());
        result = prime * result + ((listAdult == null) ? 0 : listAdult.hashCode());
        result = prime * result + ((listChild == null) ? 0 : listChild.hashCode());
        result = prime * result + ((tirageMapAdult == null) ? 0 : tirageMapAdult.hashCode());
        result = prime * result + ((tirageMapEnfant == null) ? 0 : tirageMapEnfant.hashCode());
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
        Tirage other = (Tirage) obj;
        if (historicAdult == null) {
            if (other.historicAdult != null)
                return false;
        } else if (!historicAdult.equals(other.historicAdult))
            return false;
        if (listAdult == null) {
            if (other.listAdult != null)
                return false;
        } else if (!listAdult.equals(other.listAdult))
            return false;
        if (listChild == null) {
            if (other.listChild != null)
                return false;
        } else if (!listChild.equals(other.listChild))
            return false;
        if (tirageMapAdult == null) {
            if (other.tirageMapAdult != null)
                return false;
        } else if (!tirageMapAdult.equals(other.tirageMapAdult))
            return false;
        if (tirageMapEnfant == null) {
            if (other.tirageMapEnfant != null)
                return false;
        } else if (!tirageMapEnfant.equals(other.tirageMapEnfant))
            return false;
        return true;
    }
}
