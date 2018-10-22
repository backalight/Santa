package com.capi.santa;

public class Adulte {

        private String prenom;





        public Adulte() {
            super();
        }

        public Adulte(String prenom) {
            super();
            this.prenom = prenom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        @Override
        public String toString() {
            return  prenom ;
        }

    }


