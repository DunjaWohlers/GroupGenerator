package model;

public class Groups {
    Person[][] grps={new Person[0],new Person[0],new Person[0],new Person[0],new Person[0],new Person[0],new Person[0],new Person[0]};


    public Groups(Person[] persons, int groups){

        generateGroups(persons, groups);
    }


    public void generateGroups(Person[] persons, int groups){
        for (int i=0;i<grps.length;i++) {
            grps[i]=new Person [0];
        }

        int rest = persons.length%groups;
        int maxGroupMembers=(persons.length)/groups;

        int count=0;
        while (count<persons.length-rest){
            int rand = (int) (Math.random()*groups);
            if(this.grps[rand].length<maxGroupMembers) {
                addPersonToGroup(rand, persons[count]);
                count++;
            }
            else{
                System.out.println("mist!");
            }
        }
    }

    public void addPersonToGroup(int rand, Person pers){
        Person[] newGrp= new Person[this.grps[rand].length+1];
        newGrp[this.grps[rand].length]=pers;
        for (int i=0; i<newGrp.length-1;i++){
            newGrp[i]=this.grps[rand][i];
        }
        this.grps[rand]=newGrp;
    }


    public Person[][] getGrps() {
        return grps;
    }

    public void setGrps(Person[][] grps) {
        this.grps = grps;
    }
}
