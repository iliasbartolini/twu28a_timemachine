    package com.thoughtworks.twu.domain;

    import org.hibernate.annotations.GenericGenerator;

    import javax.persistence.*;
    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Table( name = "countries" )
    public class Country {
        public int id;

        private List<State> states= new ArrayList<State>();


        @Id
        @GeneratedValue(generator="id")
        @GenericGenerator(name="id", strategy = "increment")
        public int getId() {
            return id;
        }

        public void setStates(List<State> states) {
            this.states = states;
        }


        //@JoinColumn(name = "COUNTRY_CODE", nullable = true)
        //@JoinTable(name = "COUNTRIES", joinColumns = { @JoinColumn(name = "COUNTRY_CODE") }, inverseJoinColumns = { @JoinColumn(name = "STATE") })
        @OneToMany(mappedBy = "country_code")
        public List<State> getStates() {
            return states;
        }


        public void setId(int id) {
            this.id = id;
        }


        private String country_code;
        private String country_name;

        public String getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getCountry_name() {
            return country_name;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
        }


    }
